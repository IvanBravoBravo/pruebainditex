package com.inditex.prueba.exception;

public class BrandNotFoundException extends Exception{
    private Integer id;
    public static BrandNotFoundException createWith(Integer id){
        return new BrandNotFoundException(id);
    }
    
    private BrandNotFoundException(Integer id){
        this.id = id;
    }
        
    @Override
    public String getMessage() {
        return "Brand Id '" + id + "' not found";
    }
}
