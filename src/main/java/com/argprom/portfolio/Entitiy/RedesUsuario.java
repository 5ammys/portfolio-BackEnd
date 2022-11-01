package com.argprom.portfolio.Entitiy;

import com.argprom.portfolio.security.entity.Usuario;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "redesusuario")
@Getter@Setter
public class RedesUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRedUser;
    private String enlaceRed;

    @ManyToOne
    private Usuario usuario;
    @ManyToOne
    private Redes redes;

    public RedesUsuario(){}

    public RedesUsuario(Long idRedUser, String enlaceRed, Usuario usuario, Redes redes) {
        this.idRedUser = idRedUser;
        this.enlaceRed = enlaceRed;
        this.usuario = usuario;
        this.redes = redes;
    }
}
