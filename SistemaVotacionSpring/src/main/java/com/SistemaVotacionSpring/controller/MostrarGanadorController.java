package com.SistemaVotacionSpring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.SistemaVotacionSpring.entity.Ganador;
import com.SistemaVotacionSpring.entity.PartidoPolitico;
import com.SistemaVotacionSpring.repository.GanadorRepository;
import com.SistemaVotacionSpring.repository.PartidoPoliticoRepository;
import com.SistemaVotacionSpring.repository.VotoRepository;

@Controller
@RequestMapping("/ganador")
public class MostrarGanadorController {

    @Autowired
    private GanadorRepository ganadorRepository;

    @GetMapping
    public String mostrarGanador(Model model) {
        List<Ganador> ganadores = ganadorRepository.findAll();

        if (ganadores.isEmpty()) {
            model.addAttribute("error", "Aún no hay ganadores registrados");
            model.addAttribute("mostrarBoton", false); // No mostrar el botón
        } else {
            model.addAttribute("ganadores", ganadores);
            model.addAttribute("mostrarBoton", true); // Mostrar el botón
        }

        return "index"; // Devolver la vista index.html
    }
}