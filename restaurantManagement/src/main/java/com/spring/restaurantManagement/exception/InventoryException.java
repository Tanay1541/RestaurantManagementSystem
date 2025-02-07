package com.spring.restaurantManagement.exception;

public class InventoryException extends RuntimeException {
    
    public InventoryException() {
        
    }
    
    public InventoryException(String message) {
        super(message);
    }

}
