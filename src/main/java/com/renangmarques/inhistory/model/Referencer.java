package com.renangmarques.inhistory.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.neo4j.ogm.annotation.*;

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
