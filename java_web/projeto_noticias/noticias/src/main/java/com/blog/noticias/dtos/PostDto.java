package com.blog.noticias.dtos;

import com.blog.noticias.entities.Categoria;
import com.blog.noticias.entities.Post;

public record PostDto(Long id, String titulo, String texto,  String usuario, Categoria categoria) {

	public PostDto(Post post) {
		this(post.getId(), post.getTitulo(),post.getTexto(), post.getUsuario().getNome(), post.getCategoria());
	}
}
