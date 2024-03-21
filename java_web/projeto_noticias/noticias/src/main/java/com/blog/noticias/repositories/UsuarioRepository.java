package com.blog.noticias.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.noticias.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
