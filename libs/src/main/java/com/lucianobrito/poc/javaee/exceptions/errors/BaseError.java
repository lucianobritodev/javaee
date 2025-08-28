package com.lucianobrito.poc.javaee.exceptions.errors;

import lombok.Getter;

import javax.ws.rs.core.Response;

@Getter
public class BaseError {

    private Response.Status status;
    private String message;

    public BaseError(Response.Status status) {
        this.status = status;
    }

    public BaseError(Response.Status status, String message) {
        this.status = status;
        this.message = message;
    }
}
