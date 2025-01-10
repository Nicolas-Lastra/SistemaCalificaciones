package cl.edutecno.SistemaCalificaciones.dto;

import lombok.*;

import java.util.Set;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AlumnoResponseDto {

    private Long id;
    private String rut;
    private String nombre;
    private String direccion;
    private Set<String> materias;

}
