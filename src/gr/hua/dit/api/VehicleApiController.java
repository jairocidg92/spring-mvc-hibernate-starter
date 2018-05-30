package gr.hua.dit.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gr.hua.dit.entity.Vehicle;
import gr.hua.dit.entity.VehicleList;
import gr.hua.dit.service.VehicleService;

@RestController
@RequestMapping("/api/vehicle")
public class VehicleApiController {
	
	@Autowired
	private VehicleService vehicleService;

	@Autowired
	private VehicleList vehicleList;
	
/*	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = { "application/json", "application/xml" })
	public Vehicle getVehicle(@PathVariable("id") int id) {

		Vehicle vehicle = vehicleService.getVehicle(id);
		System.out.println("vehicle :" + vehicle);

		return vehicle;
	}*/

	@RequestMapping(value="/delete/{id}", method= RequestMethod.DELETE, produces = { "application/json", "application/xml" })
	public ResponseEntity deleteVehicle(@PathVariable("id") int id) {
		vehicleService.deleteVehicle(id);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = { "application/json", "application/xml" })
	public VehicleList getVehicles() {

		List<Vehicle> vehicles = vehicleService.getVehicles();
		System.out.println("vehicles :" + vehicles);
		this.vehicleList.setVehicleList(vehicles);
		return this.vehicleList;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = { "application/json", "application/xml" })
	public Vehicle createVehicle(@RequestParam("year") String year,
			@RequestParam("cubic") String cubic,@RequestParam("type") String type,@RequestParam("color") String color,
			@RequestParam("attribute") String attribute) {
		Vehicle vehicle = new Vehicle(year, cubic, type, color, attribute);
		vehicleService.saveVehicle(vehicle);
		return vehicle;

	}

	@RequestMapping(value = "/jsonadd", method = RequestMethod.POST,  produces = { "application/json", "application/xml" })
	public Vehicle createVehiclefromJson(@RequestBody Vehicle vehicle) {
		vehicleService.saveVehicle(vehicle);
		return vehicle;
	}
	
}
