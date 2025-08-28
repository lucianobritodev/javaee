package com.lucianobrito.poc.javaee.exceptions.mappers;

import com.lucianobrito.poc.javaee.exceptions.errors.BaseError;
import com.lucianobrito.poc.javaee.exceptions.errors.BusinessException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
public class BusinessExceptionMapper extends AbstractMapper<BusinessException> {

    @Override
    protected BaseError errorResponse() {
        return new BaseError(Response.Status.INTERNAL_SERVER_ERROR);
    }
}
