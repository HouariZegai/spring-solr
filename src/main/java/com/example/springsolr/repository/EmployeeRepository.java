package com.example.springsolr.repository;

import com.example.springsolr.domain.entity.Employee;
import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EmployeeRepository extends SolrCrudRepository<Employee, UUID> {
}
