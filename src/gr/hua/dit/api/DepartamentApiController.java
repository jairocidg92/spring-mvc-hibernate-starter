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
import gr.hua.dit.entity.Departament;
import gr.hua.dit.entity.DepartamentList;
import gr.hua.dit.service.DepartamentService;

@RestController
@RequestMapping("/api/departament")
public class DepartamentApiController {
	
	@Autowired
	private DepartamentService departamentService;
	
	@Autowired
	private DepartamentList departamentList;
	
	@RequestMapping(value="/delete/{id}", method= RequestMethod.DELETE, produces = { "application/json", "application/xml" })
	public ResponseEntity deleteDepartament(@PathVariable("id") int id) {
		departamentService.deleteDepartament(id);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = { "application/json", "application/xml" })
	public DepartamentList getDepartaments() {

		List<Departament> departaments = departamentService.getDepartaments();
		System.out.println("departaments :" + departaments);
		this.departamentList.setDepartamentList(departaments);
		return this.departamentList;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = { "application/json", "application/xml" })
	public Departament createDepartament(@RequestParam("phone") String phone,
			@RequestParam("adress") String adress, @RequestParam("manager") String manager) {
		Departament departament = new Departament(phone, adress, manager);
		departamentService.saveDepartament(departament);
		return departament;

	}

	@RequestMapping(value = "/jsonadd", method = RequestMethod.POST,  produces = { "application/json", "application/xml" })
	public Departament createDepartamentfromJson(@RequestBody Departament departament) {
		departamentService.saveDepartament(departament);
		return departament;
	}

}
