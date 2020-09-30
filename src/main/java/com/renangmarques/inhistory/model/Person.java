package com.renangmarques.inhistory.model;

import lombok.*;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

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

}
