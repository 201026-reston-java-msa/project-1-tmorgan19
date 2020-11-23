package com.revature.dao;

import java.util.List;

public interface CrudRepository<T> {

	public void save(T t);
	public List<T> findAll(T t);
	public T findById(int id);
	public void update(T t);
}
