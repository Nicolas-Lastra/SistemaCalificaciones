package cl.edutecno.SistemaCalificaciones.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString(exclude = "alumno")
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "materias")
public class Materia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @ManyToOne
    @JoinColumn(
            name = "alumno_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_materia_alumno")
    )
    private Alumno alumno;

}
