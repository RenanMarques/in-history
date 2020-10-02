package com.renangmarques.inhistory.repository;

import com.renangmarques.inhistory.model.Referencer;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface ReferencerRepository extends Neo4jRepository<Referencer, Long> {
}
