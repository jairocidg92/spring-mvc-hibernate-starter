package gr.hua.dit.entity;

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

@Entity
@Table(name="employee")
public class Employee {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID_EMPLOYEE")
    private int id;
    
    @Column(name="name")
    private String name;
    
    @Column(name="surname")
    private String surname;
    
    @Column(name="adress")
    private String adress;
    
    @Column(name="birthday")
    private String birthday;
    
    //@JsonIgnore
    @ManyToMany(fetch=FetchType.EAGER,
            cascade= {CascadeType.PERSIST, CascadeType.MERGE,
                      CascadeType.DETACH, CascadeType.REFRESH})    
    @JoinTable(
        name="emplo_depart",
        joinColumns=@JoinColumn(name="employee_id"),
        inverseJoinColumns=@JoinColumn(name="departament_id"))
    private List<Departament> departaments;
    
    public Employee() {}

	public Employee(String name, String surname, String adress, String birthday) {
		this.name = name;
		this.surname = surname;
		this.adress = adress;
		this.birthday = birthday;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public List<Departament> getDepartaments() {
		return departaments;
	}

	public void setDepartaments(List<Departament> departaments) {
		this.departaments = departaments;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", surname=" + surname + ", adress=" + adress + ", birthday=" + birthday
				+ "]";
	}
}
