package com.renangmarques.inhistory.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.Collection;

@Data
@NoArgsConstructor
@NodeEntity
public abstract class Referenced {

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String name;

    @JsonIgnoreProperties({"referenced"})
    @Relationship(type = "REFERENCED_IN")
    private Collection<Reference> referencedIn;

    public <T extends Referenced> T withName(String name) {
        this.name = name;
        return (T) this;
    }

    public abstract String getType();

}
