package com.spring.restaurantManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.restaurantManagement.entity.Menu;
import com.spring.restaurantManagement.exception.MenuException;
import com.spring.restaurantManagement.repository.MenuRepository;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.Flow.Publisher;

@Service
public class MenuService {
	
	@Autowired
	private MenuRepository mRepo;
	
	public void save(Menu m) {
		try {
		mRepo.save(m);
		}catch(Exception e) {
			throw new MenuException("Can't save menu!!");
		}
	}
	
	public List<Menu> getAllItems(){
		try {
		return mRepo.findAll();
		}catch(Exception e) {
			throw new MenuException("Can't find item!!");
		}
	}
	
	public Menu getMenubyId(int id) {
		try {
		return mRepo.findById(id).get();
		}catch(Exception e) {
			throw new MenuException("Can't find by id!!");
		}
	}
	
	public void deleteById(int id) {
		try {
		mRepo.deleteById(id);
		}catch(Exception e) {
			throw new MenuException("Can't find by id!!");
		}
	}
}
