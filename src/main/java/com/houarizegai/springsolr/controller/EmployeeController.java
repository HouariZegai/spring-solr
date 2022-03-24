package com.houarizegai.springsolr.controller;

import com.houarizegai.springsolr.domain.dto.EmployeeDto;
import com.houarizegai.springsolr.domain.dto.EmployeeListDto;
import com.houarizegai.springsolr.domain.entity.Employee;
import com.houarizegai.springsolr.mapper.EmployeeMapper;
import com.houarizegai.springsolr.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.solr.core.query.SolrPageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public EmployeeListDto getAllEmployee(@RequestParam int offset, @RequestParam int limit) {
        SolrPageRequest pageRequest = new SolrPageRequest(offset, limit);
        return employeeMapper.mapEntitiesToDtos(employeeRepository.findAll(pageRequest).getContent());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public EmployeeDto createEmployee(@RequestBody EmployeeDto employeeDto) {
        employeeDto.setId(null);
        Employee employee = employeeRepository.save(employeeMapper.mapDtoToEntity(employeeDto));
        return employeeMapper.mapEntityToDto(employee);
    }
}
