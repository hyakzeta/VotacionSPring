package com.SistemaVotacionSpring.controller;

import com.SistemaVotacionSpring.entity.Usuario;
import com.SistemaVotacionSpring.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/usuario")
public class LoginController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @RequestMapping(value="/validarUsuario", method=RequestMethod.POST)
    public String validarUsuario(HttpServletRequest request, @RequestParam(value="correo") String correo, @RequestParam(value="password") String password){
        Usuario objUsuario = usuarioRepository.findByCorreoAndPassword(correo, password);
        if (objUsuario != null) {
        	int codigoUsuario = objUsuario.getCodigo();
            return "redirect:/registrarVoto/" + codigoUsuario;
        } else {
            return "index";
        }
    }
}
