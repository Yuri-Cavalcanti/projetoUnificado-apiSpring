package com.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.datasource.model.Pessoa;
import com.example.datasource.model.Tarefa;
import com.example.exceptions.PessoaCouldNotCreateException;
import com.example.exceptions.PessoaInvalidParametersException;
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
	
	public void cadastro(PessoaResource resource) throws PessoaCouldNotCreateException, PessoaInvalidParametersException {
		try {
			Pessoa pessoa = conversor.conversor(resource);
			if(pessoa.getNome() == null || pessoa.getNome().equals(""))
				throw new PessoaInvalidParametersException("Parametros invalidos para criacao nome{"+pessoa.getNome()+"} idade{"+pessoa.getIdade()+"}");
			if(pessoa.getIdade() < 12)
				throw new PessoaInvalidParametersException("Parametro idade invalido! menor que 12 - idade{"+pessoa.getIdade()+"}");
			pessoaRepository.saveAndFlush(pessoa);
		}catch (Exception e) {
			throw new PessoaCouldNotCreateException("Falha ao cadastrar pessoa: "+e.getMessage());
		}
	}
	
	public void cadastro(PessoaResource resource, Long id) throws PessoaCouldNotCreateException, PessoaInvalidParametersException {
		try {
			Pessoa pessoa = conversor.conversor(resource, id);
			if(pessoa.getNome() == null || pessoa.getNome().equals("") || pessoa.getIdade() < 12 || id == null)
				throw new PessoaInvalidParametersException("Parametros invalidos para atualizacao nome{"+pessoa.getNome()+"} idade{"+pessoa.getIdade()+"} ID {"+id+"}");
			pessoaRepository.saveAndFlush(pessoa);
		}catch (Exception e) {
			throw new PessoaCouldNotCreateException("Falha ao cadastrar pessoa: "+e.getMessage());
		}
	}

}
