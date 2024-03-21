package com.blog.noticias.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.noticias.dtos.PostDto;
import com.blog.noticias.entities.Post;
import com.blog.noticias.repositories.PostRepository;

@RestController
@RequestMapping("/posts")
public class PostController {
	
	@Autowired
	PostRepository postRepository;

	@GetMapping
	public List<PostDto> getAllPosts(){
		List<Post> lista=this.postRepository.findAll();
		
		return lista.stream().map(PostDto::new).collect(Collectors.toList());
	}
	
}
