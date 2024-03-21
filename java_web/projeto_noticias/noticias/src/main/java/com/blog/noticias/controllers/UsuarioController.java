package com.blog.noticias.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.blog.noticias.dtos.UsuarioDto;
import com.blog.noticias.entities.Usuario;
import com.blog.noticias.repositories.UsuarioRepository;
import com.blog.noticias.services.ControllerServicesUsuarios;

import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/users")
public class UsuarioController {

    @Autowired
    ControllerServicesUsuarios userServices;

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDto> getUserById(@PathVariable long id){
        try{
            return userServices.getUserById(id);
        }catch(Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDto>> getAllUsers(){
        try{
            return userServices.getAllUsers();
        }catch(Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping
    public ResponseEntity<UsuarioDto> saveUser(@RequestBody UsuarioDto user, UriComponentsBuilder uriBuilder){
        try{
            return userServices.saveUser(user, uriBuilder);
        }catch(Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/{id}")
    @Transactional // de qual biblioteca? jack.. ou spring
    public ResponseEntity deleteUser(@PathVariable long id){
        try{
            return userServices.deleteUser(id);
        }catch(Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping()
    @Transactional // de qual biblioteca? jack.. ou spring
    public ResponseEntity<UsuarioDto> putUser(@RequestBody UsuarioDto usuarioDto){
        try{
            return userServices.putUser(usuarioDto);
        }catch(Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    
}
