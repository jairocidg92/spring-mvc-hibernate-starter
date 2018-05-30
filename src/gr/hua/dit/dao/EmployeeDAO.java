package gr.hua.dit.dao;

import java.util.List;

import gr.hua.dit.entity.Employee;

public interface EmployeeDAO {
	public List<Employee> getEmployees();

	public void saveEmployee(Employee employee);
	
	public Employee getEmployee(int id);

	public void deleteEmployee(int id);
	
	public List<Employee> getDepartaments(int deparId);
}
