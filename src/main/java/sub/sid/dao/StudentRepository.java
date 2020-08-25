package sub.sid.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import sub.sid.entities.Salle;
import sub.sid.entities.Student;
@RepositoryRestResource
public interface StudentRepository extends JpaRepository<Student, Long>{
	/*url pour obtenir la liste des eleves par salle
	 * http://localhost:8080/students/search/findBySalle?salle=http://localhost:8080/salles/2 
	 * url ci-dessus represente l'url pour obtenir la liste des eleves de la salle dont l'id est 2
	 * */
public List <Student> findBySalle(Salle salle);
}
