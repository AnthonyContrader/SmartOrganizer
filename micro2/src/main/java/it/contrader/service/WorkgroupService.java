package it.contrader.service;

import it.contrader.service.dto.WorkgroupDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing Workgroup.
 */
public interface WorkgroupService {

    /**
     * Save a workgroup.
     *
     * @param workgroupDTO the entity to save
     * @return the persisted entity
     */
    WorkgroupDTO save(WorkgroupDTO workgroupDTO);

    /**
     * Get all the workgroups.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<WorkgroupDTO> findAll(Pageable pageable);


    /**
     * Get the "id" workgroup.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<WorkgroupDTO> findOne(Long id);

    /**
     * Delete the "id" workgroup.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
