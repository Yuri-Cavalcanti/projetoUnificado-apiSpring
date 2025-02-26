package com.example.utils;

import org.springframework.stereotype.Component;

import com.example.datasource.model.Pessoa;
import com.example.datasource.model.Tarefa;
import com.example.exceptions.TarefaNotFoundException;
import com.example.exceptions.TarefaResourceException;
import com.example.resource.model.TarefaResource;

@Component
public class ConversorTarefa {
	
	
	public Tarefa conversor (TarefaResource resource) throws TarefaResourceException {
		try {
			Tarefa tarefa = new Tarefa();
			Pessoa pessoa = new Pessoa();
			pessoa.setId(resource.getId_pessoa());
			tarefa.setPessoa(pessoa);
			tarefa.setDescricao(resource.getDescricao());
			return tarefa;
		}catch (Exception e) {
			throw new TarefaResourceException("Falha ao converter o resource para entidade, resouce:"+ resource+" - "+e.getMessage());
		}
	}
	
	public Tarefa conversor (TarefaResource resource, Long id) throws TarefaResourceException {
		try {
			Tarefa tarefa = new Tarefa();
			Pessoa pessoa = new Pessoa();
			pessoa.setId(resource.getId_pessoa());
			tarefa.setId(id);
			tarefa.setPessoa(pessoa);
			tarefa.setDescricao(resource.getDescricao());
			return tarefa;
		}catch (Exception e) {
			throw new TarefaResourceException("Falha ao converter o resource para entidade, resouce:"+ resource+" - "+e.getMessage());
		}
	}

}
