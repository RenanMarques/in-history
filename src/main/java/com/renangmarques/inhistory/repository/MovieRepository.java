package com.renangmarques.inhistory.repository;

import com.renangmarques.inhistory.model.Movie;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface MovieRepository extends Neo4jRepository<Movie, Long> {
}
