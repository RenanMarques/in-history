package com.renangmarques.inhistory.repository;

import com.renangmarques.inhistory.model.Reference;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface ReferenceRepository extends Neo4jRepository<Reference, Long> {
}
