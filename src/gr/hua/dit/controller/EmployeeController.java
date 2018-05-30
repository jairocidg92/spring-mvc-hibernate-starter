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
import org.springframework.web.bind.annotation.RequestParam;

import gr.hua.dit.entity.Departament;
import gr.hua.dit.entity.Employee;
import gr.hua.dit.service.DepartamentService;
import gr.hua.dit.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	// inject the student service
		@Autowired
		private EmployeeService employeeService;
		
		@Autowired
		private DepartamentService departamentService;
		
		@GetMapping("/list")
		public String listEmployees(Model model) {
			
			// get students from the service
			List<Employee> employees = employeeService.getEmployees();
			
			// add the students to the model
			model.addAttribute("employees",employees);
			
			// add page title
			model.addAttribute("pageTitle", "List Employees");
			return "list-employees";
		}
		
		@GetMapping("/departament/{id}/list")
		public String listDepartamentsEmployees(Model model, @PathVariable("id") int id) {
			
			// get courses from the service
			List<Employee> employees = employeeService.getDepartamentsEmployees(id);
			
			// add the courses to the model
			model.addAttribute("employees",employees);
			
			// add page title
			model.addAttribute("pageTitle", "Employees List Departaments");
			return "list-employees";
		}
		
		@GetMapping("/{id}")
		public String getEmployee(Model model, @PathVariable("id") int id) {
			// get the student
			Employee employee = employeeService.getEmployee(id);
			
			model.addAttribute("employee", employee);
			
			return "employee-form";
		}
		
		@GetMapping("/showAddForm")
		public String showAddForm(Model model) {
			// create model attribute to get form data
			Employee employee = new Employee();
			model.addAttribute("employee", employee);
			
			// add page title
			model.addAttribute("pageTitle", "Add Employee");
			return "employee-form";
		}
		
		@PostMapping("/saveEmployee")
		public String saveStudent(@ModelAttribute("employee") Employee employee) {
			// save the student using the service
			employeeService.saveEmployee(employee);
			
			return "redirect:/employee/list";
		}
		
		@GetMapping("/assignDepartament/{id}")
		public String assignDepartament(Model model,  @PathVariable("id") int id) {
			Employee employee = employeeService.getEmployee(id);
		    List<Departament> departaments=departamentService.getNotEmployeeDepartaments(id);
		    model.addAttribute("departaments", departaments);
		    model.addAttribute("employee", employee);
			return "assign-departament";
		}
		
		@PostMapping("/assignCourse/{id}")
		public String assignDepartamentToEmployee(@PathVariable("id") int id, @RequestParam("departamentId") int departamentId) {
			Employee employee = employeeService.getEmployee(id);
			Departament departament = departamentService.getDepartament(departamentId);
			List<Departament> departaments = departamentService.getEmployeeDepartaments(departamentId);
			departaments.add(departament);
			employee.setDepartaments(departaments);
			employeeService.saveEmployee(employee);
			return "redirect:/employee/list";
		}

}
