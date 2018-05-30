package gr.hua.dit.dao;

import java.util.List;

import gr.hua.dit.entity.Departament;
import gr.hua.dit.entity.Employee;

public interface DepartamentDAO {
	public List<Departament> getDepartaments();
	
	public void saveDepartament(Departament depart);
	
	public Departament getDepartament(int id);
	
	public List<Departament> getEmployees(int employeeId);
	
	public void deleteDepartament(int id);
	
	public List<Departament> getNotEmployeeDepartaments(int employeeId);

	public List<Departament> getEmployeeDepartaments(int employeeId);
}
