package com.argprom.portfolio.security.controller;

import com.argprom.portfolio.security.dto.JwtDto;
import com.argprom.portfolio.security.dto.LoginUsuario;
import com.argprom.portfolio.security.dto.Mensaje;
import com.argprom.portfolio.security.dto.NuevoUsuario;
import com.argprom.portfolio.security.entity.Rol;
import com.argprom.portfolio.security.entity.Usuario;
import com.argprom.portfolio.security.entity.UsuarioMain;
import com.argprom.portfolio.security.enums.RolNombre;
import com.argprom.portfolio.security.jwt.JwtProvider;
import com.argprom.portfolio.security.service.RolService;
import com.argprom.portfolio.security.service.UserDetailsServiceImpl;
import com.argprom.portfolio.security.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Autowired
    RolService rolService;

    @Autowired
    JwtProvider jwtProvider;

    //Espera un json y lo convierte a tipo clase NuevoUsuario
    @PostMapping("/nuevoUsuario")
    public ResponseEntity<?> nuevoUsuario(@Valid @RequestBody NuevoUsuario nuevoUsuario,
                                          BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ResponseEntity<>(new Mensaje("Campos mal o email invalido"), HttpStatus.BAD_REQUEST);
        }
        if(usuarioService.existsByUsuario(nuevoUsuario.getUsername())){
            return new ResponseEntity<>(new Mensaje("Ese nombre de usuario ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(usuarioService.existsByEmail(nuevoUsuario.getEmail())){
            return new ResponseEntity<>(new Mensaje("Ese email ya existe"), HttpStatus.BAD_REQUEST);
        }

        Usuario usuario = new Usuario(nuevoUsuario.getApellido(), nuevoUsuario.getNombre(), nuevoUsuario.getUsername(),
                nuevoUsuario.getEmail(), passwordEncoder.encode(nuevoUsuario.getPassword()),nuevoUsuario.getPerfilProfesional(),nuevoUsuario.getDescripcion(),nuevoUsuario.getFotoPerfil());

        Set<Rol> roles = new HashSet<>();
        roles.add(rolService.getByRolNombre(RolNombre.ROLE_USER).get());
        if(nuevoUsuario.getRoles().contains("ADMIN"))
            roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());
        usuario.setRoles(roles);

        usuarioService.save(usuario);

        return new ResponseEntity<>(new Mensaje("Usuario creado"), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult){
        if (bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("Campos mal"), HttpStatus.BAD_REQUEST);
        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(loginUsuario.getUsername(),
                                loginUsuario.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        return new ResponseEntity<>(jwtDto, HttpStatus.OK);
    }

    @GetMapping("/actual")
    public UsuarioMain obtenerUsuarioActual(Principal principal){
        return (UsuarioMain) this.userDetailsService.loadUserByUsername(principal.getName());
    }
}
