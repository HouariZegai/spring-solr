package com.houarizegai.springsolr.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class EmployeeListDto {
    private List<EmployeeDto> items;
    private int totalRecords;
}
