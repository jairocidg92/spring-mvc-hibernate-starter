package gr.hua.dit.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="departament")
public class Departament {
	
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID_DEPARTAMENT")
    private int id;
    
    @Column(name="phone")
    private String phone;
    
    @Column(name="adress")
    private String adress;
    
    @Column(name="manager")
    private String manager;
    
    @JsonIgnore
    @ManyToMany(fetch=FetchType.EAGER,
                cascade= {CascadeType.PERSIST, CascadeType.MERGE, 
                          CascadeType.DETACH, CascadeType.REFRESH})    
    
    @JoinTable(
            name="emplo_depart",
            joinColumns=@JoinColumn(name="departament_id"),
            inverseJoinColumns=@JoinColumn(name="employee_id"))
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Employee> employees;
    
    //constructors
    public Departament() {}
    
	public Departament(String phone, String adress, String manager) {
		super();
		this.phone = phone;
		this.adress = adress;
		this.manager = manager;
	}
	
	//getters and setters
	public int getID_DEPARTAMENT() {
		return id;
	}

	public void setID_DEPARTAMENT(int id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}
	
    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployee(List<Employee> employees) {
        this.employees = employees;
    }
    
    // add a convenience method  to add course
    public void addEmployee(Employee employee) {
    	
        if (employees == null) {
            employees = new ArrayList<Employee>();
        }
        employees.add(employee);
    }
    
	@Override
	public String toString() {
		return "Departament [phone=" + phone + ", adress=" + adress + ", manager=" + manager + "]";
	}
    
	
}
