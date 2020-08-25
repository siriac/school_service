package sub.sid.service;

import java.util.List;
import java.util.Optional;

import sub.sid.entities.Salle;
import sub.sid.entities.Student;

public interface StudentService {
	
public Student saveStudent(String nom,String prenom,String sexe,int age,Salle salle);
public List<Student> listStudent();
public void deleteStudent(Long idStudent);
public void modifierStudent(Student student);
public Optional<Student> findStudentById(Long idStudent);
public List<Student> findStudentBySalle(Salle salle);
}
