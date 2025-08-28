package com.lucianobrito.poc.javaee.exceptions.errors;

import javax.ejb.ApplicationException;

@ApplicationException(rollback = true)
public class BusinessException extends RuntimeException {
    public BusinessException(String message) {
        super(message);
    }
}
