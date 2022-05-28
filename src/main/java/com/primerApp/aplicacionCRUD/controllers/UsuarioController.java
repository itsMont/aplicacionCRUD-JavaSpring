package com.primerApp.aplicacionCRUD.controllers;

import java.util.ArrayList;
import java.util.List;
// Trae de Models
import com.primerApp.aplicacionCRUD.dao.UsuarioDao;
import com.primerApp.aplicacionCRUD.models.Usuario;
import com.primerApp.aplicacionCRUD.utils.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsuarioController{
    @Autowired
    private UsuarioDao usuarioDao;
    @Autowired
    private JWTUtil jwtUtil;

    // Ruta de controlador
    @RequestMapping(value = "api/usuario/{id}", method = RequestMethod.GET)
    // Métodos CRUD!!!
    public Usuario getUsuario(@PathVariable Long id){
        Usuario user = new Usuario();
        user.setId(id);
        user.setNombre("Matt");
        user.setApellido("Damon");
        user.setEmail("matt@mail.com");
        user.setPassword("1234");
        return user;
    }
    // Por defecto usa method = RequestMethod.GET
    @RequestMapping(value = "api/usuarios")
    // Va a necesitar que estemos logueados para poder mostrar usuarios. Ver más en Spring Securiry y Control Errores
    public List<Usuario> getUsuarios(@RequestHeader(value = "Authorization") String token){
        // Verificar que no sea nulo
        if (!validarToken(token)){
            return null;
        }
        // Realiza la consulta de Usuarios
        return usuarioDao.getUsuarios();
    }
    public boolean validarToken(String token){
        // Obtener id de usuario
        String idUsuario = jwtUtil.getKey(token);
        return idUsuario != null;
    }

    @RequestMapping(value = "api/usuarios", method = RequestMethod.POST)
    public void registrar(@RequestBody Usuario usuario){
        // Usa Argon2 para seguridad al iniciar sesión usando HASH
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2d);
        // Realiza iteraciones de encriptación - Uso de memoria - Hilos de procesos
        String hash = argon2.hash(1, 1024, 1, usuario.getPassword());
        usuario.setPassword(hash);

        usuarioDao.registrar(usuario);
    }

    @RequestMapping(value = "api/usuarios/{id}", method = RequestMethod.DELETE)
    public void eliminar(@PathVariable Long id, @RequestHeader(value = "Authorization") String token){
        if (!validarToken(token)){
            return;
        }
        usuarioDao.eliminar(id);
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
