package com.SistemaVotacionSpring.controller;

import com.SistemaVotacionSpring.entity.Alumno;
import com.SistemaVotacionSpring.entity.Ganador;
import com.SistemaVotacionSpring.entity.PartidoPolitico;
import com.SistemaVotacionSpring.entity.Voto;
import com.SistemaVotacionSpring.repository.AlumnoRepository;
import com.SistemaVotacionSpring.repository.GanadorRepository;
import com.SistemaVotacionSpring.repository.PartidoPoliticoRepository;
import com.SistemaVotacionSpring.repository.VotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class VotoController {

    @Autowired
    private VotoRepository votoRepository;

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Autowired
    private PartidoPoliticoRepository partidoPoliticoRepository;

    @Autowired
    private GanadorRepository ganadorRepository;

    @PostMapping("/registrarVoto")
    public String registrarVoto(@RequestParam("codigoUsuario") int codigoUsuario,
                                @RequestParam("codigoPartido") int codigoPartido,
                                Model model) {

        Alumno alumno = alumnoRepository.findByUsuarioCodigo(codigoUsuario);

        if (alumno == null) {
            model.addAttribute("error", "El usuario no tiene un alumno asociado");
            return "registrarVoto";
        }

        if (votoRepository.existsByAlumnoCodigo(alumno.getCodigo())) {
            model.addAttribute("error", "El alumno ya ha votado");
            return "index";
        }

        PartidoPolitico partidoPolitico = partidoPoliticoRepository.findByCodigo(codigoPartido);

        // Registrar el voto
        Voto voto = new Voto();
        voto.setAlumno(alumno);
        voto.setPartidoPolitico(partidoPolitico);
        votoRepository.save(voto);
 
        actualizarGanador(partidoPolitico);

        model.addAttribute("mensaje", "Voto registrado exitosamente");
        return "index";
    }

    private void actualizarGanador(PartidoPolitico partidoPolitico) {
        Ganador ganador = ganadorRepository.findByPartidoPolitico(partidoPolitico);

        if (ganador == null) {
            int cantidadVotos = votoRepository.countByPartidoPolitico(partidoPolitico);

            if (cantidadVotos >= 3) {
                ganador = new Ganador();
                ganador.setPartidoPolitico(partidoPolitico);
                ganador.setCantidadVotos(cantidadVotos);
                ganadorRepository.save(ganador);
            }
        } else {
        }
    }
}


