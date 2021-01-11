package com.rahul.exception;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String msg) {
        super(msg);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
