package com.inditex.prueba.exception;

public class ProductExistException extends Exception{
    private String name;
    public static ProductExistException createWith(String name){
        return new ProductExistException(name);
    }
    
    private ProductExistException(String name){
        this.name = name;
    }
        
    @Override
    public String getMessage() {
        return "Product name '" + name + "' exist";
    }
}
