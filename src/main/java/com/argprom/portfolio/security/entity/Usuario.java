package com.argprom.portfolio.security.entity;

import com.argprom.portfolio.Entitiy.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

/**
 * Clase para la base de datos
 */
@Entity
@Table(name="usuario")
public class Usuario {
    //Id de la tabla
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,updatable = false)
    private Long id;
    private String apellido;
    private String nombre;
    private String username;
    private String email;
    private String contrasena;
    private String perfilProfesional;
    private String descripcion;
    private String fotoPerfil;

    @NotNull
    //Relación many to many
    //Un usuario puede tener MUCHOS roles y un rol puede PERTENECER a varios usuarios
    //Tabla intermedia que tiene dos campos que va a tener idUsuario y idRol
    @ManyToMany
    @JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name = "id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "rol_id"))
    private Set<Rol> roles = new HashSet<>();
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "usuario", orphanRemoval = true)
    private Set<Educacion> educacions=new HashSet<>();
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "usuario", orphanRemoval = true)
    private Set<ExperienciaLaboral> experienciaLaborals=new HashSet<>();
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "usuario", orphanRemoval = true)
    private Set<Proyecto> proyectos=new HashSet<>();
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "usuario", orphanRemoval = true)
    private Set<RedesUsuario> redesUsuario=new HashSet<>();
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "usuario", orphanRemoval = true)
    private Set<UsuarioHabilidad> usuarioHabilidad=new HashSet<>();
    public Usuario() {
    }

    //Constuctor sin Id ni Roles


    public Usuario( String apellido, String nombre, String username, String email, String contrasena, String perfilProfesional, String descripcion, String fotoPerfil) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.username = username;
        this.email = email;
        this.contrasena = contrasena;
        this.perfilProfesional = perfilProfesional;
        this.descripcion = descripcion;
        this.fotoPerfil = fotoPerfil;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getPerfilProfesional() {
        return perfilProfesional;
    }

    public void setPerfilProfesional(String perfilProfesional) {
        this.perfilProfesional = perfilProfesional;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    public Set<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }
}
