package gr.hua.dit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gr.hua.dit.entity.Departament;
import gr.hua.dit.entity.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	
	// inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Employee> getEmployees() {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query
		Query<Employee> query = currentSession.createQuery("from Employee order by surname", Employee.class);

		// execute the query and get the results list
		List<Employee> employees = query.getResultList();

		// return the results
		return employees;
	}

	@Override
	public void saveEmployee(Employee employee) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		if (employee.getId() != 0) {
			// update the student
			currentSession.update(employee);
		}
		else {
			// save the student
			currentSession.save(employee);
		}
	}

	@Override
	public Employee getEmployee(int id) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// get and return Student
		Employee employee = currentSession.get(Employee.class, id);
		return employee;
	}

	@Override
	public void deleteEmployee(int id) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// find the student
		Employee employee = currentSession.get(Employee.class, id);

		// delete student
		currentSession.delete(employee);
	}

	@Override
	public List<Employee> getDepartaments(int departamentId) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Departament departament = (Departament) currentSession.createQuery("from Departament where id = " +departamentId).getSingleResult();
		System.out.println("employee departaments " + departament.getEmployees());

		return departament.getEmployees();
	}



}
