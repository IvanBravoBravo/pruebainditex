package com.inditex.prueba.exception;

public class BrandExistException extends Exception{
    private String name;
    public static BrandExistException createWith(String name){
        return new BrandExistException(name);
    }
    
    private BrandExistException(String name){
        this.name = name;
    }
        
    @Override
    public String getMessage() {
        return "Brand name '" + name + "' exist";
    }
}
