package com.renangmarques.inhistory.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
@With
@NodeEntity
public class Person {

    @Id @GeneratedValue
    private Long id;

    @NonNull
    private String name;

    @JsonIgnoreProperties({"person"})
    @Relationship(type = "REFERENCED_IN")
    private Collection<Reference> referencedIn;

}