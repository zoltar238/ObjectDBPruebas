package org.example.dao;

import org.example.entity.Usuario;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Interfaz que define las operaciones de acceso a datos para la entidad Usuario.
 */
public interface UsuarioDAO {

    /**
     * Inserta un nuevo usuario en la base de datos.
     *
     * @param usuario El objeto Usuario que contiene la información del usuario a insertar.
     * @param em El EntityManager utilizado para realizar la operación en la base de datos.
     */
    void insertarUsuario(Usuario usuario, EntityManager em);

    /**
     * Elimina un usuario de la base de datos basándose en el ID proporcionado.
     *
     * @param usuarioId El ID del usuario a eliminar.
     * @param em El EntityManager utilizado para realizar la operación en la base de datos.
     */
    void eliminarUsuario(Long usuarioId, EntityManager em);

    /**
     * Actualiza la información de un usuario existente en la base de datos.
     *
     * @param id El ID del usuario a actualizar.
     * @param usuario El objeto Usuario que contiene la información actualizada del usuario.
     * @param em El EntityManager utilizado para realizar la operación en la base de datos.
     */
    void actualizarUsuario(Long id, Usuario usuario, EntityManager em);

    /**
     * Recupera un usuario de la base de datos basándose en el ID proporcionado.
     *
     * @param usuarioId El ID del usuario a recuperar.
     * @param em El EntityManager utilizado para realizar la operación en la base de datos.
     * @return El objeto Usuario correspondiente al ID proporcionado, o null si no se encuentra.
     */
    Usuario obtenerUsuarioPorId(Long usuarioId, EntityManager em);

    /**
     * Recupera todos los usuarios de la base de datos.
     *
     * @param em El EntityManager utilizado para realizar la operación en la base de datos.
     * @return Una Lista de objetos Usuario que representa todos los usuarios en la base de datos.
     */
    List<Usuario> obtenerUsuarios(EntityManager em);
}
