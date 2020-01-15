package com.bae.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Issue {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String issueName;
	private String urgency;
	private String lastAddressed;
	
	public Issue() {
		
	}
	
	public Issue(Long id, String issueName, String urgency, String lastAddressed) {
		super();
		this.id = id;
		this.issueName = issueName;
		this.urgency = urgency;
		this.lastAddressed = lastAddressed;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIssueName() {
		return issueName;
	}

	public void setIssueName(String issueName) {
		this.issueName = issueName;
	}

	public String getUrgency() {
		return urgency;
	}

	public void setUrgency(String urgency) {
		this.urgency = urgency;
	}

	public String getLastAddressed() {
		return lastAddressed;
	}

	public void setLastAddressed(String lastAddressed) {
		this.lastAddressed = lastAddressed;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((issueName == null) ? 0 : issueName.hashCode());
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
		Issue other = (Issue) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (issueName == null) {
			if (other.issueName != null)
				return false;
		} else if (!issueName.equals(other.issueName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Issue [id=" + id + ", name=" + issueName + "]";
	}
	
	
}
