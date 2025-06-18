package com.deliverymatcher.backend.exception;

public class NotFoundExeption extends RuntimeException{
    public NotFoundExeption ( String message ) {
        super(message);
    }
}
