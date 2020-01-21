package it.contrader.web.rest;

import it.contrader.Micro1App;

import it.contrader.domain.Workgroup;
import it.contrader.repository.WorkgroupRepository;
import it.contrader.service.WorkgroupService;
import it.contrader.service.dto.WorkgroupDTO;
import it.contrader.service.mapper.WorkgroupMapper;
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
 * Test class for the WorkgroupResource REST controller.
 *
 * @see WorkgroupResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Micro1App.class)
public class WorkgroupResourceIntTest {

    private static final String DEFAULT_NAME = "AAAAAAAAAA";
    private static final String UPDATED_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_MEMBERS = "AAAAAAAAAA";
    private static final String UPDATED_MEMBERS = "BBBBBBBBBB";

    private static final String DEFAULT_RESPONSIBLE = "AAAAAAAAAA";
    private static final String UPDATED_RESPONSIBLE = "BBBBBBBBBB";

    private static final String DEFAULT_WORK = "AAAAAAAAAA";
    private static final String UPDATED_WORK = "BBBBBBBBBB";

    @Autowired
    private WorkgroupRepository workgroupRepository;

    @Autowired
    private WorkgroupMapper workgroupMapper;
    
    @Autowired
    private WorkgroupService workgroupService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restWorkgroupMockMvc;

    private Workgroup workgroup;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final WorkgroupResource workgroupResource = new WorkgroupResource(workgroupService);
        this.restWorkgroupMockMvc = MockMvcBuilders.standaloneSetup(workgroupResource)
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
    public static Workgroup createEntity(EntityManager em) {
        Workgroup workgroup = new Workgroup()
            .name(DEFAULT_NAME)
            .members(DEFAULT_MEMBERS)
            .responsible(DEFAULT_RESPONSIBLE)
            .work(DEFAULT_WORK);
        return workgroup;
    }

    @Before
    public void initTest() {
        workgroup = createEntity(em);
    }

    @Test
    @Transactional
    public void createWorkgroup() throws Exception {
        int databaseSizeBeforeCreate = workgroupRepository.findAll().size();

        // Create the Workgroup
        WorkgroupDTO workgroupDTO = workgroupMapper.toDto(workgroup);
        restWorkgroupMockMvc.perform(post("/api/workgroups")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(workgroupDTO)))
            .andExpect(status().isCreated());

