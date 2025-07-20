package com.lucianobrito.poc.javaee.services.domain.services.impl;

import com.lucianobrito.poc.javaee.services.domain.dtos.UsuarioDto;
import com.lucianobrito.poc.javaee.services.domain.entities.Usuario;
import com.lucianobrito.poc.javaee.services.domain.repositories.UsuarioRepository;
import com.lucianobrito.poc.javaee.services.domain.services.UsuarioService;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;

@Stateless
public class UsuarioServiceImpl implements UsuarioService {

    private UsuarioRepository usuarioRepository;

    @Inject
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<UsuarioDto> findAll() {
        return usuarioRepository.findAll(Usuario.class).stream().map(UsuarioDto::new).toList();
    }

    @Override
    public UsuarioDto findById(Long id) {
        Usuario response = usuarioRepository.findById(id, Usuario.class);
        return new UsuarioDto(response);
    }


}
