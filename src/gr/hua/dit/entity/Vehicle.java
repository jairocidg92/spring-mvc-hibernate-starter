package gr.hua.dit.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="vehicle")
public class Vehicle {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID_VEHICLE")
    private int id;
    
    @Column(name="year")
    private String year;
    
    @Column(name="cubic")
    private String cubic;
    
    @Column(name="type")
    private String type;
    
    @Column(name="color")
    private String color;
    
    @Column(name="attribute")
    private String attribute;
    
    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE, 
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="id_vehicle")
    @JsonIgnore
    private Customer customer;

    public Vehicle() {}
    
	public Vehicle(String year, String cubic, String type, String color, String attribute) {
		this.year = year;
		this.cubic = cubic;
		this.type = type;
		this.color = color;
		this.attribute = attribute;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getCubic() {
		return cubic;
	}

	public void setCubic(String cubic) {
		this.cubic = cubic;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", year=" + year + ", cubic=" + cubic + ", type=" + type + ", color=" + color
				+ ", attribute=" + attribute + "]";
	}
	
	
    
    
}
