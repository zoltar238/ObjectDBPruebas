package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * La entidad Prestamo representa un préstamo de un libro a un usuario en una biblioteca.
 * Esta entidad funciona como una tabla intermedia entre Usuario y Libro, y almacena
 * la fecha de inicio y la fecha de devolución del préstamo.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Prestamo {

    /**
     * Identificador único del préstamo.
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * Fecha en la que se realizó el préstamo.
     */
    @Temporal(TemporalType.DATE)
    private Date fechaPrestamo;

    /**
     * Fecha en la que se espera la devolución del libro.
     */
    @Temporal(TemporalType.DATE)
    private Date fechaDevolucion;

    /**
     * Usuario que realiza el préstamo. Representa una relación muchos-a-uno con la entidad Usuario,
     * donde cada préstamo está asociado a un usuario específico.
     */
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    /**
     * Libro que se presta al usuario. Representa una relación muchos-a-uno con la entidad Libro,
     * donde cada préstamo está asociado a un libro específico.
     */
    @ManyToOne
    @JoinColumn(name = "libro_id")
    private Libro libro;
}
