package com.inditex.prueba.exception;

public class ProductNotFoundException extends Exception {
    private Integer id;
    public static ProductNotFoundException createWith(Integer id){
        return new ProductNotFoundException(id);
    }
    
    private ProductNotFoundException(Integer id){
        this.id = id;
    }
        
    @Override
    public String getMessage() {
        return "Product Id '" + id + "' not found";
    }
}
