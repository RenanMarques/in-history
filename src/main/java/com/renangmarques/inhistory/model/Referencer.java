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
public abstract class Referencer {

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String title;

    @JsonIgnoreProperties({"referencer"})
    @Relationship(type = "REFERENCED_IN", direction = Relationship.INCOMING)
    private Collection<Reference> referencedPeople;

    public <T extends Referencer> T withTitle(String title) {
        this.title = title;
        return (T) this;
    }

    public abstract String getType();

}
