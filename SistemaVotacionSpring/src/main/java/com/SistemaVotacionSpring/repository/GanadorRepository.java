package com.SistemaVotacionSpring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.SistemaVotacionSpring.entity.Ganador;
import com.SistemaVotacionSpring.entity.PartidoPolitico;

public interface GanadorRepository extends JpaRepository<Ganador, Integer> {

    List<Ganador> findAll();

    // Método para encontrar el ganador por partido político
    Ganador findByPartidoPolitico(PartidoPolitico partidoPolitico);
    
}