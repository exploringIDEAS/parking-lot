package com.rahul.exception;

public class AlreadyBookedSlotException extends RuntimeException {
    public AlreadyBookedSlotException(String msg) {
        super(msg);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
