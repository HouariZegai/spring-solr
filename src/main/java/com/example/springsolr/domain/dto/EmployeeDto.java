package com.example.springsolr.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class EmployeeDto {
    private String id;
    private String name;
    private String[] address;
}
