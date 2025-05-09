package com.dbp.pc120251backendseccion3.controller;

import com.dbp.pc120251backendseccion3.dto.LoginRequest;
import com.dbp.pc120251backendseccion3.dto.LoginResponse;
import com.dbp.pc120251backendseccion3.model.Usuario;
import com.dbp.pc120251backendseccion3.security.JwtUtil;
import com.dbp.pc120251backendseccion3.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest) {
        Usuario usuario = usuarioService
                .buscarPorUsername(loginRequest.getUsername())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        if (!usuario.getPassword().equals(loginRequest.getPassword())) {
            throw new RuntimeException("Contraseña incorrecta");
        }

        String token = jwtUtil.generarToken(usuario.getUsername());
        return new LoginResponse(token);
    }
}
