package org.example.dao;

import org.example.entity.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;
/**
 * Implementación de la interfaz {@link UsuarioDAO} para realizar operaciones CRUD
 * sobre los objetos {@link Usuario} en la base de datos
 * usando JPA (Java Persistence API).
 * <p>
 * Esta clase contiene los métodos necesarios para insertar, eliminar, actualizar y
 * obtener usuarios en la base de datos. Utiliza el {@link EntityManager} para interactuar
 * con la base de datos y realiza las operaciones dentro de transacciones para asegurar
 * la consistencia de los datos.
 * <p>
 * Los métodos lanzan una {@link RuntimeException} si ocurre un error
 * durante la transacción.
 * <p>
 * Las operaciones de base de datos son transaccionales, es decir, se realizan dentro de un
 * bloque transaccional que garantiza que los cambios a la base de datos se confirmen solo si
 * todo el proceso es exitoso. Si ocurre un error, la transacción se revierte.
 * <p>
 * Métodos proporcionados por esta clase:
 * <ul>
 *     <li>insertarUsuario: Inserta un nuevo usuario en la base de datos.</li>
 *     <li>eliminarUsuario: Elimina un usuario de la base de datos dado su ID.</li>
 *     <li>actualizarUsuario: Actualiza los datos de un usuario en la base de datos.</li>
 *     <li>obtenerUsuarioPorId: Obtiene un usuario de la base de datos utilizando su ID.</li>
 *     <li>obtenerUsuarios: Obtiene una lista de todos los usuarios almacenados en la base de datos.</li>
 * </ul>
 */
public class UsuarioDAOImp implements UsuarioDAO {

        /**
     * Inserta un usuario en la base de datos.
     *
     * @param usuario El objeto Usuario que se va a insertar.
     * @param em El EntityManager que se utiliza para interactuar con la base de datos.
     *
     * @throws RuntimeException Si ocurre algún error durante la transacción.
     */
    @Override
    public void insertarUsuario(Usuario usuario, EntityManager em) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(usuario);  // Insertar el usuario en la base de datos
            transaction.commit();  // Confirmar la transacción
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();  // Revertir si ocurre un error
            }
            throw new RuntimeException(e);
        }
    }

        /**
     * Elimina un usuario de la base de datos.
     * 
     * @param usuarioId El ID del usuario que se va a eliminar.
     * @param em El EntityManager que se utiliza para interactuar con la base de datos.
     * 
     * @throws RuntimeException Si ocurre algún error durante la transacción.
     */
    @Override
    public void eliminarUsuario(Long usuarioId, EntityManager em) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Usuario usuario = em.find(Usuario.class, usuarioId);  // Buscar el usuario por su ID
            if (usuario != null) {
                em.remove(usuario);  // Eliminar el usuario
                transaction.commit();  // Confirmar la transacción
            }
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();  // Revertir si ocurre un error
            }
            throw new RuntimeException(e);
        }
    }

        /**
     * Actualiza un usuario existente en la base de datos.
     * 
     * @param id El ID del usuario que se va a actualizar.
     * @param usuario El objeto Usuario con los nuevos datos a actualizar.
     * @param em El EntityManager que se utiliza para interactuar con la base de datos.
     * 
     * @throws RuntimeException Si ocurre algún error durante la transacción.
     */
    @Override
    public void actualizarUsuario(Long id, Usuario usuario, EntityManager em) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            // Buscar el usuario por ID y actualizar los campos necesarios
            Usuario usuarioExistente = em.find(Usuario.class, id);
            if (usuarioExistente != null) {
                usuarioExistente.setNombre(usuario.getNombre());
                usuarioExistente.setEmail(usuario.getEmail());
                usuarioExistente.setFechaRegistro(usuario.getFechaRegistro());
                em.merge(usuarioExistente);  // Persistir los cambios
                transaction.commit();  // Confirmar la transacción
            }
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();  // Revertir si ocurre un error
            }
            throw new RuntimeException(e);
        }
    }

        /**
     * Obtiene un usuario de la base de datos por su ID.
     *
     * @param usuarioId El ID del usuario que se desea obtener.
     * @param em El EntityManager que se utiliza para interactuar con la base de datos.
     * @return El objeto Usuario correspondiente al ID proporcionado, o null si no se encuentra.
     */
    @Override
    public Usuario obtenerUsuarioPorId(Long usuarioId, EntityManager em) {
        return em.find(Usuario.class, usuarioId);  // Buscar el usuario por ID
    }

        /**
     * Obtiene una lista de todos los usuarios almacenados en la base de datos.
     *
     * @param em El EntityManager que se utiliza para interactuar con la base de datos.
     * @return Una lista de objetos Usuario que representa todos los usuarios en la base de datos.
     *         La lista estará vacía si no hay usuarios en la base de datos.
     */
    @Override
    public List<Usuario> obtenerUsuarios(EntityManager em) {
        TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u", Usuario.class);
        return query.getResultList();
    }
}
