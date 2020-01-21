package it.contrader.web.rest;

import com.codahale.metrics.annotation.Timed;
import it.contrader.service.ProvaService;
import it.contrader.web.rest.errors.BadRequestAlertException;
import it.contrader.web.rest.util.HeaderUtil;
import it.contrader.web.rest.util.PaginationUtil;
import it.contrader.service.dto.ProvaDTO;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing Prova.
 */
@RestController
@RequestMapping("/api")
public class ProvaResource {

    private final Logger log = LoggerFactory.getLogger(ProvaResource.class);

    private static final String ENTITY_NAME = "micro1Prova";

    private final ProvaService provaService;

    public ProvaResource(ProvaService provaService) {
        this.provaService = provaService;
    }

    /**
     * POST  /prova : Create a new prova.
     *
     * @param provaDTO the provaDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new provaDTO, or with status 400 (Bad Request) if the prova has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/prova")
    @Timed
    public ResponseEntity<ProvaDTO> createProva(@RequestBody ProvaDTO provaDTO) throws URISyntaxException {
        log.debug("REST request to save Prova : {}", provaDTO);
        if (provaDTO.getId() != null) {
            throw new BadRequestAlertException("A new prova cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ProvaDTO result = provaService.save(provaDTO);
        return ResponseEntity.created(new URI("/api/prova/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /prova : Updates an existing prova.
     *
     * @param provaDTO the provaDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated provaDTO,
     * or with status 400 (Bad Request) if the provaDTO is not valid,
     * or with status 500 (Internal Server Error) if the provaDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/prova")
    @Timed
    public ResponseEntity<ProvaDTO> updateProva(@RequestBody ProvaDTO provaDTO) throws URISyntaxException {
        log.debug("REST request to update Prova : {}", provaDTO);
        if (provaDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        ProvaDTO result = provaService.save(provaDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, provaDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /prova : get all the prova.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of prova in body
     */
    @GetMapping("/prova")
    @Timed
    public ResponseEntity<List<ProvaDTO>> getAllProva(Pageable pageable) {
        log.debug("REST request to get a page of Prova");
        Page<ProvaDTO> page = provaService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/prova");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /prova/:id : get the "id" prova.
     *
     * @param id the id of the provaDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the provaDTO, or with status 404 (Not Found)
     */
    @GetMapping("/prova/{id}")
    @Timed
    public ResponseEntity<ProvaDTO> getProva(@PathVariable Long id) {
        log.debug("REST request to get Prova : {}", id);
        Optional<ProvaDTO> provaDTO = provaService.findOne(id);
        return ResponseUtil.wrapOrNotFound(provaDTO);
    }

    /**
     * DELETE  /prova/:id : delete the "id" prova.
     *
     * @param id the id of the provaDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/prova/{id}")
    @Timed
    public ResponseEntity<Void> deleteProva(@PathVariable Long id) {
        log.debug("REST request to delete Prova : {}", id);
        provaService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
