package com.primerApp.aplicacionCRUD.controllers;

import java.util.ArrayList;
import java.util.List;
// Trae de Models
import com.primerApp.aplicacionCRUD.dao.UsuarioDao;
import com.primerApp.aplicacionCRUD.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController{
    @Autowired
    private UsuarioDao usuarioDao;

    // Ruta de controlador
    @RequestMapping(value = "usuario/{id}")
    // // Métodos CRUD!!!
    public Usuario getUsuario(@PathVariable long id){
        Usuario user = new Usuario();
        user.setId(id);
        user.setNombre("Matt");
        user.setApellido("Damon");
        user.setEmail("matt@mail.com");
        user.setPassword("1234");
        return user;
    }

    @RequestMapping(value = "usuarios")
    public List<Usuario> getUsuarios(){
        // Realiza la consulta de Usuarios
        return usuarioDao.getUsuarios();
    }

    @RequestMapping(value = "usuario/crear")
    public Usuario crear(){
        Usuario user = new Usuario();
        user.setNombre("Matt");
        user.setApellido("Damon");
        user.setEmail("matt@mail.com");
        user.setPassword("1234");
        return user;
    }

    @RequestMapping(value = "usuario/eliminar")
    public Usuario eliminar(){
        Usuario user = new Usuario();
        user.setNombre("Matt");
        user.setApellido("Damon");
        user.setEmail("matt@mail.com");
        user.setPassword("1234");
        return user;
    }

    @RequestMapping(value = "usuario/editar")
    public Usuario editar(){
        Usuario user = new Usuario();
        user.setNombre("Matt");
        user.setApellido("Damon");
        user.setEmail("matt@mail.com");
        user.setPassword("1234");
        return user;
    }
}
