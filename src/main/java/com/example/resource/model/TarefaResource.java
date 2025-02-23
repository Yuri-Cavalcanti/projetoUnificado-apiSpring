package com.example.resource.model;

import java.io.Serializable;

import com.example.datasource.model.Pessoa;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TarefaResource implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9056620377273024407L;
	
      @JsonProperty("id")
      private Long id;
	
	  @JsonProperty("id_pessoa")
	  private Long idpessoa;

	  @JsonProperty("descricao")
	  private String descricao;

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId_pessoa() {
		return idpessoa;
	}

	public void setId_pessoa(Long id_pessoa) {
		this.idpessoa = id_pessoa;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


}
