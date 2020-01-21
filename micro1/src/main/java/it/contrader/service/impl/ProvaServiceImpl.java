package it.contrader.service.impl;

import it.contrader.service.ProvaService;
import it.contrader.domain.Prova;
import it.contrader.repository.ProvaRepository;
import it.contrader.service.dto.ProvaDTO;
import it.contrader.service.mapper.ProvaMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;
/**
 * Service Implementation for managing Prova.
 */
@Service
@Transactional
public class ProvaServiceImpl implements ProvaService {

    private final Logger log = LoggerFactory.getLogger(ProvaServiceImpl.class);

    private final ProvaRepository provaRepository;

    private final ProvaMapper provaMapper;

    public ProvaServiceImpl(ProvaRepository provaRepository, ProvaMapper provaMapper) {
        this.provaRepository = provaRepository;
        this.provaMapper = provaMapper;
    }

    /**
     * Save a prova.
     *
     * @param provaDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public ProvaDTO save(ProvaDTO provaDTO) {
        log.debug("Request to save Prova : {}", provaDTO);
        Prova prova = provaMapper.toEntity(provaDTO);
        prova = provaRepository.save(prova);
        return provaMapper.toDto(prova);
    }

    /**
     * Get all the prova.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<ProvaDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Prova");
        return provaRepository.findAll(pageable)
            .map(provaMapper::toDto);
    }


    /**
     * Get one prova by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<ProvaDTO> findOne(Long id) {
        log.debug("Request to get Prova : {}", id);
        return provaRepository.findById(id)
            .map(provaMapper::toDto);
    }

    /**
     * Delete the prova by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Prova : {}", id);
        provaRepository.deleteById(id);
    }
}
