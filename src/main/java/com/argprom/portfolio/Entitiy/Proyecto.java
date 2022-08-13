package com.argprom.portfolio.Entitiy;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "proyecto")
@Getter@Setter
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProyecto;
    private String nombre;
    private String fechaRealizacion;
    private String enlaceProyecto;
    @ManyToOne
    private Usuario usuario;

    public Proyecto(){}

    public Proyecto(Long idProyecto, String nombre, String fechaRealizacion, String enlaceProyecto) {
        this.idProyecto = idProyecto;
        this.nombre = nombre;
        this.fechaRealizacion = fechaRealizacion;
        this.enlaceProyecto = enlaceProyecto;
    }
}
