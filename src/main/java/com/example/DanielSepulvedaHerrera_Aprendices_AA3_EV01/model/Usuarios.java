package com.example.DanielSepulvedaHerrera_Aprendices_AA3_EV01.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
// import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
// import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


// Entidad que representa la tabla "usuarios" en la base de datos.
@Entity
@Table(name = "usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuarios {

    // Identificador único del usuario
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUsuario")
    private Long idUsuario;

    // Nombre del usuario (no puede ser nulo)
    @Column(nullable = false)
    private String nombre;

    // Apellido del usuario (no puede ser nulo)
    @Column(nullable = false)
    private String apellido;

    // Email único del usuario
    @Column(nullable = false, unique = true)
    private String email;

    // Contraseña del usuario
    @Column(nullable = false)
    private String password;

    // Rol del usuario almacenado como texto
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Rol rol;

    
    // Verifica si algún campo obligatorio está vacío.
    // @return true si algún campo está vacío
    public boolean isEmpty() {
        return this.nombre == null || this.nombre.isEmpty() ||
               this.apellido == null || this.apellido.isEmpty() ||
               this.email == null || this.email.isEmpty() ||
               this.password == null || this.password.isEmpty() ||
               this.rol == null;
    }

    
    // Constructor utilizado para autenticación básica.
    public Usuarios(String email, String password) {
        this.email = email;
        this.password = password;
    }
}