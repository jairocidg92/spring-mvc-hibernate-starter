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

import gr.hua.dit.entity.Employee;
import gr.hua.dit.entity.EmployeeList;
import gr.hua.dit.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeApiController {
	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private EmployeeList employeetList;
	
	@RequestMapping(value="/delete/{id}", method= RequestMethod.DELETE, produces = { "application/json", "application/xml" })
	public ResponseEntity deleteEmployee(@PathVariable("id") int id) {
		employeeService.deleteEmployee(id);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = { "application/json", "application/xml" })
	public EmployeeList getEmployees() {

		List<Employee> employees = employeeService.getEmployees();
		System.out.println("students :" + employees);
		this.employeetList.setEmployeeList(employees);
		return this.employeetList;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = { "application/json", "application/xml" })
	public Employee createEmployee(@RequestParam("name") String name,
			@RequestParam("surname") String surname, @RequestParam("adress") String adress,@RequestParam("birthday") String birthday) {
		Employee employee = new Employee(name, surname, adress,birthday);
		employeeService.saveEmployee(employee);
		return employee;

	}

	@RequestMapping(value = "/jsonadd", method = RequestMethod.POST,  produces = { "application/json", "application/xml" })
	public Employee createEmployeefromJson(@RequestBody Employee employee) {
		employeeService.saveEmployee(employee);
		return employee;
	}
	
	

}
