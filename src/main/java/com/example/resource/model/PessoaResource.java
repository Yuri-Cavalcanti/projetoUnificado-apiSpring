package com.example.resource.model;

import java.io.Serializable;

import com.example.datasource.model.Pessoa;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PessoaResource implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -988874050979310234L;
	
	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("nome")
	private String nome;
	
	@JsonProperty("idade")
	private int idade;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

}
