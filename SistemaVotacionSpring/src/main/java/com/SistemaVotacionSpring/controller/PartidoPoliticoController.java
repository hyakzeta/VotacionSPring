package com.SistemaVotacionSpring.controller;

import com.SistemaVotacionSpring.entity.Alumno;
import com.SistemaVotacionSpring.entity.PartidoPolitico;
import com.SistemaVotacionSpring.repository.AlumnoRepository;
import com.SistemaVotacionSpring.repository.PartidoPoliticoRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PartidoPoliticoController {

    @Autowired
    private PartidoPoliticoRepository partidoPoliticoRepository;
    
    @Autowired
    private AlumnoRepository alumnoRepository;
    
    @GetMapping("/registrarVoto/{codigoUsuario}")
    public String cargarPartidos(@PathVariable int codigoUsuario, Model model) {
        
        Alumno alumno = alumnoRepository.findByUsuarioCodigo(codigoUsuario);
        
        if (alumno != null) {
            List<PartidoPolitico> partidos = partidoPoliticoRepository.findAll();
            model.addAttribute("partidos", partidos);
            model.addAttribute("alumno", alumno);
            return "registrarVoto";
        } else {
            return "error"; 
        }
    }
}




