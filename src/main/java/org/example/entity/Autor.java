package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

// Entidad Autor
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Autor {
    @Id
    @GeneratedValue
    private Long id;
    private String nombre;
    private String nacionalidad;

    @ManyToMany
    @JoinTable(name = "autor_libro",
            joinColumns = @JoinColumn(name = "autor_id"),
            inverseJoinColumns = @JoinColumn(name = "libro_id"))
    private List<Libro> libros;

    // Getters y Setters
}
