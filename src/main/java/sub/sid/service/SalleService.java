package sub.sid.service;

import java.util.List;

import java.util.Optional;

import sub.sid.entities.Salle;

public interface SalleService {
public Salle saveSalle(String libelle,String description);
public List<Salle> listSalle();
public void deleteSalle(Long idSalle);
public void modifierSalle(Salle salle);
public Optional<Salle> findSalleById(Long idSalle);
}
