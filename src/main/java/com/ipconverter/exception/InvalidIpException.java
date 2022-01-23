package com.ipconverter.exception;

public class InvalidIpException extends Exception {
    public InvalidIpException(String errorMessage) {
        super(errorMessage);
    }
}
