package cl.edutecno.SistemaCalificaciones.controller;

import cl.edutecno.SistemaCalificaciones.dto.MateriaCreateDto;
import cl.edutecno.SistemaCalificaciones.dto.MateriaResponseDto;
import cl.edutecno.SistemaCalificaciones.services.MateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/materias")
public class MateriaController {

    @Autowired
    private MateriaService materiaService;

    @GetMapping
    public ResponseEntity<Page<MateriaResponseDto>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return ResponseEntity.ok(materiaService.findAll(pageRequest));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<MateriaCreateDto> crearMateria(@RequestBody MateriaCreateDto materiaDto) {
        materiaService.saveMateria(materiaDto);
        return ResponseEntity.ok().body(materiaDto);
    }
}
