package com.renangmarques.inhistory;

import com.renangmarques.inhistory.model.Movie;
import com.renangmarques.inhistory.model.Person;
import com.renangmarques.inhistory.repository.MovieRepository;
import com.renangmarques.inhistory.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

import java.util.List;


@SpringBootApplication
@EnableNeo4jRepositories
@Slf4j
public class InHistoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(InHistoryApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(MovieRepository movieRepository, PersonRepository personRepository) {
		return args -> {
			log.debug("Initializing data for application");

			log.debug("Removing all data");
			movieRepository.deleteAll();
			personRepository.deleteAll();
			log.debug("All data removed");

			log.debug("Inserting new data");

			Movie braveheart = new Movie().withTitle("Braveheart");
			Movie outlawKing = new Movie().withTitle("Outlaw King");
			List<Movie> movies = List.of(braveheart, outlawKing);
			movieRepository.saveAll(movies);
			movies.forEach(movie -> {log.debug("Inserting movie... " + movie);});

			Person williamWallace = new Person().withName("William Wallace");
			List<Person> historicalPeople = List.of(williamWallace);
			personRepository.saveAll(historicalPeople);
			historicalPeople.forEach(person -> {log.debug("Inserting person... " + person);});
		};
	}

}
