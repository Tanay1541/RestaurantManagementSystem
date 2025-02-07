package com.spring.restaurantManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.restaurantManagement.entity.Inventory;
import com.spring.restaurantManagement.exception.InventoryException;
import com.spring.restaurantManagement.repository.InventoryRepository;

import java.util.List;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepo;

    public void save(Inventory inventory) {
        try {
            inventoryRepo.save(inventory);
        } catch (Exception e) {
            throw new InventoryException("Can't save inventory!!");
        }
    }

    public List<Inventory> getAllItems() {
        try {
            return inventoryRepo.findAll();
        } catch (Exception e) {
            throw new InventoryException("Can't find items!!");
        }
    }

    public Inventory getInventoryById(Long id) {
        try {
            return inventoryRepo.findById(id).orElseThrow(() -> new InventoryException("Can't find by id!!"));
        } catch (Exception e) {
            throw new InventoryException("Can't find by id!!");
        }
    }

    public void deleteById(Long id) {
        try {
            inventoryRepo.deleteById(id);
        } catch (Exception e) {
            throw new InventoryException("Can't find by id!!");
        }
    }
}
