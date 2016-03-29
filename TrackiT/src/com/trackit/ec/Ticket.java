package com.trackit.ec;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Ticket")
public class Ticket {

	@Id
	@Column(name = "ticketid")
	private String ticketId;
	@Column(name = "summary")
	private String summary;
	@Column(name = "priority")
	private String priority;
	@Column(name = "asgngroup")
	private String assignmentGroup;
	@Column(name = "asgnto")
	private String assignedTo;
	@Column(name = "remark")
	private String remark;
	@Column(name="status")
	private String status;
	@Column(name = "project")
	private String project;
	@Column(name = "area")
	private String area;
	@Column(name = "createtime")
	private Date createdOn;
	@Column(name = "updatetime")
	private Date updateOn;
	@Column(name = "done")
	private boolean done;
	@Column(name = "frstuploaddate")
	private Date frstUploadDate;
	@Column(name = "lstuploaddate")
	private Date lstUploadDate;
	
	public String getTicketId() {
		return ticketId;
	}
	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getAssignmentGroup() {
		return assignmentGroup;
	}
	public void setAssignmentGroup(String assignmentGroup) {
		this.assignmentGroup = assignmentGroup;
	}
	public String getAssignedTo() {
		return assignedTo;
	}
	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public Date getUpdateOn() {
		return updateOn;
	}
	public void setUpdateOn(Date updateOn) {
		this.updateOn = updateOn;
	}
	public boolean isDone() {
		return done;
	}
	public void setDone(boolean done) {
		this.done = done;
	}
	public Date getFrstUploadDate() {
		return frstUploadDate;
	}
	public void setFrstUploadDate(Date frstUploadDate) {
		this.frstUploadDate = frstUploadDate;
	}
	public Date getLstUploadDate() {
		return lstUploadDate;
	}
	public void setLstUploadDate(Date lstUploadDate) {
		this.lstUploadDate = lstUploadDate;
	}
	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", summary=" + summary
				+ ", priority=" + priority + ", assignmentGroup="
				+ assignmentGroup + ", assignedTo=" + assignedTo + ", remark="
				+ remark + ", status=" + status + ", project=" + project
				+ ", area=" + area + ", createdOn=" + createdOn + ", updateOn="
				+ updateOn + ", done=" + done + ", frstUploadDate="
				+ frstUploadDate + ", lstUploadDate=" + lstUploadDate + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((area == null) ? 0 : area.hashCode());
		result = prime * result
				+ ((assignedTo == null) ? 0 : assignedTo.hashCode());
		result = prime * result
				+ ((assignmentGroup == null) ? 0 : assignmentGroup.hashCode());
		result = prime * result
				+ ((createdOn == null) ? 0 : createdOn.hashCode());
		result = prime * result + (done ? 1231 : 1237);
		result = prime * result
				+ ((frstUploadDate == null) ? 0 : frstUploadDate.hashCode());
		result = prime * result
				+ ((lstUploadDate == null) ? 0 : lstUploadDate.hashCode());
		result = prime * result
				+ ((priority == null) ? 0 : priority.hashCode());
		result = prime * result + ((project == null) ? 0 : project.hashCode());
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((summary == null) ? 0 : summary.hashCode());
		result = prime * result
				+ ((ticketId == null) ? 0 : ticketId.hashCode());
		result = prime * result
				+ ((updateOn == null) ? 0 : updateOn.hashCode());
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
		Ticket other = (Ticket) obj;
		if (area == null) {
			if (other.area != null)
				return false;
		} else if (!area.equals(other.area))
			return false;
		if (assignedTo == null) {
			if (other.assignedTo != null)
				return false;
		} else if (!assignedTo.equals(other.assignedTo))
			return false;
		if (assignmentGroup == null) {
			if (other.assignmentGroup != null)
				return false;
		} else if (!assignmentGroup.equals(other.assignmentGroup))
			return false;
		if (createdOn == null) {
			if (other.createdOn != null)
				return false;
		} else if (!createdOn.equals(other.createdOn))
			return false;
		if (done != other.done)
			return false;
		if (frstUploadDate == null) {
			if (other.frstUploadDate != null)
				return false;
		} else if (!frstUploadDate.equals(other.frstUploadDate))
			return false;
		if (lstUploadDate == null) {
			if (other.lstUploadDate != null)
				return false;
		} else if (!lstUploadDate.equals(other.lstUploadDate))
			return false;
		if (priority == null) {
			if (other.priority != null)
				return false;
		} else if (!priority.equals(other.priority))
			return false;
		if (project == null) {
			if (other.project != null)
				return false;
		} else if (!project.equals(other.project))
			return false;
		if (remark == null) {
			if (other.remark != null)
				return false;
		} else if (!remark.equals(other.remark))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (summary == null) {
			if (other.summary != null)
				return false;
		} else if (!summary.equals(other.summary))
			return false;
		if (ticketId == null) {
			if (other.ticketId != null)
				return false;
		} else if (!ticketId.equals(other.ticketId))
			return false;
		if (updateOn == null) {
			if (other.updateOn != null)
				return false;
		} else if (!updateOn.equals(other.updateOn))
			return false;
		return true;
	}
	
	
}