package sub.sid.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor 
public class Salle {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String libelle;
private String description;
@OneToMany(fetch = FetchType.EAGER,mappedBy = "salle")
private Collection<Student> students=new ArrayList<>();
@Override
public String toString() {
	return "Salle [id=" + id + ", libelle=" + libelle + ",description="+description+"]";
}
}
