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
@Table(name="reimb_type")
public class Type {

	@Id
	@Column(name="type_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int typeId;
	
	@Column(name="type_name")
	private String typeName;
	
//	@OneToMany(mappedBy="type", fetch=FetchType.LAZY)
//	private List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
	
	public Type() {
		super();
	}

	public Type(int typeId, String typeName) {
		super();
		this.typeId = typeId;
		this.typeName = typeName;
	}

	public Type(int typeId, String typeName, List<Reimbursement> reimbursements) {
		super();
		this.typeId = typeId;
		this.typeName = typeName;
//		this.reimbursements = reimbursements;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	@Override
	public String toString() {
		return "Type [typeId=" + typeId + ", typeName=" + typeName + "]";
	}


	
	
}
