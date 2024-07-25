package com.example.demo.domain.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Cidade {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	private boolean ativo;
	
	private boolean aberto;
	
	@Column(name = "data_cadastro")
	private Date dataCadastro;
	
	@Column(name = "data_atualizacao")
	private Date dataAtualizacao;

}
