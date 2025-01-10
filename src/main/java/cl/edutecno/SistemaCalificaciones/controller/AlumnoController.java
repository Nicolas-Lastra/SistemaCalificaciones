package cl.edutecno.SistemaCalificaciones.controller;

import cl.edutecno.SistemaCalificaciones.dto.AlumnoCreateDto;
import cl.edutecno.SistemaCalificaciones.dto.AlumnoResponseDto;
import cl.edutecno.SistemaCalificaciones.services.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/alumnos")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    @GetMapping
    public ResponseEntity<Page<AlumnoResponseDto>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {

        PageRequest pageRequest = PageRequest.of(page, size);
        return ResponseEntity.ok(alumnoService.findAll(pageRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlumnoResponseDto> findById(@PathVariable Long id) {
        AlumnoResponseDto alumno = alumnoService.findById(id);
        return ResponseEntity.ok(alumno);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<AlumnoResponseDto> save(@RequestBody AlumnoCreateDto alumnoCreateDto) {
        alumnoService.saveAlumno(alumnoCreateDto);
        return ResponseEntity.ok().build();
    }
}
