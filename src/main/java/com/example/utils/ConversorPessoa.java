package com.example.utils;

import org.springframework.stereotype.Component;


import com.example.datasource.model.Pessoa;
import com.example.exceptions.PessoaResourceException;
import com.example.resource.model.PessoaResource;
import com.example.services.BuscarPessoaPorIdServiceImpl;
import com.example.services.BuscarPessoaPorNomeServiceImpl;
@Component
public class ConversorPessoa {
	
	private BuscarPessoaPorNomeServiceImpl svcPessoaNome;
	
	public Pessoa conversor (PessoaResource resource, Long id) throws PessoaResourceException {
		try {
			Pessoa pessoa = new Pessoa();
			//Long id = resource.getId() != null ? resource.getId() : svcPessoaNome.buscarPorId(resource.getNome()).getId();
			pessoa.setId(id);
			pessoa.setNome(resource.getNome());
			pessoa.setIdade(resource.getIdade());
			return pessoa;
		}catch (Exception e) {
			throw new PessoaResourceException("Falha ao converter o resource para entidade, resouce:"+ resource +" - "+e.getMessage());
		}
	}
	
	public Pessoa conversor (PessoaResource resource) throws PessoaResourceException {
		try {
			Pessoa pessoa = new Pessoa();
			//Long id = resource.getId() != null ? resource.getId() : svcPessoaNome.buscarPorId(resource.getNome()).getId();
			//pessoa.setId(id);
			pessoa.setNome(resource.getNome());
			pessoa.setIdade(resource.getIdade());
			return pessoa;
		}catch (Exception e) {
			throw new PessoaResourceException("Falha ao converter o resource para entidade, resouce:"+ resource+" - "+e.getMessage());
		}
	}

}
