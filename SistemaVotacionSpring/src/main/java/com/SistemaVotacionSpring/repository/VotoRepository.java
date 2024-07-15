package com.SistemaVotacionSpring.repository;

import com.SistemaVotacionSpring.entity.PartidoPolitico;
import com.SistemaVotacionSpring.entity.Voto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface VotoRepository extends JpaRepository<Voto, Integer> {
	
	@Query("SELECT COUNT(v) FROM Voto v WHERE v.partidoPolitico = :partidoPolitico")
    int countByPartidoPolitico(@Param("partidoPolitico") PartidoPolitico partidoPolitico);
	
    boolean existsByAlumnoCodigo(int codigoAlumno);
}
