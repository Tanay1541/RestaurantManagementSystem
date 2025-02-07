package com.spring.restaurantManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.restaurantManagement.entity.Employee;
import com.spring.restaurantManagement.exception.EmployeeException;
import com.spring.restaurantManagement.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository eRepo;
	
	public void save(Employee e) {
		try {
		eRepo.save(e);
		}catch (Exception e1) {
			throw new EmployeeException("Invalid Employee!!");
		}
	}
	
	public List<Employee> getAllItems(){
		try {
		return eRepo.findAll();
		}catch (Exception e) {
			throw new EmployeeException("Invalid Employee details!!");
		}
	}
	
	public Employee getEmployeeById(int id) {
		try {
		return eRepo.findById(id).get();
		}catch(Exception e) {
			throw new EmployeeException("Can't find Employee");
		}
	}
	
	public void deleteById(int id) {
		try {
		eRepo.deleteById(id);
		}catch(Exception e) {
			throw new EmployeeException("Can't find Employee");
		}
	}
}


