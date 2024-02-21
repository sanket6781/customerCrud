package com.hasmat.customer.exception;

public class ResourceAlreadyExistsException extends RuntimeException{
    public ResourceAlreadyExistsException(){
        super("Data Already Exists");
    }

    public ResourceAlreadyExistsException(String message){
        super(message);
    }
}
