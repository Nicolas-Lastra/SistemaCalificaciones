package cl.edutecno.SistemaCalificaciones.mapper;

import cl.edutecno.SistemaCalificaciones.dto.MateriaCreateDto;
import cl.edutecno.SistemaCalificaciones.dto.MateriaResponseDto;
import cl.edutecno.SistemaCalificaciones.model.Materia;

public class MateriaMapper {

    // Convertir Materia a MateriaResponseDto
    public static MateriaResponseDto toDto(Materia materia) {

        if (materia == null) {
            return null;
        }

        return MateriaResponseDto.builder()
                .id(materia.getId())
                .nombre(materia.getNombre())
                .alumno(materia.getAlumno())
                .build();
    }

    // Convertir MateriaCreateDto a Materia
    public static Materia toMateria(MateriaCreateDto materiaCreateDto) {
        if (materiaCreateDto == null || materiaCreateDto.getAlumno() == null) {
            return null;
        }

        Materia materia = new Materia();
        materia.setNombre(materiaCreateDto.getNombre());
        return materia;
    }

}
