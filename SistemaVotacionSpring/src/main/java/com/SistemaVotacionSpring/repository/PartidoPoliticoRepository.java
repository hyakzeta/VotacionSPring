package com.SistemaVotacionSpring.repository;

import com.SistemaVotacionSpring.entity.PartidoPolitico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartidoPoliticoRepository extends JpaRepository<PartidoPolitico, Integer> {
	
	PartidoPolitico findByCodigo(int codigo);
}
