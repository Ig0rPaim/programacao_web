package com.blog.noticias.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

import com.blog.noticias.dtos.UsuarioDto;
import com.blog.noticias.entities.Usuario;
import com.blog.noticias.repositories.UsuarioRepository;

import jakarta.transaction.Transactional;

public class ControllerServicesUsuarios {
    @Autowired
    UsuarioRepository userRepository;

    public ResponseEntity<UsuarioDto> getUserById(@PathVariable long id) throws Exception{
        var optionalUser = userRepository.findById(id);
        if(!optionalUser.isPresent())
            return ResponseEntity.notFound().build();
        var userDto = new UsuarioDto(optionalUser.get());
        return ResponseEntity.ok(userDto);
    }

    public ResponseEntity<List<UsuarioDto>> getAllUsers() throws Exception{
        var optionalUsers = userRepository.findAll();
        if(optionalUsers.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(optionalUsers.stream().map(UsuarioDto::new).collect(Collectors.toList()));
    }
    
    public ResponseEntity<UsuarioDto> saveUser(@RequestBody UsuarioDto user, UriComponentsBuilder uriBuilder)throws Exception{
        if(user == null)
            return ResponseEntity.internalServerError().build();
        var returnUser = userRepository.save(new Usuario(user));
        if(returnUser == null)
            return ResponseEntity.internalServerError().build();
        return ResponseEntity.created(uriBuilder.path("/usuarios/{id}").buildAndExpand(returnUser.getId()).toUri()).body(new UsuarioDto(returnUser));
    }

    public ResponseEntity deleteUser(@PathVariable long id)throws Exception{
        userRepository.deleteById(id);
        return ResponseEntity.ok().build();

    }

    public ResponseEntity<UsuarioDto> putUser(@RequestBody UsuarioDto usuarioDto){
        var returnUser = userRepository.findById(usuarioDto.id());
        if(!returnUser.isPresent())
            return ResponseEntity.notFound().build();
        userRepository.save(returnUser.get());
        return ResponseEntity.ok(new UsuarioDto(returnUser.get()));
    }



}
