package gr.hua.dit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gr.hua.dit.entity.Vehicle;

@Repository
public class VehicleDAOImpl implements VehicleDAO {
	
	// inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Vehicle> getVehicles() {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query
		Query<Vehicle> query = currentSession.createQuery("from Vehicle ", Vehicle.class);

		// execute the query and get the results list
		List<Vehicle> vehicles = query.getResultList();

		// return the results
		return vehicles;
	}

	@Override
	public void saveVehicle(Vehicle vehicle) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		if (vehicle.getId() != 0) {
		// update the course
			currentSession.update(vehicle);
		}
		else {
			// save the course
		currentSession.save(vehicle);
		}
		
	}

	@Override
	public Vehicle getVehicle(int id) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// get and return Course
		Vehicle vehicle = currentSession.get(Vehicle.class, id);
		return vehicle;
	}

	@Override
	public void deleteVehicle(int id) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// find the course
		Vehicle vehicle = currentSession.get(Vehicle.class, id);

		// delete course
		currentSession.delete(vehicle);
		
	}

/*	@Override
	public List<Vehicle> getNotCustomerVehicles(int customerId) {
		Session currentSession = sessionFactory.getCurrentSession();
		List<Vehicle> vehicles = currentSession.createQuery("from Vehicle v where v.customer!="+customerId).getResultList();
		System.out.println("not customer vehicles " + vehicles);
		return vehicles;
	}

	@Override
	public List<Vehicle> getCustomerVehicles(int customerId) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Customer customer = (Customer) currentSession.createQuery("from Customer where id = " +customerId).getSingleResult();
		System.out.println("customer vehicles " + customer.getVehicles());

		return customer.getVehicles();
	}*/

}
