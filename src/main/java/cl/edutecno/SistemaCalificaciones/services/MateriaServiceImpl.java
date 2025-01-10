package cl.edutecno.SistemaCalificaciones.services;

import cl.edutecno.SistemaCalificaciones.dto.MateriaCreateDto;
import cl.edutecno.SistemaCalificaciones.dto.MateriaResponseDto;
import cl.edutecno.SistemaCalificaciones.mapper.MateriaMapper;
import cl.edutecno.SistemaCalificaciones.model.Alumno;
import cl.edutecno.SistemaCalificaciones.model.Materia;
import cl.edutecno.SistemaCalificaciones.repository.AlumnoRepository;
import cl.edutecno.SistemaCalificaciones.repository.MateriaRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log4j2
public class MateriaServiceImpl implements MateriaService{

    @Autowired
    private MateriaRepository materiaRepository;

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Override
    public Page<MateriaResponseDto> findAll(Pageable pageable) {

        Page<Materia> materias = materiaRepository.findAll(pageable);
        log.info(materias.getTotalElements() + "materias encontradas");

        Page<MateriaResponseDto> response = materias.map(MateriaMapper::toDto);
        log.info(response.getTotalElements() + " materias en respuesta");

        return response;
    }

    @Override
    public void saveMateria(MateriaCreateDto materiaCreateDto) {

        Materia materia = MateriaMapper.toMateria(materiaCreateDto);
        Optional<Alumno> alumno = alumnoRepository.findById(materiaCreateDto.getAlumno());

        if(alumno.isPresent()){
            materia.setAlumno(alumno.get());
        }

        materiaRepository.save(materia);

    }
}
