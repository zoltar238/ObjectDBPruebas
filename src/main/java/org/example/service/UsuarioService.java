package org.example.service;

import org.example.dao.UsuarioDAOImp;
import org.example.entity.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Servicio que maneja las operaciones CRUD sobre la entidad {@link Usuario}.
 * <p>
 * Esta clase proporciona métodos para insertar, eliminar, actualizar, obtener un
 * usuario por su ID y obtener todos los usuarios desde la base de datos. Utiliza
 * la clase {@link UsuarioDAOImp} para realizar estas operaciones mediante el uso de
 * JPA (Java Persistence API).
 * <p>
 * Cada operación CRUD se realiza dentro de una sesión de {@link EntityManager},
 * que se obtiene del {@link EntityManagerFactory} creado a partir de la unidad
 * de persistencia definida en la configuración de JPA. Después de realizar las operaciones,
 * el {@link EntityManager} y el {@link EntityManagerFactory} se cierran para liberar
 * los recursos.
 * <p>
 * Los métodos devuelven los resultados correspondientes o no devuelven nada en
 * caso de realizar modificaciones (por ejemplo, eliminar o actualizar).
 * <p>
 * Métodos proporcionados por esta clase:
 * <ul>
 *     <li>insertarUsuario: Inserta un nuevo usuario en la base de datos.</li>
 *     <li>eliminarUsuario: Elimina un usuario de la base de datos utilizando su ID.</li>
 *     <li>actualizarUsuario: Actualiza los datos de un usuario existente en la base de datos.</li>
 *     <li>obtenerUsuarioPorId: Obtiene un usuario específico por su ID.</li>
 *     <li>obtenerTodosLosUsuarios: Obtiene una lista de todos los usuarios almacenados en la base de datos.</li>
 * </ul>
 *
 */
public class UsuarioService {

    private final UsuarioDAOImp usuarioDAOImp = new UsuarioDAOImp();

    /**
     * Inserta un nuevo usuario en la base de datos.
     *
     * @param usuario El objeto {@link Usuario} que se va a insertar.
     */
    public void insertarUsuario(Usuario usuario) {
        // Implementación para insertar un usuario en la base de datos
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("objectdb-remote");
        EntityManager em = emf.createEntityManager();
        usuarioDAOImp.insertarUsuario(usuario, em);
        em.close();  // Cerrar el EntityManager después de la operación
        emf.close();  // Cerrar el EntityManagerFactory después de la operación
    }

    /**
     * Elimina un usuario de la base de datos por su ID.
     *
     * @param idUsuario El ID del usuario a eliminar.
     */
    public void eliminarUsuario(Long idUsuario) {
        // Implementación para eliminar un usuario de la base de datos
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("objectdb-remote");
        EntityManager em = emf.createEntityManager();
        usuarioDAOImp.eliminarUsuario(idUsuario, em);
        em.close();  // Cerrar el EntityManager después de la operación
        emf.close();  // Cerrar el EntityManagerFactory después de la operación
    }

    /**
     * Actualiza los datos de un usuario existente en la base de datos.
     *
     * @param id El ID del usuario que se va a actualizar.
     * @param usuario El objeto {@link Usuario} con los nuevos datos a actualizar.
     */
    public void actualizarUsuario(Long id, Usuario usuario) {
        // Implementación para actualizar un usuario en la base de datos
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("objectdb-remote");
        EntityManager em = emf.createEntityManager();
        usuarioDAOImp.actualizarUsuario(id, usuario, em);
        em.close();  // Cerrar el EntityManager después de la operación
        emf.close();  // Cerrar el EntityManagerFactory después de la operación
    }

    /**
     * Obtiene un usuario de la base de datos por su ID.
     *
     * @param idUsuario El ID del usuario que se desea obtener.
     * @return El objeto {@link Usuario} correspondiente al ID proporcionado,
     *         o {@code null} si no se encuentra un usuario con ese ID.
     */
    public Usuario obtenerUsuarioPorId(Long idUsuario) {
        // Implementación para obtener un usuario por su ID de la base de datos
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("objectdb-remote");
        EntityManager em = emf.createEntityManager();
        Usuario usuario = usuarioDAOImp.obtenerUsuarioPorId(idUsuario, em);
        em.close();  // Cerrar el EntityManager después de la operación
        emf.close();  // Cerrar el EntityManagerFactory después de la operación
        return usuario;
    }

    /**
     * Obtiene una lista de todos los usuarios almacenados en la base de datos.
     *
     * @return Una lista de objetos {@link Usuario} que representan todos los usuarios
     *         en la base de datos.
     */
    public List<Usuario> obtenerTodosLosUsuarios() {
        // Implementación para obtener todos los usuarios de la base de datos
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("objectdb-remote");
        EntityManager em = emf.createEntityManager();
        List<Usuario> usuarios = usuarioDAOImp.obtenerUsuarios(em);
        em.close();  // Cerrar el EntityManager después de la operación
        emf.close();  // Cerrar el EntityManagerFactory después de la operación
        return usuarios;
    }
}
