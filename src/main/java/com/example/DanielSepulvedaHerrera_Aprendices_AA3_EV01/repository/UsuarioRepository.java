package com.example.DanielSepulvedaHerrera_Aprendices_AA3_EV01.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.DanielSepulvedaHerrera_Aprendices_AA3_EV01.model.Usuarios;


// Repositorio que permite realizar operaciones CRUD sobre la entidad Usuarios.
// Extiende JpaRepository para acceder a métodos predefinidos.
public interface UsuarioRepository extends JpaRepository<Usuarios, Long>{
    
    // Busca un usuario por su email.
    // @param email Correo del usuario
    // @return Usuario encontrado (opcional)
    Optional<Usuarios> findByEmail(String email);
}
