package com.lucianobrito.poc.javaee.services.domain.repositories;

import com.lucianobrito.poc.javaee.services.domain.entities.Usuario;

import javax.ejb.Stateless;


@Stateless
public class UsuarioRepository extends BaseRepository<Usuario, Long> {
    public UsuarioRepository() {
        super(Usuario.class);
    }
}
