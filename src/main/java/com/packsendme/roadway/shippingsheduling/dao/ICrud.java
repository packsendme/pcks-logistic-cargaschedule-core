package com.packsendme.roadway.shippingsheduling.dao;

import java.util.List;

public interface ICrud<T> {
	
	public T findOne(String value);
	public T save(T entity);
	public List<T> findAll();
	public void delete(String id);


}
