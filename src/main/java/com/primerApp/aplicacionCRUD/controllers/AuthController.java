package com.primerApp.aplicacionCRUD.controllers;

import com.primerApp.aplicacionCRUD.dao.UsuarioDao;
import com.primerApp.aplicacionCRUD.models.Usuario;
import com.primerApp.aplicacionCRUD.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    private UsuarioDao usuarioDao;
    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public String login(@RequestBody Usuario usuario){
        Usuario usuarioIngresado = usuarioDao.obtenerUsuarioCredenciales(usuario);
        if(usuarioIngresado != null){
            // Crear JWT
            String tokenJWT = jwtUtil.create(String.valueOf(usuarioIngresado.getId()), usuarioIngresado.getEmail());
            return tokenJWT;
        }
        return "Error";
    }
}
