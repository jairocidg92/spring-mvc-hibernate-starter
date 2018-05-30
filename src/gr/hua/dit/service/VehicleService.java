package gr.hua.dit.service;

import java.util.List;

import gr.hua.dit.entity.Vehicle;

public interface VehicleService {
	public List<Vehicle> getVehicles();

	public void saveVehicle(Vehicle vehicle);
	
	public Vehicle getVehicle(int id);

	public void deleteVehicle(int id);

}
