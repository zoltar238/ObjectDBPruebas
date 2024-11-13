package org.example;

import org.example.entity.Usuario;
import org.example.service.UsuarioService;


/**
 * Clase principal del proyecto.
 * <p>
 *Este proyecto demuestra la implementacion de operaciones CRUD
 *sobre la base de datos de objetos {@code Objectdb}.
 *
 * <p>Esta aplicación demuestra el uso de {@link UsuarioService} para gestionar usuarios
 * y persistir los datos en una base de datos {@code ObjectDB}.</p>
 *
 * Características principales:
 * <ul>
 *   <li>Inserción de usuarios en la base de datos</li>
 *   <li>Obtención de un usuario por su ID</li>
 *   <li>Actualización de un usuario pur su ID</li>
 *   <li>Eliminación de usuarios por us ID</li>
 *   <li>Obtencion de todos los usuarios almacenados</li>
 * </ul>
 *
 * @author Andrei Darius Bacanu
 * @since 2024-11-07
 */
public class Main {
    public static void main(String[] args) {

        UsuarioService usuarioService = new UsuarioService();

        Usuario usuario = Usuario.builder()
                .email("usuario1@example.com")
                .nombre("Usuario Prueba1")
                .fechaRegistro(new java.sql.Date(System.currentTimeMillis()))
                .build();

        Usuario usuario2 = Usuario.builder()
                .email("usuario2@example.com")
                .nombre("Usuario Prueba2")
                .fechaRegistro(new java.sql.Date(System.currentTimeMillis()))
                .build();

        Usuario usuario3 = Usuario.builder()
                .email("usuario3@example.com")
                .nombre("Usuario Prueba3")
                .fechaRegistro(new java.sql.Date(System.currentTimeMillis()))
                .build();

        // Insertar usuarios
        usuarioService.insertarUsuario(usuario);
        usuarioService.insertarUsuario(usuario3);

        System.out.print("Usuario insertado correctamente -> ");
        System.out.println(usuarioService.obtenerUsuarioPorId(usuario.getId()).toString());

        // Actualizar usuario
        usuarioService.actualizarUsuario(usuario.getId(), usuario2);

        System.out.print("Usuario actualizado correctamente -> ");
        System.out.println(usuarioService.obtenerUsuarioPorId(usuario.getId()).toString());

        // Eliminar usuario
        System.out.println("Usuario eliminado correctamente");
        usuarioService.eliminarUsuario(usuario.getId());

        // Obtener lista de usuarios
        System.out.println("Lista de todos los usuarios añadidos:");
        for (Usuario u : usuarioService.obtenerTodosLosUsuarios()) {
            System.out.println(u.toString());
        }

        // Al cerrarse la alplicacion se liberan los recursos del usuario service
        // se cierra el EntityManagerFactory que quedaba abierto
        Runtime.getRuntime().addShutdownHook(new Thread(usuarioService::cerrarEntityManagerFactory));
    }
}