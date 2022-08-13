package com.argprom.portfolio.Entitiy;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter@Setter
@Entity
@Table(name="usuario")
public class Usuario  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,updatable = false)
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String contrasena;
    private String descripcion;
    private String perfilProfesional;
    private String fotoPerfil;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,orphanRemoval= true,mappedBy = "usuario")
    private Set<UsuarioHabilidad> usuarioHabilidad=new HashSet<>();
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,orphanRemoval= true,mappedBy = "usuario")
    private Set<Educacion> educacions=new HashSet<>();
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,orphanRemoval = true,mappedBy = "usuario")
    private Set<Proyecto> proyectos=new HashSet<>();
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,orphanRemoval = true,mappedBy = "usuario")
    private Set<RedesUsuario> redesUsuarios=new HashSet<>();
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,orphanRemoval = true,mappedBy = "usuario")
    private Set<ExperienciaLaboral> experienciaLaborals=new HashSet<>();


    public Usuario() {
    }

    public Usuario(Long id, String nombre, String apellido, String email, String contrasena, String descripcion, String perfilProfesional, String fotoPerfil) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.contrasena = contrasena;
        this.descripcion = descripcion;
        this.perfilProfesional = perfilProfesional;
        this.fotoPerfil = fotoPerfil;
    }
}
