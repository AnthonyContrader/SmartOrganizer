package it.contrader.service;

import it.contrader.service.dto.ToolDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing Tool.
 */
public interface ToolService {

    /**
     * Save a tool.
     *
     * @param toolDTO the entity to save
     * @return the persisted entity
     */
    ToolDTO save(ToolDTO toolDTO);

    /**
     * Get all the tools.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<ToolDTO> findAll(Pageable pageable);


    /**
     * Get the "id" tool.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<ToolDTO> findOne(Long id);

    /**
     * Delete the "id" tool.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
