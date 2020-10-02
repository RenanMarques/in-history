package com.renangmarques.inhistory.repository;

import com.renangmarques.inhistory.model.Serie;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface SerieRepository extends Neo4jRepository<Serie, Long> {
}
