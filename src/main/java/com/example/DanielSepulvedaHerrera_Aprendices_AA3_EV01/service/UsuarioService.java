package com.example.DanielSepulvedaHerrera_Aprendices_AA3_EV01.service;

import java.util.List;

import com.example.DanielSepulvedaHerrera_Aprendices_AA3_EV01.dto.UsuarioDTO;
import com.example.DanielSepulvedaHerrera_Aprendices_AA3_EV01.model.Usuarios;

// Interfaz que define las operaciones del servicio de usuarios.
public interface UsuarioService {
    Usuarios crear(UsuarioDTO dto);
    List<Usuarios> listar();
    Usuarios buscarPorId(Long id);
    Usuarios actualizar(Long id, UsuarioDTO dto);
    void eliminar(Long id);
}
