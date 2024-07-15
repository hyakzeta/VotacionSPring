package com.SistemaVotacionSpring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Ganador")
public class Ganador {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int codigo;

	    @ManyToOne
	    @JoinColumn(name = "codigoPartidoPolitico")
	    private PartidoPolitico partidoPolitico;
	    
	    @Column(nullable = false, length = 100)
	    private int cantidadVotos;
	    
	    public int getCodigo() {
	        return codigo;
	    }

	    public void setCodigo(int codigo) {
	        this.codigo = codigo;
	    }
	    
	    public PartidoPolitico getPartidoPolitico() {
	        return partidoPolitico;
	    }

	    public void setPartidoPolitico(PartidoPolitico partidoPolitico) {
	        this.partidoPolitico = partidoPolitico;
	    }
	    
		public int getCantidadVotos() {
			return cantidadVotos;
		}

		public void setCantidadVotos(int cantidadVotos) {
			this.cantidadVotos = cantidadVotos;
		}
	    
	   
	}

