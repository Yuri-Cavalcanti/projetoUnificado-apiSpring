package com.example.utils;

import org.springframework.stereotype.Component;

import com.example.datasource.model.Pessoa;
import com.example.datasource.model.Tarefa;
import com.example.exceptions.PessoaResourceException;
import com.example.exceptions.TarefaNotFoundException;
import com.example.resource.model.PessoaResource;
import com.example.resource.model.TarefaResource;

@Component
public class ConversorTarefa {
	
	
	public Tarefa conversor (TarefaResource resource) throws TarefaNotFoundException {
		try {
			Tarefa tarefa = new Tarefa();
			Pessoa pessoa = new Pessoa();
			pessoa.setId(resource.getId_pessoa());
			tarefa.setPessoa(pessoa);
			tarefa.setDescricao(resource.getDescricao());
			return tarefa;
		}catch (Exception e) {
			throw new TarefaNotFoundException("Falha ao converter o resource para entidade, resouce:"+ resource);
		}
	}
	
	public Tarefa conversor (TarefaResource resource, Long id) throws TarefaNotFoundException {
		try {
			Tarefa tarefa = new Tarefa();
			Pessoa pessoa = new Pessoa();
			pessoa.setId(resource.getId_pessoa());
			tarefa.setId(id);
			tarefa.setPessoa(pessoa);
			tarefa.setDescricao(resource.getDescricao());
			return tarefa;
		}catch (Exception e) {
			throw new TarefaNotFoundException("Falha ao converter o resource para entidade, resouce:"+ resource);
		}
	}

}
