package cl.edutecno.SistemaCalificaciones.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "alumnos",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_alumnos_rut",
                        columnNames = {"rut"}
                )
        })
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "rut", nullable = false, length = 50)
    private String rut;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "direccion", nullable = false, length = 50)
    private String direccion;

    @OneToMany(
            mappedBy = "alumno",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonIgnore//Evita recursividad al realizar operaciones GET
    private Set<Materia> materias = new HashSet<>();

}
