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

import gr.hua.dit.entity.Course;
import gr.hua.dit.entity.Departament;
import gr.hua.dit.service.DepartamentService;

@Controller
@RequestMapping("/departament")
public class DepartamentController {
	
	@Autowired
	private DepartamentService departamentService;
	
	@GetMapping("/list")
	public String listDepartaments(Model model) {
		
		// get departaments from the service
		List<Departament> departaments = departamentService.getDepartaments();
		
		System.out.println(departaments);
		// add the departaments to the model
		model.addAttribute("departaments",departaments);
		
		// add page title
		model.addAttribute("pageTitle", "List Departaments");
		return "list-departaments";
	}
	
	@GetMapping("/employee/{id}/list")
	public String listEmployeeDepartaments(Model model, @PathVariable("id") int id) {
		
		// get courses from the service
		List<Departament> departaments = departamentService.getEmployeeDepartaments(id);
		
		// add the courses to the model
		model.addAttribute("departaments",departaments);
		
		// add page title
		model.addAttribute("pageTitle", "Employee List Departaments");
		return "list-departaments";
	}
	
	@GetMapping("/{id}")
	public String getDepartament(Model model, @PathVariable("id") int id) {
		// get the departament
		Departament departament = departamentService.getDepartament(id);
		
		model.addAttribute("departament", departament);
		
		return "departament-form";
	}
	
	@GetMapping("/showAddForm")
	public String showAddForm(Model model) {
		// create model attribute to get form data
		Departament departament = new Departament();
		model.addAttribute("departament", departament);
		
		// add page title
		model.addAttribute("pageTitle", "Add Departament");
		return "departament-form";
	}
	
	@PostMapping("/saveDepartament")
	public String saveDepartament(@ModelAttribute("departament") Departament departament) {
		// save the teacher using the service
		departamentService.saveDepartament(departament);
		
		return "redirect:/departament/list";
	}
	
	
}
