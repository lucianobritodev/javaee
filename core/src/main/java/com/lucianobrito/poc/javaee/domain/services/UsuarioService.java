package com.lucianobrito.poc.javaee.domain.services;

import com.lucianobrito.poc.javaee.domain.dtos.UsuarioDto;

import java.util.List;

public interface UsuarioService {

    List<UsuarioDto> findAll();

    UsuarioDto findById(Long id);

    UsuarioDto create(UsuarioDto usuarioDto);

    UsuarioDto update(Long id, UsuarioDto usuarioDto);

    void delete(Long id);
}
