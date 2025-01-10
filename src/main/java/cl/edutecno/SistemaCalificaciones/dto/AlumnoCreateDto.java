package cl.edutecno.SistemaCalificaciones.dto;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AlumnoCreateDto {

    private String rut;
    private String nombre;
    private String direccion;
    private Set<Long> materiasId;

}
