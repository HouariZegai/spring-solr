package com.example.springsolr.domain.entity;

import lombok.*;
import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.SolrDocument;

import java.util.UUID;

@Getter
@Setter
@ToString
@SolrDocument(collection = "employee")
public class Employee {

    @Id
    @Field
    private UUID id;

    @Field
    private String name;

    @Field
    private String[] address;
}
