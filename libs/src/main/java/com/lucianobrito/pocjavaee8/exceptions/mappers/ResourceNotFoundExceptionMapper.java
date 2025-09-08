package com.lucianobrito.pocjavaee8.exceptions.mappers;

import com.lucianobrito.pocjavaee8.exceptions.errors.BaseError;
import com.lucianobrito.pocjavaee8.exceptions.errors.ResourceNotFoundException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
public class ResourceNotFoundExceptionMapper extends AbstractMapper<ResourceNotFoundException> {

    @Override
    protected BaseError errorResponse() {
        return new BaseError(Response.Status.BAD_REQUEST);
    }
}
