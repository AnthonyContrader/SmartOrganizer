package it.contrader.web.rest;

import com.codahale.metrics.annotation.Timed;
import it.contrader.service.CalendarService;
import it.contrader.web.rest.errors.BadRequestAlertException;
import it.contrader.web.rest.util.HeaderUtil;
import it.contrader.web.rest.util.PaginationUtil;
import it.contrader.service.dto.CalendarDTO;
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
 * REST controller for managing Calendar.
 */
@RestController
@RequestMapping("/api")
public class CalendarResource {

    private final Logger log = LoggerFactory.getLogger(CalendarResource.class);

    private static final String ENTITY_NAME = "calendar";

    private final CalendarService calendarService;

    public CalendarResource(CalendarService calendarService) {
        this.calendarService = calendarService;
    }

    /**
     * POST  /calendars : Create a new calendar.
     *
     * @param calendarDTO the calendarDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new calendarDTO, or with status 400 (Bad Request) if the calendar has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/calendars")
    @Timed
    public ResponseEntity<CalendarDTO> createCalendar(@RequestBody CalendarDTO calendarDTO) throws URISyntaxException {
        log.debug("REST request to save Calendar : {}", calendarDTO);
        if (calendarDTO.getId() != null) {
            throw new BadRequestAlertException("A new calendar cannot already have an ID", ENTITY_NAME, "idexists");
        }
        CalendarDTO result = calendarService.save(calendarDTO);
        return ResponseEntity.created(new URI("/api/calendars/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /calendars : Updates an existing calendar.
     *
     * @param calendarDTO the calendarDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated calendarDTO,
     * or with status 400 (Bad Request) if the calendarDTO is not valid,
     * or with status 500 (Internal Server Error) if the calendarDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/calendars")
    @Timed
    public ResponseEntity<CalendarDTO> updateCalendar(@RequestBody CalendarDTO calendarDTO) throws URISyntaxException {
        log.debug("REST request to update Calendar : {}", calendarDTO);
        if (calendarDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        CalendarDTO result = calendarService.save(calendarDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, calendarDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /calendars : get all the calendars.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of calendars in body
     */
    @GetMapping("/calendars")
    @Timed
    public ResponseEntity<List<CalendarDTO>> getAllCalendars(Pageable pageable) {
        log.debug("REST request to get a page of Calendars");
        Page<CalendarDTO> page = calendarService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/calendars");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /calendars/:id : get the "id" calendar.
     *
     * @param id the id of the calendarDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the calendarDTO, or with status 404 (Not Found)
     */
    @GetMapping("/calendars/{id}")
    @Timed
    public ResponseEntity<CalendarDTO> getCalendar(@PathVariable Long id) {
        log.debug("REST request to get Calendar : {}", id);
        Optional<CalendarDTO> calendarDTO = calendarService.findOne(id);
        return ResponseUtil.wrapOrNotFound(calendarDTO);
    }

    /**
     * DELETE  /calendars/:id : delete the "id" calendar.
     *
     * @param id the id of the calendarDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/calendars/{id}")
    @Timed
    public ResponseEntity<Void> deleteCalendar(@PathVariable Long id) {
        log.debug("REST request to delete Calendar : {}", id);
        calendarService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
