package com.blog.noticias.dtos;

import com.blog.noticias.entities.Usuario;

public record UsuarioDto(Long id, String nome, String login, String senha) {

    public UsuarioDto(Usuario user){
        this(user.getId(), user.getNome(), user.getLogin(), user.getSenha());
    }
}
