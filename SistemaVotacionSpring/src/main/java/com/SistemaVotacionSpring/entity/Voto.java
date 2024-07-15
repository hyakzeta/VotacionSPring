package com.SistemaVotacionSpring.entity;

import javax.persistence.*;

@Entity
@Table(name = "Voto")
public class Voto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    
    @ManyToOne
    @JoinColumn(name="codigoAlumno", nullable=false)
    private Alumno alumno;
    
    @ManyToOne
    @JoinColumn(name="codigoPartidoPolitico", nullable=false)
    private PartidoPolitico partidoPolitico;

    // Getters y setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public PartidoPolitico getPartidoPolitico() {
        return partidoPolitico;
    }

    public void setPartidoPolitico(PartidoPolitico partidoPolitico) {
        this.partidoPolitico = partidoPolitico;
    }
}
