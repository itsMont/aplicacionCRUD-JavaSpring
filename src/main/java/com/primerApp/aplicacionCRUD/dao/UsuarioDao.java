package com.primerApp.aplicacionCRUD.dao;

import com.primerApp.aplicacionCRUD.models.Usuario;

import java.util.List;

public interface UsuarioDao {
    List<Usuario> getUsuarios();

    void eliminar(Long id);

    void registrar(Usuario usuario);
    Usuario obtenerUsuarioCredenciales(Usuario usuario);
}
