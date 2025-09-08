package com.lucianobrito.pocjavaee8.exceptions.mappers;

import com.lucianobrito.pocjavaee8.exceptions.errors.BaseError;
import com.lucianobrito.pocjavaee8.exceptions.errors.DefaulResponseError;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.ExceptionMapper;
import java.time.OffsetDateTime;

public abstract class AbstractMapper<T extends Throwable> implements ExceptionMapper<T> {

    @Context
    private UriInfo uriInfo;

    @Override
    public Response toResponse(T e) {
        BaseError error = errorResponse();
        String path = uriInfo.getRequestUri().toString();
        String message = error.getMessage() != null ? error.getMessage() : e.getMessage();
        DefaulResponseError defaulResponseError = new DefaulResponseError(error.getStatus().getStatusCode(), message, path, OffsetDateTime.now());
        return Response.status(error.getStatus()).entity(defaulResponseError).build();
    }

    protected abstract BaseError errorResponse();
}
