package com.example.DanielSepulvedaHerrera_Aprendices_AA3_EV01.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.DanielSepulvedaHerrera_Aprendices_AA3_EV01.dto.UsuarioDTO;
import com.example.DanielSepulvedaHerrera_Aprendices_AA3_EV01.model.Rol;
import com.example.DanielSepulvedaHerrera_Aprendices_AA3_EV01.model.Usuarios;
import com.example.DanielSepulvedaHerrera_Aprendices_AA3_EV01.repository.UsuarioRepository;
import com.example.DanielSepulvedaHerrera_Aprendices_AA3_EV01.service.UsuarioService;

import jakarta.persistence.EntityNotFoundException;

// Implementación de la lógica de negocio para la gestión de usuarios.
@Service
public class UsuarioServiceImpl implements UsuarioService{

    // Repositorio para acceso a la base de datos
    private final UsuarioRepository usuariorepository;

    public UsuarioServiceImpl(UsuarioRepository usuariorepository) {
        this.usuariorepository = usuariorepository;
    }

    // Crea un nuevo usuario a partir de un DTO.
    @Override
    public Usuarios crear(UsuarioDTO dto) {
        Usuarios usuarios = Usuarios.builder()
                .nombre(dto.getNombre())
                .apellido(dto.getApellido())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .rol(dto.getRol() != null ? dto.getRol() : Rol.CLIENTE)
                .build();

        return usuariorepository.save(usuarios);
    }

    // Actualiza un usuario existente.
    @Override
    public Usuarios actualizar(Long id, UsuarioDTO dto) {
        Usuarios usuarios = buscarPorId(id);

        usuarios.setNombre(dto.getNombre());
        usuarios.setApellido(dto.getApellido());
        usuarios.setEmail(dto.getEmail());
        usuarios.setPassword(dto.getPassword());
        usuarios.setRol(dto.getRol());

        return usuariorepository.save(usuarios);
    }

    // Elimina un usuario por ID.
    @Override
    public void eliminar(Long id) {
        usuariorepository.deleteById(id);
    }

    // Retorna todos los usuarios.
    @Override
    public List<Usuarios> listar() {
        return usuariorepository.findAll();
    }

    // Busca un usuario por ID o lanza excepción si no existe.
    @Override
    public Usuarios buscarPorId(Long id) {
        return usuariorepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado con id " + id));
    }
}