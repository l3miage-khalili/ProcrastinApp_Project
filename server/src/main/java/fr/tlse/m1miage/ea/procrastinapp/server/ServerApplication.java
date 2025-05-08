package fr.tlse.m1miage.ea.procrastinapp.server;

import fr.tlse.m1miage.ea.procrastinapp.server.enums.Role;
import fr.tlse.m1miage.ea.procrastinapp.server.models.UtilisateurEntity;
import fr.tlse.m1miage.ea.procrastinapp.server.repositories.UtilisateurRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}

	@Bean
	CommandLineRunner createGestionnaire(UtilisateurRepository utilisateurRepository) {
		return args -> {
			if (utilisateurRepository.count() == 0){
				UtilisateurEntity gestionnaire = UtilisateurEntity
						.builder()
						.id(1L)
						.adresseEmail("gestionnaire@gmail.com")
						.dateInscription(LocalDate.now())
						.pseudo("gestionnaire")
						.role(Role.GESTIONNAIRE_TEMPS_PERDU)
						.build();
				utilisateurRepository.save(gestionnaire);
				System.out.println("Gestionnaire créé avec succès : " + gestionnaire.getPseudo());
			}
			else {
				System.out.println("Base déjà initialisée");
			}
		};
	}

}
