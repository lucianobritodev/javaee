package com.lucianobrito.poc.javaee.services.domain.services;

import com.lucianobrito.poc.javaee.services.domain.dtos.UsuarioDto;

import java.util.List;

public interface UsuarioService {

    List<UsuarioDto> findAll();

    UsuarioDto findById(Long id);

}
