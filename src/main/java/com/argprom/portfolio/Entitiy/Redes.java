package com.argprom.portfolio.Entitiy;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "redes")
@Getter@Setter
public class Redes {
    @Id
    private Long id;
    private String nombre;
    private String logo;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true,mappedBy = "redes")
    private Set<RedesUsuario> redesUsuarios=new HashSet<>();

    public Redes(){}

    public Redes(Long id, String nombre, String logo, Set<RedesUsuario> redesUsuarios) {
        this.id = id;
        this.nombre = nombre;
        this.logo = logo;
        this.redesUsuarios = redesUsuarios;
    }
}
