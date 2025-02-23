package com.example.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.datasource.model.Pessoa;
import com.example.exceptions.PessoaNotFoundException;
import com.example.repository.PessoaRepository;

@Service
public class BuscarPessoaPorNomeServiceImpl {
	
	@Autowired
	private PessoaRepository pessoaRepository;

	public Pessoa buscarPorId(String nome) throws PessoaNotFoundException {
		Optional<Pessoa> optionalPessoa = getOptional(nome);
		Pessoa pessoa = null;
		if (!optionalPessoa.isPresent()) {
			throw new PessoaNotFoundException("Pessoa nao encontrado atraves do nome: " + nome);
		} else {
			pessoa = optionalPessoa.get();
		}
		return pessoa;
	}

	private Optional<Pessoa> getOptional(String nome) {
		Optional<Pessoa> optionalPessoa = Optional.of(pessoaRepository.findByNome(nome));
		return optionalPessoa;
	}

}
