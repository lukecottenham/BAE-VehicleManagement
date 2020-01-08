package com.bae.vehicle.persistence.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.bae.issue.persistence.domain.Issue;

@Entity
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String make;
	private String model;
	
//	@OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "vehicle_id")
//    private List<Issue> issues;
//	
	public Vehicle() {
		
	}
	
	public Vehicle(Long id, String make, String model) {
		super();
		this.id = id;
		this.make = make;
		this.model = model;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}
	
	

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

//	 public List<Issue> getIssues() {
//	        return issues;
//	    }
//
//	    public void setIssues(List<Issue> issues) {
//	        this.issues = issues;
//	    }
	    
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
//		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (make == null) {
			if (other.make != null)
				return false;
		} else if (!make.equals(other.make))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", make=" + make + "]";
	}
	
	
}
