package it.contrader.web.rest;

import it.contrader.SmartOrganizerMicroApp;

import it.contrader.domain.Tool;
import it.contrader.repository.ToolRepository;
import it.contrader.service.ToolService;
import it.contrader.service.dto.ToolDTO;
import it.contrader.service.mapper.ToolMapper;
import it.contrader.web.rest.errors.ExceptionTranslator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;


import static it.contrader.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for the ToolResource REST controller.
 *
 * @see ToolResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SmartOrganizerMicroApp.class)
public class ToolResourceIntTest {

    private static final String DEFAULT_TOOLNAME = "AAAAAAAAAA";
    private static final String UPDATED_TOOLNAME = "BBBBBBBBBB";

    private static final String DEFAULT_RAWMATERIAL = "AAAAAAAAAA";
    private static final String UPDATED_RAWMATERIAL = "BBBBBBBBBB";

    private static final Integer DEFAULT_LIFETIME = 1;
    private static final Integer UPDATED_LIFETIME = 2;

    @Autowired
    private ToolRepository toolRepository;


    @Autowired
    private ToolMapper toolMapper;
    

    @Autowired
    private ToolService toolService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restToolMockMvc;

    private Tool tool;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final ToolResource toolResource = new ToolResource(toolService);
        this.restToolMockMvc = MockMvcBuilders.standaloneSetup(toolResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setControllerAdvice(exceptionTranslator)
            .setConversionService(createFormattingConversionService())
            .setMessageConverters(jacksonMessageConverter).build();
    }

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Tool createEntity(EntityManager em) {
        Tool tool = new Tool()
            .toolname(DEFAULT_TOOLNAME)
            .rawmaterial(DEFAULT_RAWMATERIAL)
            .lifetime(DEFAULT_LIFETIME);
        return tool;
    }

    @Before
    public void initTest() {
        tool = createEntity(em);
    }

    @Test
    @Transactional
    public void createTool() throws Exception {
        int databaseSizeBeforeCreate = toolRepository.findAll().size();

        // Create the Tool
        ToolDTO toolDTO = toolMapper.toDto(tool);
        restToolMockMvc.perform(post("/api/tools")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(toolDTO)))
            .andExpect(status().isCreated());

        // Validate the Tool in the database
        List<Tool> toolList = toolRepository.findAll();
        assertThat(toolList).hasSize(databaseSizeBeforeCreate + 1);
        Tool testTool = toolList.get(toolList.size() - 1);
        assertThat(testTool.getToolname()).isEqualTo(DEFAULT_TOOLNAME);
        assertThat(testTool.getRawmaterial()).isEqualTo(DEFAULT_RAWMATERIAL);
        assertThat(testTool.getLifetime()).isEqualTo(DEFAULT_LIFETIME);
    }

    @Test
    @Transactional
    public void createToolWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = toolRepository.findAll().size();

        // Create the Tool with an existing ID
        tool.setId(1L);
        ToolDTO toolDTO = toolMapper.toDto(tool);

        // An entity with an existing ID cannot be created, so this API call must fail
        restToolMockMvc.perform(post("/api/tools")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(toolDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Tool in the database
        List<Tool> toolList = toolRepository.findAll();
        assertThat(toolList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllTools() throws Exception {
        // Initialize the database
        toolRepository.saveAndFlush(tool);

        // Get all the toolList
        restToolMockMvc.perform(get("/api/tools?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(tool.getId().intValue())))
            .andExpect(jsonPath("$.[*].toolname").value(hasItem(DEFAULT_TOOLNAME.toString())))
            .andExpect(jsonPath("$.[*].rawmaterial").value(hasItem(DEFAULT_RAWMATERIAL.toString())))
            .andExpect(jsonPath("$.[*].lifetime").value(hasItem(DEFAULT_LIFETIME)));
    }
    

    @Test
    @Transactional
    public void getTool() throws Exception {
        // Initialize the database
        toolRepository.saveAndFlush(tool);

        // Get the tool
        restToolMockMvc.perform(get("/api/tools/{id}", tool.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(tool.getId().intValue()))
            .andExpect(jsonPath("$.toolname").value(DEFAULT_TOOLNAME.toString()))
            .andExpect(jsonPath("$.rawmaterial").value(DEFAULT_RAWMATERIAL.toString()))
            .andExpect(jsonPath("$.lifetime").value(DEFAULT_LIFETIME));
    }
    @Test
    @Transactional
    public void getNonExistingTool() throws Exception {
        // Get the tool
        restToolMockMvc.perform(get("/api/tools/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateTool() throws Exception {
        // Initialize the database
        toolRepository.saveAndFlush(tool);

        int databaseSizeBeforeUpdate = toolRepository.findAll().size();

        // Update the tool
        Tool updatedTool = toolRepository.findById(tool.getId()).get();
        // Disconnect from session so that the updates on updatedTool are not directly saved in db
        em.detach(updatedTool);
        updatedTool
            .toolname(UPDATED_TOOLNAME)
            .rawmaterial(UPDATED_RAWMATERIAL)
            .lifetime(UPDATED_LIFETIME);
        ToolDTO toolDTO = toolMapper.toDto(updatedTool);

        restToolMockMvc.perform(put("/api/tools")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(toolDTO)))
            .andExpect(status().isOk());

        // Validate the Tool in the database
        List<Tool> toolList = toolRepository.findAll();
        assertThat(toolList).hasSize(databaseSizeBeforeUpdate);
        Tool testTool = toolList.get(toolList.size() - 1);
        assertThat(testTool.getToolname()).isEqualTo(UPDATED_TOOLNAME);
        assertThat(testTool.getRawmaterial()).isEqualTo(UPDATED_RAWMATERIAL);
        assertThat(testTool.getLifetime()).isEqualTo(UPDATED_LIFETIME);
    }

    @Test
    @Transactional
    public void updateNonExistingTool() throws Exception {
        int databaseSizeBeforeUpdate = toolRepository.findAll().size();

        // Create the Tool
        ToolDTO toolDTO = toolMapper.toDto(tool);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException 
        restToolMockMvc.perform(put("/api/tools")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(toolDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Tool in the database
        List<Tool> toolList = toolRepository.findAll();
        assertThat(toolList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteTool() throws Exception {
        // Initialize the database
        toolRepository.saveAndFlush(tool);

        int databaseSizeBeforeDelete = toolRepository.findAll().size();

        // Get the tool
        restToolMockMvc.perform(delete("/api/tools/{id}", tool.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<Tool> toolList = toolRepository.findAll();
        assertThat(toolList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Tool.class);
        Tool tool1 = new Tool();
        tool1.setId(1L);
        Tool tool2 = new Tool();
        tool2.setId(tool1.getId());
        assertThat(tool1).isEqualTo(tool2);
        tool2.setId(2L);
        assertThat(tool1).isNotEqualTo(tool2);
        tool1.setId(null);
        assertThat(tool1).isNotEqualTo(tool2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(ToolDTO.class);
        ToolDTO toolDTO1 = new ToolDTO();
        toolDTO1.setId(1L);
        ToolDTO toolDTO2 = new ToolDTO();
        assertThat(toolDTO1).isNotEqualTo(toolDTO2);
        toolDTO2.setId(toolDTO1.getId());
        assertThat(toolDTO1).isEqualTo(toolDTO2);
        toolDTO2.setId(2L);
        assertThat(toolDTO1).isNotEqualTo(toolDTO2);
        toolDTO1.setId(null);
        assertThat(toolDTO1).isNotEqualTo(toolDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(toolMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(toolMapper.fromId(null)).isNull();
    }
}
