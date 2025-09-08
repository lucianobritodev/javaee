package com.lucianobrito.pocjavaee8.domain.repositories;

import com.lucianobrito.pocjavaee8.domain.entities.Usuario;

import javax.ejb.Stateless;


@Stateless
public class UsuarioRepository extends BaseRepository<Usuario, Long> {
    public UsuarioRepository() {
        super(Usuario.class);
    }
}
