package com.primerApp.aplicacionCRUD.dao;

import com.primerApp.aplicacionCRUD.models.Usuario;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;
@Repository
// Permite realizar conexiones
@Transactional
public class UsuarioDaoImp implements UsuarioDao {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Usuario> getUsuarios() {
        // Consulta de SQL
        String query = "FROM Usuario";
        // Vuelve lista usuarios
        return entityManager.createQuery(query).getResultList();
    }
}
