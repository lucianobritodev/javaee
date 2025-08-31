package com.lucianobrito.poc.javaee.domain.repositories;

import com.lucianobrito.poc.javaee.domain.entities.Usuario;

import javax.ejb.Stateless;


@Stateless
public class UsuarioRepository extends BaseRepository<Usuario, Long> {
    public UsuarioRepository() {
        super(Usuario.class);
    }
}
