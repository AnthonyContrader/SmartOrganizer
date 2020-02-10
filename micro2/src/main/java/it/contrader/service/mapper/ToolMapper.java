package it.contrader.service.mapper;

import it.contrader.domain.*;
import it.contrader.service.dto.ToolDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Tool and its DTO ToolDTO.
 */
@Mapper(componentModel = "spring", uses = {EmployeeMapper.class})
public interface ToolMapper extends EntityMapper<ToolDTO, Tool> {

    @Mapping(source = "employee.id", target = "employeeId")
    ToolDTO toDto(Tool tool);

    @Mapping(source = "employeeId", target = "employee")
    Tool toEntity(ToolDTO toolDTO);

    default Tool fromId(Long id) {
        if (id == null) {
            return null;
        }
        Tool tool = new Tool();
        tool.setId(id);
        return tool;
    }
}
