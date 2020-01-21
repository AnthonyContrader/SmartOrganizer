package it.contrader.service.mapper;

import it.contrader.domain.*;
import it.contrader.service.dto.ProvaDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Prova and its DTO ProvaDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ProvaMapper extends EntityMapper<ProvaDTO, Prova> {



    default Prova fromId(Long id) {
        if (id == null) {
            return null;
        }
        Prova prova = new Prova();
        prova.setId(id);
        return prova;
    }
}
