package com.renangmarques.inhistory;

import com.renangmarques.inhistory.model.Movie;
import com.renangmarques.inhistory.model.Person;
import com.renangmarques.inhistory.model.Reference;
import com.renangmarques.inhistory.repository.MovieRepository;
import com.renangmarques.inhistory.repository.PersonRepository;
import com.renangmarques.inhistory.repository.ReferenceRepository;
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
	CommandLineRunner initDatabase(ReferenceRepository referenceRepository, MovieRepository movieRepository,
								   PersonRepository personRepository) {
		return args -> {
			log.debug("Initializing data for application");

			log.debug("Removing all data");
			referenceRepository.deleteAll();
			movieRepository.deleteAll();
			personRepository.deleteAll();
			log.debug("All data removed");

			log.debug("Inserting new data");

			Person williamWallace = new Person().withName("William Wallace");

			Movie braveheart = new Movie().withTitle("Braveheart");
			Movie outlawKing = new Movie().withTitle("Outlaw King");

			Reference williamWallaceInBraveheart = new Reference().withPerson(williamWallace).withMovie(braveheart);
			Reference williamWallaceInOutlawKing = new Reference().withPerson(williamWallace).withMovie(outlawKing);
			List<Reference> references = List.of(williamWallaceInBraveheart, williamWallaceInOutlawKing);

			referenceRepository.saveAll(references);
			references.forEach(reference -> {
				log.debug("Inserting references... " + reference);
			});
		};
	}

}
