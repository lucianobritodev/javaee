package com.lucianobrito.poc.javaee.controllers;

import com.lucianobrito.poc.javaee.services.domain.services.UsuarioService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Inject
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GET
    @Path("/v1")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        return Response.ok(usuarioService.findAll()).build();
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
