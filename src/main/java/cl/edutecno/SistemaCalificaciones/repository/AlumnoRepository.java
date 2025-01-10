package cl.edutecno.SistemaCalificaciones.repository;

import cl.edutecno.SistemaCalificaciones.model.Alumno;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {

    Page<Alumno> findAll(Pageable pageable);

}
