package cl.edutecno.SistemaCalificaciones.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MateriaCreateDto {

    private String nombre;
    private Long alumno;

}
