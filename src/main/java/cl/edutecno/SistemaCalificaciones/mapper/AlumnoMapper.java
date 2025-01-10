package cl.edutecno.SistemaCalificaciones.mapper;

import cl.edutecno.SistemaCalificaciones.dto.AlumnoCreateDto;
import cl.edutecno.SistemaCalificaciones.dto.AlumnoResponseDto;
import cl.edutecno.SistemaCalificaciones.model.Alumno;
import cl.edutecno.SistemaCalificaciones.model.Materia;

import java.util.stream.Collectors;

public class AlumnoMapper {

    // Convertir Alumno a AlumnoResponseDto
    public static AlumnoResponseDto toDto(Alumno alumno) {

        if (alumno == null) {
            return null;
        }

        return AlumnoResponseDto.builder()
                .id(alumno.getId())
                .rut(alumno.getRut())
                .nombre(alumno.getNombre())
                .direccion(alumno.getDireccion())
                .materias(alumno.getMaterias() != null ?
                        alumno.getMaterias().stream()
                                .map(Materia::getNombre)
                                .collect(Collectors.toSet()) : null)
                .build();
    }

    // Convertir AlumnoCreateDto  a Alumno
    public static Alumno toAlumno(AlumnoCreateDto alumnoCreateDto) {

        if (alumnoCreateDto == null) {
            return null;
        }

        Alumno alumno = new Alumno();
        alumno.setRut(alumnoCreateDto.getRut());
        alumno.setNombre(alumnoCreateDto.getNombre());
        alumno.setDireccion(alumnoCreateDto.getDireccion());

        return alumno;
    }

}
