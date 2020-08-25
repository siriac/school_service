package sub.sid;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import sub.sid.dao.SalleRepository;
import sub.sid.dao.StudentRepository;
import sub.sid.entities.Salle;
import sub.sid.entities.Student;

@SpringBootApplication
public class SchoolServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner start (StudentRepository studentRepository, SalleRepository salleRepository) {
		return args->{
			salleRepository.deleteAll();//je supprime la table salle en bd
			Stream.of("SIL&Section d'initialisation a la lecture","CP&Cour préparatoire",
					"CE1&Cour élémentaire un",
					"CE2&Cour elementaire 2",
					"CM1&Cour moyen un",
					"CM2&Cour moyen 2").forEach(salle->{
						salleRepository.save(new Salle(null,salle.split("&")[0],salle.split("&")[1],new ArrayList<>()));
					});
			salleRepository.findAll().forEach(System.out::println);
			studentRepository.deleteAll();//je supprime d'abord tout dans la base de donnée student
			Salle sil =salleRepository.findById(1L).get();
			Salle cp=salleRepository.findById(2L).get();
			Salle ce1=salleRepository.findById(3L).get();
			Salle ce2=salleRepository.findById(4l).get();
			Salle cm1=salleRepository.findById(5L).get();
			Salle cm2=salleRepository.findById(6L).get();
				Stream.of("Kadem&Toto&M&06","Amougou&Franck&M&05","Ngo&Albertine&F&03").forEach(student->{
					//System.out.println(Integer.parseInt(student.split("&")[3]));
					
			studentRepository.save(new Student(null,student.split("&")[0],student.split("&")[1],student.split("&")[2],Integer.parseInt(student.split("&")[3]),sil));
				});
				Stream.of("Matip&Francis&M&09","Fotso&Gisha&M&08","Ousmane&Ali&F&08").forEach(student->{
					studentRepository.save(new Student(null,student.split("&")[0],student.split("&")[1],student.split("&")[2],Integer.parseInt(student.split("&")[3]),cp));
						});
				Stream.of("Kamga&Moise&M&10","Ali&junior&M&11","Zacharie&Marie&F&12").forEach(student->{
					studentRepository.save(new Student(null,student.split("&")[0],student.split("&")[1],student.split("&")[2],Integer.parseInt(student.split("&")[3]),ce1));
						});
			Stream.of("Talla&Romeo&M&13","Soh&Alain&M&12","NgoBilla&Jeanne&F&11").forEach(student->{
					studentRepository.save(new Student(null,student.split("&")[0],student.split("&")[1],student.split("&")[2],Integer.parseInt(student.split("&")[3]),ce2));
						});
				Stream.of("Kamto&George&M&15","Atangana&Raoul&M&09","Dupont&Jeanne&F&12").forEach(student->{
					studentRepository.save(new Student(null,student.split("&")[0],student.split("&")[1],student.split("&")[2],Integer.parseInt(student.split("&")[3]),cm1));
						});
				Stream.of("Deffo&Baurice&M&16","Tagougan&Merci&M&11","Ndongo&Philomene&F&10").forEach(student->{
					studentRepository.save(new Student(null,student.split("&")[0],student.split("&")[1],student.split("&")[2],Integer.parseInt(student.split("&")[3]),cm2));
						});
				studentRepository.findAll().forEach(System.out::println);
		};
	}

}
