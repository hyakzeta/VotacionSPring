package com.SistemaVotacionSpring.entity;

import javax.persistence.*;

@Entity
@Table(name = "PartidoPolitico")
public class PartidoPolitico {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo") 
    private int codigo;
    
    @Column(nullable = false, length = 100)
    private String nombrePartido;
    
    @Column(nullable = false, length = 1)
    private char simbolo;

    // Getters y setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombrePartido() {
        return nombrePartido;
    }

    public void setNombrePartido(String nombrePartido) {
        this.nombrePartido = nombrePartido;
    }

    public char getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(char simbolo) {
        this.simbolo = simbolo;
    }
}
