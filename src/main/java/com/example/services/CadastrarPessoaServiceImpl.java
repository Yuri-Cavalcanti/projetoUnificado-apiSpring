package com.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.datasource.model.Pessoa;
import com.example.datasource.model.Tarefa;
import com.example.repository.PessoaRepository;
import com.example.resource.model.PessoaResource;
import com.example.resource.model.TarefaResource;
import com.example.utils.ConversorPessoa;

@Service
public class CadastrarPessoaServiceImpl {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private ConversorPessoa conversor;
	
	public void cadastro(PessoaResource resource) {
		try {
			Pessoa pessoa = conversor.conversor(resource);
			pessoaRepository.saveAndFlush(pessoa);
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void cadastro(PessoaResource resource, Long id) {
		try {
			Pessoa pessoa = conversor.conversor(resource, id);
			pessoaRepository.saveAndFlush(pessoa);
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

}
