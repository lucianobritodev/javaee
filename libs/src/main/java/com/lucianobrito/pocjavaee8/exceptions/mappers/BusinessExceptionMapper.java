package com.lucianobrito.pocjavaee8.exceptions.mappers;

import com.lucianobrito.pocjavaee8.exceptions.errors.BaseError;
import com.lucianobrito.pocjavaee8.exceptions.errors.BusinessException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
public class BusinessExceptionMapper extends AbstractMapper<BusinessException> {

    @Override
    protected BaseError errorResponse() {
        return new BaseError(Response.Status.INTERNAL_SERVER_ERROR);
    }
}
