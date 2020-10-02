package com.renangmarques.inhistory.repository;

import com.renangmarques.inhistory.model.Book;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface BookRepository extends Neo4jRepository<Book, Long> {
}
