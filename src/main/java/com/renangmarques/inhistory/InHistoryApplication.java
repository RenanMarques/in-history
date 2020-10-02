package com.renangmarques.inhistory;

import com.google.common.collect.Maps;
import com.renangmarques.inhistory.model.*;
import com.renangmarques.inhistory.repository.ReferenceRepository;
import lombok.extern.slf4j.Slf4j;
import org.neo4j.ogm.session.Session;
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
	CommandLineRunner initDatabase(Session session, ReferenceRepository referenceRepository) {
		return args -> {
			log.debug("Initializing data for application");

			log.debug("Removing all data");
			session.query("MATCH (n)DETACH DELETE n", Maps.newHashMap());
			log.debug("All data removed");

			log.debug("Inserting new data");

			// Scotland history references

			Referenced williamWallace = new Person().withName("William Wallace");
			Referenced robertTheBruce = new Person().withName("Robert the Bruce");

			Referencer braveheart = new Movie().withTitle("Braveheart");
			Referencer outlawKing = new Movie().withTitle("Outlaw King");
			Referencer robertTheBruceMovie = new Movie().withTitle("Robert the Bruce");

			Reference williamWallaceInBraveheart = new Reference().withReferenced(williamWallace).withReferencer(braveheart);
			Reference williamWallaceInOutlawKing = new Reference().withReferenced(williamWallace).withReferencer(outlawKing);
			Reference robertTheBruceInRobertTheBruce = new Reference().withReferenced(robertTheBruce)
					.withReferencer(robertTheBruceMovie);
			Reference robertTheBruceInOutlawKing = new Reference().withReferenced(robertTheBruce).withReferencer(outlawKing);

			// World War II references
			Referenced eugeneSledge = new Person().withName("Eugene Sledge");
			Referenced robertLeckie = new Person().withName("Robert Leckie");
			Referenced austinShofner = new Person().withName("Austin Shofner");
			Referenced vernonMicheel = new Person().withName("Vernon Micheel");

			Referencer thePacific = new Serie().withTitle("The Pacific");

			Reference eugeneSledgeInThePacificSerie = new Reference().withReferenced(eugeneSledge).withReferencer(thePacific);
			Reference robertLeckieInThePacificSerie = new Reference().withReferenced(robertLeckie).withReferencer(thePacific);
			Reference austinShofnerInThePacificSerie = new Reference().withReferenced(austinShofner).withReferencer(thePacific);
			Reference vernonMicheelInThePacificSerie = new Reference().withReferenced(vernonMicheel).withReferencer(thePacific);

			// Persist references in the database
			List<Reference> references = List.of(
					williamWallaceInBraveheart,
					williamWallaceInOutlawKing,
					robertTheBruceInRobertTheBruce,
					robertTheBruceInOutlawKing,
					eugeneSledgeInThePacificSerie,
					robertLeckieInThePacificSerie,
					austinShofnerInThePacificSerie,
					vernonMicheelInThePacificSerie
			);
			referenceRepository.saveAll(references);
			references.forEach(reference -> {
				log.debug("Inserting references... " + reference);
			});
		};
	}

}
