package com.lucianobrito.poc.javaee.services.domain.entities;


import com.lucianobrito.poc.javaee.services.domain.dtos.UsuarioDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
@NoArgsConstructor(force = true)
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String cpf;
    private String senha;
    private boolean ativo;

    public Usuario(UsuarioDto usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.cpf = usuario.getCpf().replaceAll("\\D", "");
        this.senha = usuario.getSenha();
        this.ativo = usuario.isAtivo();
    }
}
