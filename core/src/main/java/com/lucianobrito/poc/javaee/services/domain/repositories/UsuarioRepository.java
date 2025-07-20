package com.lucianobrito.poc.javaee.services.domain.repositories;

import com.lucianobrito.poc.javaee.services.domain.entities.Usuario;
import jakarta.data.repository.Repository;

@Repository
public class UsuarioRepository extends BaseEntity<Usuario, Long> {
}
