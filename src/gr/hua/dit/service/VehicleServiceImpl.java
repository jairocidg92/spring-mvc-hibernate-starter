package gr.hua.dit.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gr.hua.dit.dao.VehicleDAO;
import gr.hua.dit.entity.Vehicle;

@Service
public class VehicleServiceImpl implements VehicleService{
	
	// inject the CourseDAO
	@Autowired
	private VehicleDAO vehicleDAO;
	
	@Override
	@Transactional
	public List<Vehicle> getVehicles() {
		return vehicleDAO.getVehicles();
	}

	@Override
	@Transactional
	public void saveVehicle(Vehicle vehicle) {
		vehicleDAO.saveVehicle(vehicle);
		
	}

	@Override
	@Transactional
	public Vehicle getVehicle(int id) {
		return vehicleDAO.getVehicle(id);
	}

	@Override
	@Transactional
	public void deleteVehicle(int id) {
		vehicleDAO.deleteVehicle(id);
		
	}

/*	@Override
	@Transactional
	public List<Vehicle> getNotCustomerVehicles(int customerId) {
		return vehicleDAO.getNotCustomerVehicles(customerId);
	}

	@Override
	@Transactional
	public List<Vehicle> getCustomerVehicles(int customerId) {
		return vehicleDAO.getCustomerVehicles(customerId);
	}*/

}
