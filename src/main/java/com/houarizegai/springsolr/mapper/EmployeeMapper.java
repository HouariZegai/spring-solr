package com.houarizegai.springsolr.mapper;

import com.houarizegai.springsolr.domain.dto.EmployeeDto;
import com.houarizegai.springsolr.domain.dto.EmployeeListDto;
import com.houarizegai.springsolr.domain.entity.Employee;
import org.apache.commons.lang.StringUtils;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface EmployeeMapper {

    @Mapping(target = "id", expression = "java(stringToSafeUuid(employeeDto.getId()))")
    Employee mapDtoToEntity(EmployeeDto employeeDto);

    @Mapping(target = "id", expression = "java(uuidToSafeString(employee.getId()))")
    EmployeeDto mapEntityToDto(Employee employee);

    default EmployeeListDto mapEntitiesToDtos(List<Employee> employees) {
        List<EmployeeDto> employeeDtos = employees.stream().map(this::mapEntityToDto).collect(Collectors.toList());

        return EmployeeListDto.builder()
                .items(employeeDtos)
                .totalRecords(employeeDtos.size())
                .build();
    }

    default String uuidToSafeString(UUID uuid) {
        return uuid != null ? uuid.toString() : null;
    }

    default UUID stringToSafeUuid(String uuid) {
        return StringUtils.isBlank(uuid) ? null : UUID.fromString(uuid);
    }
}
