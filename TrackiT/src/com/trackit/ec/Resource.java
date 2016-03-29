package com.trackit.ec;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Resource")
public class Resource {

	@Id
	@Column(name = "name")
	private String resourceName;
	
	@Column(name = "phonenumber")
	private int phoneNumber;

	@Column(name = "ibmid")
	private String ibmUserId;
	
	@Column(name = "emailid")
	private String hondaEmailId;
	
	@Column(name = "ibmemailid")
	private String ibmEmailId;
	
	@Column(name = "location")
	private String location;
	
	@Column(name = "emptype")
	private String emptype	;
	
	@Column(name = "manager")
	private String manager;
	
	@Column(name = "role")
	private String role;
	
	@Column(name = "hondaid")
	private String hondaUserId;

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getIbmUserId() {
		return ibmUserId;
	}

	public void setIbmUserId(String ibmUserId) {
		this.ibmUserId = ibmUserId;
	}

	public String getHondaEmailId() {
		return hondaEmailId;
	}

	public void setHondaEmailId(String hondaEmailId) {
		this.hondaEmailId = hondaEmailId;
	}

	public String getIbmEmailId() {
		return ibmEmailId;
	}

	public void setIbmEmailId(String ibmEmailId) {
		this.ibmEmailId = ibmEmailId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getEmptype() {
		return emptype;
	}

	public void setEmptype(String emptype) {
		this.emptype = emptype;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getHondaUserId() {
		return hondaUserId;
	}

	public void setHondaUserId(String hondaUserId) {
		this.hondaUserId = hondaUserId;
	}

	@Override
	public String toString() {
		return "Resource [resourceName=" + resourceName + ", phoneNumber="
				+ phoneNumber + ", ibmUserId=" + ibmUserId + ", hondaEmailId="
				+ hondaEmailId + ", ibmEmailId=" + ibmEmailId + ", location="
				+ location + ", emptype=" + emptype + ", manager=" + manager
				+ ", role=" + role + ", hondaUserId=" + hondaUserId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((emptype == null) ? 0 : emptype.hashCode());
		result = prime * result
				+ ((hondaEmailId == null) ? 0 : hondaEmailId.hashCode());
		result = prime * result
				+ ((hondaUserId == null) ? 0 : hondaUserId.hashCode());
		result = prime * result
				+ ((ibmEmailId == null) ? 0 : ibmEmailId.hashCode());
		result = prime * result
				+ ((ibmUserId == null) ? 0 : ibmUserId.hashCode());
		result = prime * result
				+ ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((manager == null) ? 0 : manager.hashCode());
		result = prime * result + phoneNumber;
		result = prime * result
				+ ((resourceName == null) ? 0 : resourceName.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
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
		Resource other = (Resource) obj;
		if (emptype == null) {
			if (other.emptype != null)
				return false;
		} else if (!emptype.equals(other.emptype))
			return false;
		if (hondaEmailId == null) {
			if (other.hondaEmailId != null)
				return false;
		} else if (!hondaEmailId.equals(other.hondaEmailId))
			return false;
		if (hondaUserId == null) {
			if (other.hondaUserId != null)
				return false;
		} else if (!hondaUserId.equals(other.hondaUserId))
			return false;
		if (ibmEmailId == null) {
			if (other.ibmEmailId != null)
				return false;
		} else if (!ibmEmailId.equals(other.ibmEmailId))
			return false;
		if (ibmUserId == null) {
			if (other.ibmUserId != null)
				return false;
		} else if (!ibmUserId.equals(other.ibmUserId))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (manager == null) {
			if (other.manager != null)
				return false;
		} else if (!manager.equals(other.manager))
			return false;
		if (phoneNumber != other.phoneNumber)
			return false;
		if (resourceName == null) {
			if (other.resourceName != null)
				return false;
		} else if (!resourceName.equals(other.resourceName))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		return true;
	}
	
}