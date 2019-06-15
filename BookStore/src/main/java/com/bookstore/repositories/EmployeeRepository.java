package com.bookstore.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface EmployeeRepository<T> {
	
	public T findOne(String username);

	public void save(T spittle);
	
	public List<T> remove();

}
