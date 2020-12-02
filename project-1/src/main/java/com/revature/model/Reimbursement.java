package com.revature.model;

import java.time.LocalDateTime;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="reimbursement")
public class Reimbursement {

	@Id
	@Column(name="reimb_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int reimbId;
	
	@Column(name="amount", nullable=false)
	private double amount;
	
	@Basic
	@Column(name="submitted")
	private LocalDateTime submitedTime;
	
	@Basic
	@Column(name="resolved")
	private LocalDateTime resolvedTime;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="author_id")
	private User author;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="resolver_id")
	private User resolver;
	
	@Column(name="description")
	private String description;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="status_id")
	private Status status;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="type_id")
	private Type type;
	
	public Reimbursement() {
		super();
	}

	public Reimbursement(double amount, User author, String description, Status status, Type type) {
		super();
		this.amount = amount;
		this.submitedTime = LocalDateTime.now();
		this.author = author;
		this.description = description;
		this.status = status;
		this.type = type;
	}
	
	public Reimbursement(int reimbId, double amount, LocalDateTime submitedTime, LocalDateTime resolvedTime, User author,
			User resolver, String description, Status status, Type type) {
		super();
		this.reimbId = reimbId;
		this.amount = amount;
		this.submitedTime = submitedTime;
		this.resolvedTime = resolvedTime;
		this.author = author;
		this.resolver = resolver;
		this.description = description;
		this.status = status;
		this.type = type;
	}

	public int getReimbId() {
		return reimbId;
	}

	public void setReimbId(int reimbId) {
		this.reimbId = reimbId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDateTime getSubmitedTime() {
		return submitedTime;
	}

	public void setSubmitedTime(LocalDateTime submitedTime) {
		this.submitedTime = submitedTime;
	}

	public LocalDateTime getResolvedTime() {
		return resolvedTime;
	}

	public void setResolvedTime(LocalDateTime resolvedTime) {
		this.resolvedTime = resolvedTime;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public User getResolver() {
		return resolver;
	}

	public void setResolver(User resolver) {
		this.resolver = resolver;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Reimbursement [reimbId=" + reimbId + ", amount=" + amount + ", submitedTime=" + submitedTime
				+ ", resolvedTime=" + resolvedTime + ", author=" + author + ", resolver=" + resolver + ", description="
				+ description + ", status=" + status + ", type=" + type + "]";
	}

}
