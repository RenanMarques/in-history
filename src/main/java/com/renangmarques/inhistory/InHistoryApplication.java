package com.renangmarques.inhistory;

import com.renangmarques.inhistory.model.Movie;
import com.renangmarques.inhistory.repository.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

import java.util.List;


@SpringBootApplication
@EnableNeo4jRepositories

public class InHistoryApplication {

	private static Logger logger = LoggerFactory.getLogger(InHistoryApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(InHistoryApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(MovieRepository movieRepository) {
		return args -> {
			logger.debug("Initializing data for application");

			logger.debug("Removing all data");
			movieRepository.deleteAll();

			logger.debug("Inserting new data");

			Movie braveheart = new Movie().withTitle("Braveheart");
			Movie outlawKing = new Movie().withTitle("Outlaw King");

			List<Movie> movies = List.of(
					new Movie().withTitle("Saving Private Ryan"),
					new Movie().withTitle("Braveheart"));
			movieRepository.saveAll(movies);
		};
	}

}
