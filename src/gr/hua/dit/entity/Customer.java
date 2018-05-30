package gr.hua.dit.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name="customer")
public class Customer {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID_CUSTOMER")
    private int id;
    
    @Column(name="name")
    private String name;
    
    @Column(name="surname")
    private String surname;
    
    @Column(name="fiscal_id")
    private String fiscal_id;
    
    @Column(name="date_patent")
    private String date_patent;
    
    @Column(name="history_events")
    private String history_events;
    
    @OneToMany(mappedBy="customer",fetch=FetchType.EAGER,
            cascade= {CascadeType.PERSIST, CascadeType.MERGE,
                       CascadeType.DETACH, CascadeType.REFRESH})
    private List<Vehicle> vehicles;

    
    public Customer() {}

	public Customer(String name, String surname, String fiscal_id, String date_patent, String history_events) {
		this.name = name;
		this.surname = surname;
		this.fiscal_id = fiscal_id;
		this.date_patent = date_patent;
		this.history_events = history_events;
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

	public String getFiscal_id() {
		return fiscal_id;
	}

	public void setFiscal_id(String fiscal_id) {
		this.fiscal_id = fiscal_id;
	}

	public String getDate_patent() {
		return date_patent;
	}

	public void setDate_patent(String date_patent) {
		this.date_patent = date_patent;
	}

	public String getHistory_events() {
		return history_events;
	}

	public void setHistory_events(String history_events) {
		this.history_events = history_events;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
	
}
