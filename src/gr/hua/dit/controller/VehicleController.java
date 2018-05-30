package gr.hua.dit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import gr.hua.dit.entity.Customer;
import gr.hua.dit.entity.Vehicle;
import gr.hua.dit.service.CustomerService;
import gr.hua.dit.service.VehicleService;


@Controller
@RequestMapping("/vehicle")
public class VehicleController {
	
	// inject the vehicle service
	@Autowired
	private VehicleService vehicleService;
	
/*	@Autowired
	private CustomerService customerService;*/
	
	@GetMapping("/list")
	public String listVehicles(Model model) {
		
		// get vehicles from the service
		List<Vehicle> vehicles = vehicleService.getVehicles();
		
		// add the vehicles to the model
		model.addAttribute("vehicles",vehicles);
		
		// add page title
		model.addAttribute("pageTitle", "List Vehicles");
		return "list-vehicles";
	}
	
	@GetMapping("/showAddForm")
	public String showAddForm(Model model) {
		// create model attribute to get form data
		Vehicle vehicle = new Vehicle();
		model.addAttribute("vehicle", vehicle);
		
		// add page title
		model.addAttribute("pageTitle", "Add Vehicle");
		return "vehicle-form";
	}
	
	@PostMapping("/saveVehicle")
	public String saveVehicle(@ModelAttribute("vehicle") Vehicle vehicle) {
		// save the customer using the service
		vehicleService.saveVehicle(vehicle);
		
		return "redirect:/vehicle/list";
	}
	
	
	@GetMapping("/{id}")
	public String getVehicle(Model model, @PathVariable("id") int id) {
		// get the vehicle
		Vehicle vehicle = vehicleService.getVehicle(id);
		
		model.addAttribute("vehicle", vehicle);
		
		return "vehicle-form";
	}
	
/*	@GetMapping("/showAddForm/{customerId}")
	public String showAddForm(Model model, @PathVariable("customerId") int customerId) {
		// create model attribute to get form data
		Vehicle vehicle = new Vehicle();
		Customer customer = customerService.getCustomer(customerId);
		vehicle.setCustomer(customer);
		System.out.println("teacher in show form -- > " + vehicle.getCustomer());

		model.addAttribute("vehicle", vehicle);

		// add page title
		model.addAttribute("pageTitle", "Add Vehicle");
		return "vehicle-form";
	}
	
	@PostMapping("/saveVehicle/{customerId}")
	public String saveVehicle(@ModelAttribute("vehicle") Vehicle vehicle, @PathVariable("customerId") int customerId) {
		// save the vehicle using the service
		Customer customer = customerService.getCustomer(customerId);
		vehicle.setCustomer(customer);
		System.out.println("customer -- > " + vehicle.getCustomer());
		vehicleService.saveVehicle(vehicle);
		
		return "redirect:/vehicle/list";
	}*/
}
