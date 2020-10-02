package com.renangmarques.inhistory.repository;

import com.renangmarques.inhistory.model.Referenced;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface ReferencedRepository extends Neo4jRepository<Referenced, Long> {
}
