package com.revature.model;

import java.time.LocalTime;

public class Reimbursement {

	private int reimbId;
	private double amount;
	private LocalTime submitedTime;
	private LocalTime resolvedTime;
	private User author;
	private User resolver;
	private String description;
	private Status status;
	private Type type;
	
	public Reimbursement() {
		super();
	}

	public Reimbursement(double amount, LocalTime submitedTime, LocalTime resolvedTime, User author, User resolver,
			String description, Status status, Type type) {
		super();
		this.amount = amount;
		this.submitedTime = submitedTime;
		this.resolvedTime = resolvedTime;
		this.author = author;
		this.resolver = resolver;
		this.description = description;
		this.status = status;
		this.type = type;
	}
	
	public Reimbursement(int reimbId, double amount, LocalTime submitedTime, LocalTime resolvedTime, User author,
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

	public LocalTime getSubmitedTime() {
		return submitedTime;
	}

	public void setSubmitedTime(LocalTime submitedTime) {
		this.submitedTime = submitedTime;
	}

	public LocalTime getResolvedTime() {
		return resolvedTime;
	}

	public void setResolvedTime(LocalTime resolvedTime) {
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


	
	
	
}
