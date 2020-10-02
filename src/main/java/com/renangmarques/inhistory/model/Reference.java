package com.renangmarques.inhistory.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;
import org.neo4j.ogm.annotation.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@With
@RelationshipEntity(type = "REFERENCED_IN")
public class Reference {

    @Id @GeneratedValue
    private Long id;

    @JsonIgnoreProperties({"referencedIn"})
    @StartNode
    private Referenced referenced;

    @JsonIgnoreProperties({"referencedPeople"})
    @EndNode
    private Referencer referencer;

}
