package com.example.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.datasource.model.Pessoa;
import com.example.exceptions.PessoaNotFoundException;
import com.example.repository.PessoaRepository;

@Service
public class BuscarPessoaPorIdServiceImpl {

	@Autowired
	private PessoaRepository pessoaRepository;

	public Pessoa buscarPorId(Long id) throws PessoaNotFoundException {
		Pessoa pessoa = pessoaRepository.findById(id).orElseThrow(() -> new PessoaNotFoundException("Pessoa nao encontrado atraves do ID: " + id));
		return pessoa;
	}

	private Optional<Pessoa> getOptional(Long id) {
		Optional<Pessoa> optionalPessoa = pessoaRepository.findById(id);
		return optionalPessoa;
	}

	public void deletarPorId(Long id) throws PessoaNotFoundException {
		Pessoa pessoa = pessoaRepository.findById(id).orElseThrow(() -> new PessoaNotFoundException("Pessoa nao encontrado atraves do ID: " + id));
		pessoaRepository.delete(pessoa);
	}

}
