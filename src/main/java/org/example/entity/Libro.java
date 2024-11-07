package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

// Entidad Libro
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Libro {
    @Id
    @GeneratedValue
    private Long id;
    private String titulo;
    private String genero;
    @Temporal(TemporalType.DATE)
    private Date fechaPublicacion;

    @ManyToMany(mappedBy = "libros")
    private List<Autor> autores;

    @OneToMany(mappedBy = "libro")
    private List<Prestamo> prestamos;

    // Getters y Setters
}

