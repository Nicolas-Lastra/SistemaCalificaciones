package cl.edutecno.SistemaCalificaciones.services;

import cl.edutecno.SistemaCalificaciones.dto.MateriaCreateDto;
import cl.edutecno.SistemaCalificaciones.dto.MateriaResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MateriaService {

    Page<MateriaResponseDto> findAll(Pageable pageable);
    void saveMateria(MateriaCreateDto materiaCreateDto);
}
