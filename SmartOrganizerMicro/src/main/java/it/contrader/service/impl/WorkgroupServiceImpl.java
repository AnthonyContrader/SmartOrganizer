package it.contrader.service.impl;

import it.contrader.service.WorkgroupService;
import it.contrader.domain.Workgroup;
import it.contrader.repository.WorkgroupRepository;
import it.contrader.service.dto.WorkgroupDTO;
import it.contrader.service.mapper.WorkgroupMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;
/**
 * Service Implementation for managing Workgroup.
 */
@Service
@Transactional
public class WorkgroupServiceImpl implements WorkgroupService {

    private final Logger log = LoggerFactory.getLogger(WorkgroupServiceImpl.class);

    private final WorkgroupRepository workgroupRepository;

    private final WorkgroupMapper workgroupMapper;

    public WorkgroupServiceImpl(WorkgroupRepository workgroupRepository, WorkgroupMapper workgroupMapper) {
        this.workgroupRepository = workgroupRepository;
        this.workgroupMapper = workgroupMapper;
    }

    /**
     * Save a workgroup.
     *
     * @param workgroupDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public WorkgroupDTO save(WorkgroupDTO workgroupDTO) {
        log.debug("Request to save Workgroup : {}", workgroupDTO);
        Workgroup workgroup = workgroupMapper.toEntity(workgroupDTO);
        workgroup = workgroupRepository.save(workgroup);
        return workgroupMapper.toDto(workgroup);
    }

    /**
     * Get all the workgroups.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<WorkgroupDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Workgroups");
        return workgroupRepository.findAll(pageable)
            .map(workgroupMapper::toDto);
    }


    /**
     * Get one workgroup by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<WorkgroupDTO> findOne(Long id) {
        log.debug("Request to get Workgroup : {}", id);
        return workgroupRepository.findById(id)
            .map(workgroupMapper::toDto);
    }

    /**
     * Delete the workgroup by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Workgroup : {}", id);
        workgroupRepository.deleteById(id);
    }
}
