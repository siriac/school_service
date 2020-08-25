package sub.sid.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import sub.sid.dao.SalleRepository;
import sub.sid.entities.Salle;

public class SalleServiceImpl implements SalleService{
@Autowired
private SalleRepository salleRepository;

@Override
public Salle saveSalle(String libelle, String description) {
	// TODO Auto-generated method stub
	Salle salle=new Salle();
	salle.setLibelle(libelle);
	salle.setDescription(description);
	salleRepository.save(salle);
	return salle;
}

@Override
public List<Salle> listSalle() {
	
	return salleRepository.findAll();
}

@Override
public void deleteSalle(Long idSalle) {
	// TODO Auto-generated method stub
	 Optional<Salle>salleData=findSalleById(idSalle);
	 if(salleData.isPresent()) {
		 salleRepository.delete(salleData.get());
	 }
	 else {
		 throw new RuntimeException("Can't not delete this salle");
	 }
	 
	
	return;
	
	
}


public void modifierSalle(Salle salle) {
	// TODO Auto-generated method stub
	Optional<Salle> data=findSalleById(salle.getId());
	if(data.isPresent())
	{
		data.get().setLibelle(salle.getLibelle());
		data.get().setDescription(salle.getDescription());
		salleRepository.save(data.get());
	}
	else
	{
	throw new RuntimeException("Can't found salle");	
	}
	Salle s=new Salle();
	s.setDescription(salle.getDescription());
	s.setLibelle(salle.getLibelle());
	salleRepository.save(s);
	return ;
}

@Override
public Optional<Salle> findSalleById(Long idSalle) {
	// TODO Auto-generated method stub
	return salleRepository.findById(idSalle);
}

}
