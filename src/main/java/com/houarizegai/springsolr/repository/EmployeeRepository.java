package com.houarizegai.springsolr.repository;

import com.houarizegai.springsolr.domain.entity.Employee;
import org.springframework.data.solr.repository.SolrCrudRepository;

import java.util.UUID;

public interface EmployeeRepository extends SolrCrudRepository<Employee, UUID> {
}
