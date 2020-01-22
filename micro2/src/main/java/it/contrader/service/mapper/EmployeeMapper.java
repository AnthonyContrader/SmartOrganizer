package it.contrader.service.mapper;

import it.contrader.domain.*;
import it.contrader.service.dto.EmployeeDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Employee and its DTO EmployeeDTO.
 */
@Mapper(componentModel = "spring", uses = {WorkgroupMapper.class})
public interface EmployeeMapper extends EntityMapper<EmployeeDTO, Employee> {

    @Mapping(source = "workgroup.id", target = "workgroupId")
    EmployeeDTO toDto(Employee employee);

    @Mapping(source = "workgroupId", target = "workgroup")
    Employee toEntity(EmployeeDTO employeeDTO);

    default Employee fromId(Long id) {
        if (id == null) {
            return null;
        }
        Employee employee = new Employee();
        employee.setId(id);
        return employee;
    }
}
