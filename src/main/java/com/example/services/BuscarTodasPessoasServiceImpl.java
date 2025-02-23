package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.datasource.model.Pessoa;
import com.example.repository.PessoaRepository;

@Service
public class BuscarTodasPessoasServiceImpl {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public List<Pessoa> buscarTodasPessoas(){
		List<Pessoa> listaPessoas = pessoaRepository.findAll();
		return listaPessoas;
	}

}
