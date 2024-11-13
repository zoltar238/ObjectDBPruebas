package org.example.service;

import org.example.dao.UsuarioDAOImp;
import org.example.entity.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class UsuarioService {

    private final UsuarioDAOImp usuarioDAOImp = new UsuarioDAOImp();
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("objectdb-remote");

    /**
     * Inserta un nuevo usuario en la base de datos.
     *
     * @param usuario El objeto {@link Usuario} que se va a insertar.
     */
    public void insertarUsuario(Usuario usuario) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            usuarioDAOImp.insertarUsuario(usuario, em);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

    /**
     * Elimina un usuario de la base de datos por su ID.
     *
     * @param idUsuario El ID del usuario a eliminar.
     */
    public void eliminarUsuario(Long idUsuario) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            usuarioDAOImp.eliminarUsuario(idUsuario, em);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

    /**
     * Actualiza los datos de un usuario existente en la base de datos.
     *
     * @param id El ID del usuario que se va a actualizar.
     * @param usuario El objeto {@link Usuario} con los nuevos datos a actualizar.
     */
    public void actualizarUsuario(Long id, Usuario usuario) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            usuarioDAOImp.actualizarUsuario(id, usuario, em);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

    /**
     * Obtiene un usuario de la base de datos por su ID.
     *
     * @param idUsuario El ID del usuario que se desea obtener.
     * @return El objeto {@link Usuario} correspondiente al ID proporcionado,
     *         o {@code null} si no se encuentra un usuario con ese ID.
     */
    public Usuario obtenerUsuarioPorId(Long idUsuario) {
        EntityManager em = emf.createEntityManager();
        try {
            return usuarioDAOImp.obtenerUsuarioPorId(idUsuario, em);
        } finally {
            em.close();
        }
    }

    /**
     * Obtiene una lista de todos los usuarios almacenados en la base de datos.
     *
     * @return Una lista de objetos {@link Usuario} que representan todos los usuarios
     *         en la base de datos.
     */
    public List<Usuario> obtenerTodosLosUsuarios() {
        EntityManager em = emf.createEntityManager();
        try {
            return usuarioDAOImp.obtenerUsuarios(em);
        } finally {
            em.close();
        }
    }

    /**
     * Cierra el EntityManagerFactory.
     */
    public void cerrarEntityManagerFactory() {
        emf.close();
    }
}
