package com.lucianobrito.poc.javaee.services.domain.services.impl;

import com.lucianobrito.poc.javaee.exceptions.errors.ResourceNotFoundException;
import com.lucianobrito.poc.javaee.services.domain.dtos.UsuarioDto;
import com.lucianobrito.poc.javaee.services.domain.entities.Usuario;
import com.lucianobrito.poc.javaee.services.domain.repositories.UsuarioRepository;
import com.lucianobrito.poc.javaee.services.domain.services.BaseService;
import com.lucianobrito.poc.javaee.services.domain.services.UsuarioService;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

import static javax.ejb.TransactionAttributeType.REQUIRED;

@Slf4j
@Stateless
@NoArgsConstructor(force = true)
public class UsuarioServiceImpl extends BaseService implements UsuarioService {

    @Inject
    private UsuarioRepository usuarioRepository;

    @Override
    public List<UsuarioDto> findAll() {
        try {
            return usuarioRepository.findAll().stream()
                    .map(entity -> entityToDto(entity, UsuarioDto.class))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw genericError(e.getMessage());
        }
    }

    @Override
    public UsuarioDto findById(Long id) {
        try {
            return usuarioRepository.findById(id)
                    .map(entity -> entityToDto(entity, UsuarioDto.class))
                    .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado!"));
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw genericError(e.getMessage());
        }
    }

    @Override
    @TransactionAttribute(REQUIRED)
    public UsuarioDto create(final UsuarioDto usuarioDto) {
        try {
            Usuario usuario = new Usuario(usuarioDto);
            usuario.setId(null);
            usuario = usuarioRepository.create(usuario);
            return entityToDto(usuario, UsuarioDto.class);
        } catch (Exception e) {
            throw genericError(e.getMessage());
        }
    }

    @Override
    @TransactionAttribute(REQUIRED)
    public UsuarioDto update(Long id, final UsuarioDto usuarioDto) {
        try {
            findById(id);
            usuarioDto.setId(id);
            Usuario usuario = new Usuario(usuarioDto);
            usuario = usuarioRepository.update(usuario);
            return entityToDto(usuario, UsuarioDto.class);
        } catch (Exception e) {
            throw genericError(e.getMessage());
        }
    }

    @Override
    @TransactionAttribute(REQUIRED)
    public void delete(Long id) {
        try {
            usuarioRepository.deleteById(id);
        } catch (Exception e) {
            throw genericError(e.getMessage());
        }
    }
}
