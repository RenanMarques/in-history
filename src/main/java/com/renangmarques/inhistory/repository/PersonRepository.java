package com.renangmarques.inhistory.repository;

import com.renangmarques.inhistory.model.Person;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface PersonRepository extends Neo4jRepository<Person, Long> {
}
