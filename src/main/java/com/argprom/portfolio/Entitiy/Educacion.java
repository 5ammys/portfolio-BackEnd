package com.argprom.portfolio.Entitiy;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;

@Entity
@Table(name="educacion")
@Getter@Setter
public class Educacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEdu;
    private String nombre;
    private String titulo;
    private String descripcion;
    private String fechaInicio;
    private String fechaFin;
    @ManyToOne
    @JsonIgnore
    private Usuario usuario;

    public Educacion() {}

    public Educacion(Long idEdu, String nombre, String titulo, String descripcion, String fechaInicio, String fechaFin) {
        this.idEdu = idEdu;
        this.nombre = nombre;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }
}
