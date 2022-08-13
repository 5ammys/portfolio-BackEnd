package com.argprom.portfolio.Entitiy;

import javax.persistence.*;

@Entity
public class UsuarioHabilidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuarioHabilidad;
    @ManyToOne
    private Usuario usuario;
    @ManyToOne
    private Habilidad habilidad;
    private int porcentaje;

    public UsuarioHabilidad(){

    }
    public UsuarioHabilidad(Long idUsuarioHabilidad, Usuario usuario, Habilidad habilidad, int porcentaje) {
        this.idUsuarioHabilidad = idUsuarioHabilidad;
        this.usuario = usuario;
        this.habilidad = habilidad;
        this.porcentaje = porcentaje;
    }

    public Long getIdUsuarioHabilidad() {
        return idUsuarioHabilidad;
    }

    public void setIdUsuarioHabilidad(Long idUsuarioHabilidad) {
        this.idUsuarioHabilidad = idUsuarioHabilidad;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Habilidad getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(Habilidad habilidad) {
        this.habilidad = habilidad;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }
}
