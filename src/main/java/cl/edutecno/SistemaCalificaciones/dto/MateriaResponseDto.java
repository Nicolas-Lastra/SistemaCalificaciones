package cl.edutecno.SistemaCalificaciones.dto;

import cl.edutecno.SistemaCalificaciones.model.Alumno;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MateriaResponseDto {

    private Long id;
    private String nombre;
    private Alumno alumno;

}
