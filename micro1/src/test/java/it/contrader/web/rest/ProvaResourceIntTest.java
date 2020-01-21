package it.contrader.web.rest;

import it.contrader.Micro1App;

import it.contrader.domain.Prova;
import it.contrader.repository.ProvaRepository;
import it.contrader.service.ProvaService;
import it.contrader.service.dto.ProvaDTO;
import it.contrader.service.mapper.ProvaMapper;
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
 * Test class for the ProvaResource REST controller.
 *
 * @see ProvaResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Micro1App.class)
public class ProvaResourceIntTest {

    private static final String DEFAULT_PROVA = "AAAAAAAAAA";
    private static final String UPDATED_PROVA = "BBBBBBBBBB";

    private static final String DEFAULT_NAME = "AAAAAAAAAA";
    private static final String UPDATED_NAME = "BBBBBBBBBB";

    @Autowired
    private ProvaRepository provaRepository;

    @Autowired
    private ProvaMapper provaMapper;
    
    @Autowired
    private ProvaService provaService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restProvaMockMvc;

    private Prova prova;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final ProvaResource provaResource = new ProvaResource(provaService);
        this.restProvaMockMvc = MockMvcBuilders.standaloneSetup(provaResource)
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
    public static Prova createEntity(EntityManager em) {
        Prova prova = new Prova()
            .prova(DEFAULT_PROVA)
            .name(DEFAULT_NAME);
        return prova;
    }

    @Before
    public void initTest() {
        prova = createEntity(em);
    }

    @Test
    @Transactional
    public void createProva() throws Exception {
        int databaseSizeBeforeCreate = provaRepository.findAll().size();

        // Create the Prova
        ProvaDTO provaDTO = provaMapper.toDto(prova);
        restProvaMockMvc.perform(post("/api/prova")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(provaDTO)))
            .andExpect(status().isCreated());

        // Validate the Prova in the database
        List<Prova> provaList = provaRepository.findAll();
        assertThat(provaList).hasSize(databaseSizeBeforeCreate + 1);
        Prova testProva = provaList.get(provaList.size() - 1);
        assertThat(testProva.getProva()).isEqualTo(DEFAULT_PROVA);
        assertThat(testProva.getName()).isEqualTo(DEFAULT_NAME);
    }

    @Test
    @Transactional
    public void createProvaWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = provaRepository.findAll().size();

        // Create the Prova with an existing ID
        prova.setId(1L);
        ProvaDTO provaDTO = provaMapper.toDto(prova);

        // An entity with an existing ID cannot be created, so this API call must fail
        restProvaMockMvc.perform(post("/api/prova")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(provaDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Prova in the database
        List<Prova> provaList = provaRepository.findAll();
        assertThat(provaList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllProva() throws Exception {
        // Initialize the database
        provaRepository.saveAndFlush(prova);

        // Get all the provaList
        restProvaMockMvc.perform(get("/api/prova?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(prova.getId().intValue())))
            .andExpect(jsonPath("$.[*].prova").value(hasItem(DEFAULT_PROVA.toString())))
            .andExpect(jsonPath("$.[*].name").value(hasItem(DEFAULT_NAME.toString())));
    }
    
    @Test
    @Transactional
    public void getProva() throws Exception {
        // Initialize the database
        provaRepository.saveAndFlush(prova);

        // Get the prova
        restProvaMockMvc.perform(get("/api/prova/{id}", prova.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(prova.getId().intValue()))
            .andExpect(jsonPath("$.prova").value(DEFAULT_PROVA.toString()))
            .andExpect(jsonPath("$.name").value(DEFAULT_NAME.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingProva() throws Exception {
        // Get the prova
        restProvaMockMvc.perform(get("/api/prova/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateProva() throws Exception {
        // Initialize the database
        provaRepository.saveAndFlush(prova);

        int databaseSizeBeforeUpdate = provaRepository.findAll().size();

        // Update the prova
        Prova updatedProva = provaRepository.findById(prova.getId()).get();
        // Disconnect from session so that the updates on updatedProva are not directly saved in db
        em.detach(updatedProva);
        updatedProva
            .prova(UPDATED_PROVA)
            .name(UPDATED_NAME);
        ProvaDTO provaDTO = provaMapper.toDto(updatedProva);

        restProvaMockMvc.perform(put("/api/prova")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(provaDTO)))
            .andExpect(status().isOk());

        // Validate the Prova in the database
        List<Prova> provaList = provaRepository.findAll();
        assertThat(provaList).hasSize(databaseSizeBeforeUpdate);
        Prova testProva = provaList.get(provaList.size() - 1);
        assertThat(testProva.getProva()).isEqualTo(UPDATED_PROVA);
        assertThat(testProva.getName()).isEqualTo(UPDATED_NAME);
    }

    @Test
    @Transactional
    public void updateNonExistingProva() throws Exception {
        int databaseSizeBeforeUpdate = provaRepository.findAll().size();

        // Create the Prova
        ProvaDTO provaDTO = provaMapper.toDto(prova);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restProvaMockMvc.perform(put("/api/prova")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(provaDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Prova in the database
        List<Prova> provaList = provaRepository.findAll();
        assertThat(provaList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteProva() throws Exception {
        // Initialize the database
        provaRepository.saveAndFlush(prova);

        int databaseSizeBeforeDelete = provaRepository.findAll().size();

        // Get the prova
        restProvaMockMvc.perform(delete("/api/prova/{id}", prova.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<Prova> provaList = provaRepository.findAll();
        assertThat(provaList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Prova.class);
        Prova prova1 = new Prova();
        prova1.setId(1L);
        Prova prova2 = new Prova();
        prova2.setId(prova1.getId());
        assertThat(prova1).isEqualTo(prova2);
        prova2.setId(2L);
        assertThat(prova1).isNotEqualTo(prova2);
        prova1.setId(null);
        assertThat(prova1).isNotEqualTo(prova2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(ProvaDTO.class);
        ProvaDTO provaDTO1 = new ProvaDTO();
        provaDTO1.setId(1L);
        ProvaDTO provaDTO2 = new ProvaDTO();
        assertThat(provaDTO1).isNotEqualTo(provaDTO2);
        provaDTO2.setId(provaDTO1.getId());
        assertThat(provaDTO1).isEqualTo(provaDTO2);
        provaDTO2.setId(2L);
        assertThat(provaDTO1).isNotEqualTo(provaDTO2);
        provaDTO1.setId(null);
        assertThat(provaDTO1).isNotEqualTo(provaDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(provaMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(provaMapper.fromId(null)).isNull();
    }
}
