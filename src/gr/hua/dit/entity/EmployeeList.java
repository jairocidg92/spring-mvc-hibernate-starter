package gr.hua.dit.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

@XmlRootElement(name="EmployeeList")
@Component
public class EmployeeList {

	List<Employee> employeeList;
	
	public List<Employee> getEmployeeList(){
		return employeeList; 
	}
	
	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList=employeeList;
	}
}
