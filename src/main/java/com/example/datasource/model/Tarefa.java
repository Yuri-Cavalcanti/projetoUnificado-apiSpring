package com.example.datasource.model;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "tarefa")
public class Tarefa implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5929742997521458691L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Autowired
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idpessoa", referencedColumnName = "id")
	private Pessoa pessoa;	
	
	private String descricao;
	
	public Tarefa() {
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	
	

}
