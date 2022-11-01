package com.argprom.portfolio.security.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/*
  Clase Encargada de generar la seguridad
  Clase que implementa los privilegios de cada usuario
  UserDetails es una clase propia de Spring Security
 */
public class UsuarioMain implements UserDetails {
    private Long id;

    private String apellido;
    private String nombre;
    private String username;
    private String email;
    private String contrasena;
    private String perfilProfesional;
    private String descripcion;
    private String fotoPerfil;

    private Collection<? extends GrantedAuthority> authorities;

    //Constructor


    public UsuarioMain(Long id, String apellido, String nombre, String username, String email, String contrasena, String perfilProfesional, String descripcion, String fotoPerfil, Collection<? extends GrantedAuthority> authorities) {
        this.id=id;
        this.apellido = apellido;
        this.nombre = nombre;
        this.username = username;
        this.email = email;
        this.contrasena = contrasena;
        this.perfilProfesional = perfilProfesional;
        this.descripcion = descripcion;
        this.fotoPerfil = fotoPerfil;
        this.authorities = authorities;
    }

    //Metodo que asigna los privilegios (autorización)
    public static UsuarioMain build(Usuario usuario){
        List<GrantedAuthority> authorities =
                usuario.getRoles()
                        .stream()
                        .map(rol -> new SimpleGrantedAuthority(rol.getRolNombre().name()))
                .collect(Collectors.toList());
        return new UsuarioMain(usuario.getId(), usuario.getApellido(), usuario.getNombre(), usuario.getUsername(), usuario.getEmail(),
                usuario.getContrasena(), usuario.getPerfilProfesional(), usuario.getDescripcion(), usuario.getFotoPerfil(), authorities);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return contrasena;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
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

    public void setEmail(String email) {
        this.email = email;
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

    public String getEmail() {
        return email;
    }
}
