package gr.hua.dit.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

@XmlRootElement(name="DepartamentList")
@Component
public class DepartamentList {
	
	List<Departament> departamentList;
	
	public List<Departament> getDepartamentList(){
		return departamentList; 
	}
	
	public void setDepartamentList(List<Departament> departamentList) {
		this.departamentList=departamentList;
	}
}
