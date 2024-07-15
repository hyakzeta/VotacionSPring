package com.SistemaVotacionSpring.repository;

import com.SistemaVotacionSpring.entity.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {
    Alumno findByUsuarioCodigo(int codigoUsuario);
    
}
