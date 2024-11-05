package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Representa la entidad Libro.
 * Esta clase se utiliza para almacenar la información de los libros, su género,
 * fecha de publicación y las relaciones con autores y préstamos.
 * <p>
 * La relación con los autores es de muchos a muchos, y la relación con los préstamos es de uno a muchos.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Libro {

    /**
     * Identificador único del libro autogenerado.
     * Este campo se utiliza como clave primaria en la base de datos.
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * Título del libro.
     * Representa el nombre del libro en la base de datos.
     */
    private String titulo;

    /**
     * Género del libro.
     * Representa el género literario al que pertenece el libro.
     */
    private String genero;

    /**
     * Fecha de publicación del libro.
     * Representa la fecha en que el libro fue publicado.
     */
    @Temporal(TemporalType.DATE)
    private Date fechaPublicacion;

    /**
     * Relación muchos a muchos entre Libro y Autor.
     * Un libro puede estar relacionado con muchos autores y un autor puede haber escrito varios libros.
     * La relación se gestiona a través de la propiedad "libros" de la entidad Autor.
     * <p>
     * La anotación "mappedBy" indica que la entidad Autor es la dueña de la relación.
     */
    @ManyToMany(mappedBy = "libros")
    private List<Autor> autores;

    /**
     * Relación uno a muchos entre Libro y Prestamo.
     * Un libro puede ser prestado varias veces, por lo que un libro puede tener múltiples préstamos asociados.
     * La relación se mapea a través de la propiedad "libro" en la entidad Prestamo.
     */
    @OneToMany(mappedBy = "libro")
    private List<Prestamo> prestamos;
}
