package cl.edutecno.SistemaCalificaciones.services;

import cl.edutecno.SistemaCalificaciones.dto.AlumnoCreateDto;
import cl.edutecno.SistemaCalificaciones.dto.AlumnoResponseDto;
import cl.edutecno.SistemaCalificaciones.mapper.AlumnoMapper;
import cl.edutecno.SistemaCalificaciones.model.Alumno;
import cl.edutecno.SistemaCalificaciones.repository.AlumnoRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class AlumnoServiceImpl implements AlumnoService{

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Override
    public Page<AlumnoResponseDto> findAll(Pageable pageable) {

        Page<Alumno> alumnos = alumnoRepository.findAll(pageable);
        log.info(alumnos.getTotalElements() + " alumnos encontrados en la base de datos");

        Page<AlumnoResponseDto> response = alumnos.map(AlumnoMapper::toDto);
        log.info(response.getTotalElements() + " alumnos en respuesta");

        return response;
    }

    @Override
    public void saveAlumno(AlumnoCreateDto alumnoCreateDto) {

        log.info("Guardando un nuevo alumno: " + alumnoCreateDto.getNombre());

        if(alumnoCreateDto != null){

            Alumno alumno = AlumnoMapper.toAlumno(alumnoCreateDto);
            alumnoRepository.save(alumno);

        }

    }

    @Override
    public AlumnoResponseDto findById(Long id) {
        Alumno alumno = alumnoRepository.findById(id).orElseThrow(() -> new RuntimeException("No se encuentra el alumno con id: " + id));
        return AlumnoMapper.toDto(alumno);
    }
}
