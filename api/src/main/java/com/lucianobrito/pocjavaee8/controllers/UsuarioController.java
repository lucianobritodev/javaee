package com.lucianobrito.pocjavaee8.controllers;

import com.lucianobrito.pocjavaee8.domain.dtos.UsuarioDto;
import com.lucianobrito.pocjavaee8.domain.services.UsuarioService;
import lombok.NoArgsConstructor;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/usuarios")
@RequestScoped
@NoArgsConstructor(force = true)
public class UsuarioController {

    @Inject
    private UsuarioService usuarioService;

    @GET
    @Path("/v1")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        return Response.ok(usuarioService.findAll()).build();
    }

    @GET
    @Path("/v1/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(usuarioService.findById(id)).build();
    }

    @POST
    @Path("/v1")
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(UsuarioDto usuarioDto) {
        return Response.ok(usuarioService.create(usuarioDto)).build();
    }

    @PUT
    @Path("/v1/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") Long id,  UsuarioDto usuarioDto) {
        return Response.ok(usuarioService.update(id, usuarioDto)).build();
    }

    @DELETE
    @Path("/v1/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") Long id) {
        usuarioService.delete(id);
        return Response.noContent().build();
    }

    /**
     *
     * S.O.L.I.D.
     * Single Responsibility Principal
     * Open Closed Principal
     * Liskov Substitution Principal
     * Interface Segregation Principal
     * Dependency Inversion Principal
     *
     */
}