        // Validate the Workgroup in the database
        List<Workgroup> workgroupList = workgroupRepository.findAll();
        assertThat(workgroupList).hasSize(databaseSizeBeforeCreate + 1);
        Workgroup testWorkgroup = workgroupList.get(workgroupList.size() - 1);
        assertThat(testWorkgroup.getName()).isEqualTo(DEFAULT_NAME);
        assertThat(testWorkgroup.getMembers()).isEqualTo(DEFAULT_MEMBERS);
        assertThat(testWorkgroup.getResponsible()).isEqualTo(DEFAULT_RESPONSIBLE);
        assertThat(testWorkgroup.getWork()).isEqualTo(DEFAULT_WORK);
    }

    @Test
    @Transactional
    public void createWorkgroupWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = workgroupRepository.findAll().size();

        // Create the Workgroup with an existing ID
        workgroup.setId(1L);
        WorkgroupDTO workgroupDTO = workgroupMapper.toDto(workgroup);

        // An entity with an existing ID cannot be created, so this API call must fail
        restWorkgroupMockMvc.perform(post("/api/workgroups")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(workgroupDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Workgroup in the database
        List<Workgroup> workgroupList = workgroupRepository.findAll();
        assertThat(workgroupList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllWorkgroups() throws Exception {
        // Initialize the database
        workgroupRepository.saveAndFlush(workgroup);

        // Get all the workgroupList
        restWorkgroupMockMvc.perform(get("/api/workgroups?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(workgroup.getId().intValue())))
            .andExpect(jsonPath("$.[*].name").value(hasItem(DEFAULT_NAME.toString())))
            .andExpect(jsonPath("$.[*].members").value(hasItem(DEFAULT_MEMBERS.toString())))
            .andExpect(jsonPath("$.[*].responsible").value(hasItem(DEFAULT_RESPONSIBLE.toString())))
            .andExpect(jsonPath("$.[*].work").value(hasItem(DEFAULT_WORK.toString())));
    }
    
    @Test
    @Transactional
    public void getWorkgroup() throws Exception {
        // Initialize the database
        workgroupRepository.saveAndFlush(workgroup);

        // Get the workgroup
        restWorkgroupMockMvc.perform(get("/api/workgroups/{id}", workgroup.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(workgroup.getId().intValue()))
            .andExpect(jsonPath("$.name").value(DEFAULT_NAME.toString()))
            .andExpect(jsonPath("$.members").value(DEFAULT_MEMBERS.toString()))
            .andExpect(jsonPath("$.responsible").value(DEFAULT_RESPONSIBLE.toString()))
            .andExpect(jsonPath("$.work").value(DEFAULT_WORK.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingWorkgroup() throws Exception {
        // Get the workgroup
        restWorkgroupMockMvc.perform(get("/api/workgroups/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateWorkgroup() throws Exception {
        // Initialize the database
        workgroupRepository.saveAndFlush(workgroup);

        int databaseSizeBeforeUpdate = workgroupRepository.findAll().size();

        // Update the workgroup
        Workgroup updatedWorkgroup = workgroupRepository.findById(workgroup.getId()).get();
        // Disconnect from session so that the updates on updatedWorkgroup are not directly saved in db
        em.detach(updatedWorkgroup);
        updatedWorkgroup
            .name(UPDATED_NAME)
            .members(UPDATED_MEMBERS)
            .responsible(UPDATED_RESPONSIBLE)
            .work(UPDATED_WORK);
        WorkgroupDTO workgroupDTO = workgroupMapper.toDto(updatedWorkgroup);

        restWorkgroupMockMvc.perform(put("/api/workgroups")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(workgroupDTO)))
            .andExpect(status().isOk());

        // Validate the Workgroup in the database
        List<Workgroup> workgroupList = workgroupRepository.findAll();
        assertThat(workgroupList).hasSize(databaseSizeBeforeUpdate);
        Workgroup testWorkgroup = workgroupList.get(workgroupList.size() - 1);
        assertThat(testWorkgroup.getName()).isEqualTo(UPDATED_NAME);
        assertThat(testWorkgroup.getMembers()).isEqualTo(UPDATED_MEMBERS);
        assertThat(testWorkgroup.getResponsible()).isEqualTo(UPDATED_RESPONSIBLE);
        assertThat(testWorkgroup.getWork()).isEqualTo(UPDATED_WORK);
    }

    @Test
    @Transactional
    public void updateNonExistingWorkgroup() throws Exception {
        int databaseSizeBeforeUpdate = workgroupRepository.findAll().size();

        // Create the Workgroup
        WorkgroupDTO workgroupDTO = workgroupMapper.toDto(workgroup);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restWorkgroupMockMvc.perform(put("/api/workgroups")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(workgroupDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Workgroup in the database
        List<Workgroup> workgroupList = workgroupRepository.findAll();
        assertThat(workgroupList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteWorkgroup() throws Exception {
        // Initialize the database
        workgroupRepository.saveAndFlush(workgroup);

        int databaseSizeBeforeDelete = workgroupRepository.findAll().size();

        // Get the workgroup
        restWorkgroupMockMvc.perform(delete("/api/workgroups/{id}", workgroup.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<Workgroup> workgroupList = workgroupRepository.findAll();
        assertThat(workgroupList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Workgroup.class);
        Workgroup workgroup1 = new Workgroup();
        workgroup1.setId(1L);
        Workgroup workgroup2 = new Workgroup();
        workgroup2.setId(workgroup1.getId());
        assertThat(workgroup1).isEqualTo(workgroup2);
        workgroup2.setId(2L);
        assertThat(workgroup1).isNotEqualTo(workgroup2);
        workgroup1.setId(null);
        assertThat(workgroup1).isNotEqualTo(workgroup2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(WorkgroupDTO.class);
        WorkgroupDTO workgroupDTO1 = new WorkgroupDTO();
        workgroupDTO1.setId(1L);
        WorkgroupDTO workgroupDTO2 = new WorkgroupDTO();
        assertThat(workgroupDTO1).isNotEqualTo(workgroupDTO2);
        workgroupDTO2.setId(workgroupDTO1.getId());
        assertThat(workgroupDTO1).isEqualTo(workgroupDTO2);
        workgroupDTO2.setId(2L);
        assertThat(workgroupDTO1).isNotEqualTo(workgroupDTO2);
        workgroupDTO1.setId(null);
        assertThat(workgroupDTO1).isNotEqualTo(workgroupDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(workgroupMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(workgroupMapper.fromId(null)).isNull();
    }
}
