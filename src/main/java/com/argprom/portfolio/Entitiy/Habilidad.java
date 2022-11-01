package com.argprom.portfolio.Entitiy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter@Setter
@Entity
@Table(name = "habilidades")
public class Habilidad{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHab;
    private String nombre;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true,mappedBy = "habilidad")
    @JsonIgnore
    private Set<UsuarioHabilidad> usuarioHabilidadSet=new HashSet<>();

    public Habilidad() {
    }

    public Habilidad(Long idHab, String nombre) {
        this.idHab = idHab;
        this.nombre = nombre;
    }
}
