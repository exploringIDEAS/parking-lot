package com.rahul.exception;

public class NoFreeSlotException extends RuntimeException {
    public NoFreeSlotException(String msg) {
        super(msg);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
