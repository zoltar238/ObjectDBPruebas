package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * Representa la entidad Autor.
 * Esta clase se utiliza para almacenar la información de los autores y sus libros relacionados.
 * <p>
 * La relación con los libros es de muchos a muchos, donde un autor puede tener varios libros
 * y un libro puede tener varios autores.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Autor {

    /**
     * Identificador único del autor autogenerado.
     * Este campo se utiliza como clave primaria en la base de datos.
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * Nombre del autor.
     * Representa el nombre del autor en la base de datos.
     */
    private String nombre;

    /**
     * Nacionalidad del autor.
     * Representa la nacionalidad del autor en la base de datos.
     */
    private String nacionalidad;

    /**
     * Relación muchos a muchos entre Autor y Libro.
     * Un autor puede estar relacionado con muchos libros y viceversa.
     * Esta relación se gestiona a través de la tabla intermedia "autor_libro".
     */
    @ManyToMany
    @JoinTable(
            name = "autor_libro",
            joinColumns = @JoinColumn(name = "autor_id"),
            inverseJoinColumns = @JoinColumn(name = "libro_id")
    )
    private List<Libro> libros;
}
