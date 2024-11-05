package org.example.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Representa la entidad Usuario.
 * Esta clase se utiliza para almacenar la información de los usuarios así como sus préstamos.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Usuario {
    /**
     * Identificador unico del Usuario autogenerado.
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * Nombre del usuario.
     */
    @NonNull
    private String nombre;

    /**
     * Email del usuario.
     */
    //@Unique
    @NonNull
    private String email;

    /**
     * La fecha de registro del usuario.
     */
    @Temporal(TemporalType.DATE)
    @NonNull
    private Date fechaRegistro;

    /**
     * La lista de prestamos del usuario.
     * Mapeada por una relación uno a muchos
     */
    @OneToMany(mappedBy = "usuario")
    private List<Prestamo> prestamos;
}
