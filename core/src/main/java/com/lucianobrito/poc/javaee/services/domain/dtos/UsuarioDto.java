package com.lucianobrito.poc.javaee.services.domain.dtos;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.lucianobrito.poc.javaee.services.domain.entities.Usuario;

public class UsuarioDto {

    private Long id;
    private String nome;
    private String email;


    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String senha;


    public UsuarioDto(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getNome();
        this.senha = usuario.getSenha();
    }
}
