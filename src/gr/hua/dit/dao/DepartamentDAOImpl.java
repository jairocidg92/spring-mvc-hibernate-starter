package gr.hua.dit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gr.hua.dit.entity.Departament;
import gr.hua.dit.entity.Employee;

@Repository
public class DepartamentDAOImpl implements DepartamentDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Departament> getDepartaments() {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// create a query
		Query<Departament> query = currentSession.createQuery("from Departament order by manager", Departament.class);

		// execute the query and get the results list
		List<Departament> departaments = query.getResultList();
		
		//return the results
		return departaments;
	}

	@Override
	public void saveDepartament(Departament depar) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		if (depar.getID_DEPARTAMENT() != 0) {
			// update the teacher
			currentSession.update(depar);
		}
		else {
			// save the teacher
			currentSession.save(depar);
		}

	}

	@Override
	public Departament getDepartament(int id) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// get and return Teacher
		Departament depar = currentSession.get(Departament.class, id);
		return depar;
	}

	@Override
	public void deleteDepartament(int id) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// find the teacher
		Departament depar = currentSession.get(Departament.class, id);

		// delete teacher
		currentSession.delete(depar);
		
	}
	
	@Override
	public List<Departament> getNotEmployeeDepartaments(int employeeId) {
		Session currentSession = sessionFactory.getCurrentSession();
		String sql="select * from departament where departament.ID_DEPARTAMENT not in (select departament_id from emplo_depart inner join employee on emplo_depart.employee_id=employee.ID_EMPLOYEE where employee_id="+employeeId+")";
		System.out.println("SQL " + sql);
		// FIXME change setresultTransformer to match Hibernate 5.2
		List<Departament> departaments = currentSession.createNativeQuery(sql).addScalar("ID_DEPARTAMENT").setResultTransformer(Transformers.aliasToBean(Departament.class)).getResultList();
		System.out.println("not employee departaments " + departaments);
		return departaments;
	}

	@Override
	public List<Departament> getEmployeeDepartaments(int employeeId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Employee employee = (Employee) currentSession.createQuery("from Employee where ID_EMPLOYEE = " +employeeId).getSingleResult();
		System.out.println("employee departaments " + employee.getDepartaments());

		return employee.getDepartaments();
	}
	
	@Override
	public List<Departament> getEmployees(int employeeId) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Employee employee = (Employee) currentSession.createQuery("from Employee where ID_EMPLOYEE = " +employeeId).getSingleResult();
		System.out.println("employee departaments " + employee.getDepartaments());

		return employee.getDepartaments();
	}
}
