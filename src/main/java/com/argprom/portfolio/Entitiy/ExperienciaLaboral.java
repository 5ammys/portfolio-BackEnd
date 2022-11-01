package com.argprom.portfolio.Entitiy;

import com.argprom.portfolio.security.entity.Usuario;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "experiencialaboral")
@Getter@Setter
public class ExperienciaLaboral {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idExp;

    private String nombrePuesto;
    private String fechaInicio;
    private String fechaFin;
    private String descripcion;
    private String logo;

    @ManyToOne
    private Usuario usuario;

    public ExperienciaLaboral() {
    }

    public ExperienciaLaboral(Long idExp, String nombrePuesto, String fechaInicio, String fechaFin, String descripcion, String logo) {
        this.idExp = idExp;
        this.nombrePuesto = nombrePuesto;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.descripcion = descripcion;
        this.logo = logo;
    }

}
