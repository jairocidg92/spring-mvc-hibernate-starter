package gr.hua.dit.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gr.hua.dit.dao.DepartamentDAO;
import gr.hua.dit.entity.Departament;

@Service
public class DepartamentServiceImpl implements DepartamentService{
	
	@Autowired
	private DepartamentDAO departamentDAO;
	
	@Override
	@Transactional
	public List<Departament> getDepartaments() {
		return departamentDAO.getDepartaments();
	}

	@Override
	@Transactional
	public void saveDepartament(Departament depar) {
		departamentDAO.saveDepartament(depar);
	}

	@Override
	@Transactional
	public void deleteDepartament(int id) {
		departamentDAO.deleteDepartament(id);
	}

	@Override
	@Transactional
	public Departament getDepartament(int id) {
		return departamentDAO.getDepartament(id);
	}

	@Override
	@Transactional
	public List<Departament> getNotEmployeeDepartaments(int employeeId) {
		return departamentDAO.getNotEmployeeDepartaments(employeeId);
	}

	@Override
	@Transactional
	public List<Departament> getEmployeeDepartaments(int employeeId) {
		return departamentDAO.getEmployeeDepartaments(employeeId);
	}

}
