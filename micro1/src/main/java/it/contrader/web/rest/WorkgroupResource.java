package it.contrader.web.rest;

import com.codahale.metrics.annotation.Timed;
import it.contrader.service.WorkgroupService;
import it.contrader.web.rest.errors.BadRequestAlertException;
import it.contrader.web.rest.util.HeaderUtil;
import it.contrader.web.rest.util.PaginationUtil;
import it.contrader.service.dto.WorkgroupDTO;
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
 * REST controller for managing Workgroup.
 */
@RestController
@RequestMapping("/api")
public class WorkgroupResource {

    private final Logger log = LoggerFactory.getLogger(WorkgroupResource.class);

    private static final String ENTITY_NAME = "micro1Workgroup";

    private final WorkgroupService workgroupService;

    public WorkgroupResource(WorkgroupService workgroupService) {
        this.workgroupService = workgroupService;
    }

    /**
     * POST  /workgroups : Create a new workgroup.
     *
     * @param workgroupDTO the workgroupDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new workgroupDTO, or with status 400 (Bad Request) if the workgroup has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/workgroups")
    @Timed
    public ResponseEntity<WorkgroupDTO> createWorkgroup(@RequestBody WorkgroupDTO workgroupDTO) throws URISyntaxException {
        log.debug("REST request to save Workgroup : {}", workgroupDTO);
        if (workgroupDTO.getId() != null) {
            throw new BadRequestAlertException("A new workgroup cannot already have an ID", ENTITY_NAME, "idexists");
        }
        WorkgroupDTO result = workgroupService.save(workgroupDTO);
        return ResponseEntity.created(new URI("/api/workgroups/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /workgroups : Updates an existing workgroup.
     *
     * @param workgroupDTO the workgroupDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated workgroupDTO,
     * or with status 400 (Bad Request) if the workgroupDTO is not valid,
     * or with status 500 (Internal Server Error) if the workgroupDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/workgroups")
    @Timed
    public ResponseEntity<WorkgroupDTO> updateWorkgroup(@RequestBody WorkgroupDTO workgroupDTO) throws URISyntaxException {
        log.debug("REST request to update Workgroup : {}", workgroupDTO);
        if (workgroupDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        WorkgroupDTO result = workgroupService.save(workgroupDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, workgroupDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /workgroups : get all the workgroups.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of workgroups in body
     */
    @GetMapping("/workgroups")
    @Timed
    public ResponseEntity<List<WorkgroupDTO>> getAllWorkgroups(Pageable pageable) {
        log.debug("REST request to get a page of Workgroups");
        Page<WorkgroupDTO> page = workgroupService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/workgroups");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /workgroups/:id : get the "id" workgroup.
     *
     * @param id the id of the workgroupDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the workgroupDTO, or with status 404 (Not Found)
     */
    @GetMapping("/workgroups/{id}")
    @Timed
    public ResponseEntity<WorkgroupDTO> getWorkgroup(@PathVariable Long id) {
        log.debug("REST request to get Workgroup : {}", id);
        Optional<WorkgroupDTO> workgroupDTO = workgroupService.findOne(id);
        return ResponseUtil.wrapOrNotFound(workgroupDTO);
    }

    /**
     * DELETE  /workgroups/:id : delete the "id" workgroup.
     *
     * @param id the id of the workgroupDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/workgroups/{id}")
    @Timed
    public ResponseEntity<Void> deleteWorkgroup(@PathVariable Long id) {
        log.debug("REST request to delete Workgroup : {}", id);
        workgroupService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
