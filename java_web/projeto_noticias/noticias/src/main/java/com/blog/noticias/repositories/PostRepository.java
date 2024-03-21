package com.blog.noticias.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.noticias.entities.Post;

public interface PostRepository extends JpaRepository<Post, Long>{

}
