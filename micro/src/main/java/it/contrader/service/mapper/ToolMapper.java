package it.contrader.service.mapper;

import it.contrader.domain.*;
import it.contrader.service.dto.ToolDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Tool and its DTO ToolDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ToolMapper extends EntityMapper<ToolDTO, Tool> {



    default Tool fromId(Long id) {
        if (id == null) {
            return null;
        }
        Tool tool = new Tool();
        tool.setId(id);
        return tool;
    }
}
