package gr.hua.dit.service;

import java.util.List;

import gr.hua.dit.entity.Employee;

public interface EmployeeService {

	public List<Employee> getEmployees();

	public void saveEmployee(Employee employee);
	
	public Employee getEmployee(int id);

	public void deleteEmployee(int id);
	
	public List<Employee> getDepartamentsEmployees(int deparId);
}
