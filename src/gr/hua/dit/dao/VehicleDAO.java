package gr.hua.dit.dao;

import java.util.List;

import gr.hua.dit.entity.Vehicle;

public interface VehicleDAO {

	public List<Vehicle> getVehicles();

	public void saveVehicle(Vehicle vehicle);
	
	public Vehicle getVehicle(int id);

	public void deleteVehicle(int id);
	
/*	public List<Vehicle> getNotCustomerVehicles(int customerId);
	
	public List<Vehicle> getCustomerVehicles(int customerId);*/
	
}
