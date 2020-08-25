package sub.sid.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import sub.sid.dao.StudentRepository;
import sub.sid.entities.Salle;
import sub.sid.entities.Student;

public class StudentServiceImpl implements StudentService{
	@Autowired
private StudentRepository studentRepository;
	@Override
	public Student saveStudent(String nom, String prenom, String sexe, int age, Salle salle) {
		Student student=new Student(null, nom, prenom, sexe, age, salle);
		studentRepository.save(student);
		return student;
	}

	@Override
	public List<Student> listStudent() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}

	@Override
	public void deleteStudent(Long idStudent) {
		// TODO Auto-generated method stub
		studentRepository.deleteById(idStudent);
		
		
	}

	@Override
	public void modifierStudent(Student student) {
		// TODO Auto-generated method stub
		Optional<Student> s = findStudentById(student.getId());
		if(s.isPresent()) 
		{
			s.get().setAge(student.getAge());
			s.get().setNom(student.getNom());
			s.get().setPrenom(student.getPrenom());
			s.get().setSexe(student.getSexe());
			s.get().setSalle(student.getSalle());
			studentRepository.save(s.get());
		}
		else {
			throw new RuntimeException("Student not exist");
		}
		
	}

	@Override
	public Optional<Student> findStudentById(Long idStudent) {
		
		return studentRepository.findById(idStudent);
	}

	@Override
	public List<Student> findStudentBySalle(Salle salle) {
		
		return studentRepository.findBySalle(salle);
	}

}
