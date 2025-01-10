package cl.edutecno.SistemaCalificaciones.services;

import cl.edutecno.SistemaCalificaciones.dto.AlumnoCreateDto;
import cl.edutecno.SistemaCalificaciones.dto.AlumnoResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AlumnoService {

    Page<AlumnoResponseDto> findAll(Pageable pageable);
    void saveAlumno(AlumnoCreateDto alumnoCreateDto);
    AlumnoResponseDto findById(Long id);

}
