package com.techlab.ecommerce.exception;

public class InvalidCategoryNameException extends RuntimeException{
    public InvalidCategoryNameException(String message){
        super(message);
    }
    
}
