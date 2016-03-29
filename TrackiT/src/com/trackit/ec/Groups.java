package com.trackit.ec;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Groups")
public class Groups {

	@Id
	@Column(name = "groupname")
	private String assignmentGroup;
	
	@Column(name = "area")
	private String area;

	
	public String getAssignmentGroup() {
		return assignmentGroup;
	}
	public void setAssignmentGroup(String assignmentGroup) {
		this.assignmentGroup = assignmentGroup;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	@Override
	public String toString() {
		return "Groups [assignmentGroup=" + assignmentGroup + ", area=" + area
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((area == null) ? 0 : area.hashCode());
		result = prime * result
				+ ((assignmentGroup == null) ? 0 : assignmentGroup.hashCode());
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
		Groups other = (Groups) obj;
		if (area == null) {
			if (other.area != null)
				return false;
		} else if (!area.equals(other.area))
			return false;
		if (assignmentGroup == null) {
			if (other.assignmentGroup != null)
				return false;
		} else if (!assignmentGroup.equals(other.assignmentGroup))
			return false;
		return true;
	}

}