package gr.hua.dit.service;

import java.util.List;

import gr.hua.dit.entity.Departament;

public interface DepartamentService {

	public List<Departament> getDepartaments();

	public void saveDepartament(Departament depar);
	
	public Departament getDepartament(int id);

	public void deleteDepartament(int id);
	
	public List<Departament> getNotEmployeeDepartaments(int departamentId);
	
	public List<Departament> getEmployeeDepartaments(int departamentId);

}
