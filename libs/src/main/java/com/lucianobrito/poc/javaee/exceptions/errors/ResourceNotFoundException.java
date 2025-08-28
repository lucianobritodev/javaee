package com.lucianobrito.poc.javaee.exceptions.errors;

import javax.ejb.ApplicationException;

@ApplicationException(rollback = true)
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}

