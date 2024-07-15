package com.SistemaVotacionSpring.entity;

import javax.persistence.*;

@Entity
@Table(name = "Alumno")
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    
    @Column(nullable = false, length = 100)
    private String nombres;
    
    @Column(nullable = false, length = 100)
    private String apellidoPaterno;
    
    @Column(nullable = false, length = 100)
    private String apellidoMaterno;
    
    @OneToOne
    @JoinColumn(name="codigoUsuario", nullable=false)
    private Usuario usuario;

    // Getters y setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
