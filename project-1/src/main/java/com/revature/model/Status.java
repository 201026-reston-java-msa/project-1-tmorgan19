package com.revature.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="reimb_status")
public class Status {

	@Id
	@Column(name="status_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int statusId;
	
	@Column(name="status_name")
	private String statusName;
	
//	@OneToMany(mappedBy="status", fetch=FetchType.LAZY)
//	private List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
	
	public Status(int statusId, String statusName) {
		super();
		this.statusId = statusId;
		this.statusName = statusName;
	}
	

//	public Status(int statusId, String statusName, List<Reimbursement> reimbursements) {
//		super();
//		this.statusId = statusId;
//		this.statusName = statusName;
//		this.reimbursements = reimbursements;
//	}


	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}


	public Status() {
		super();
	}

	@Override
	public String toString() {
		return "Status [statusId=" + statusId + ", statusName=" + statusName + "]";
	}


	
	
	
}
