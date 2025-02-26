package com.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.datasource.model.Tarefa;
import com.example.exceptions.TarefaCouldNotCreateException;
import com.example.repository.TarefaRepository;
import com.example.resource.model.TarefaResource;
import com.example.utils.ConversorTarefa;

@Service
public class CadastrarTarefaServiceImpl {
	
	@Autowired
	private TarefaRepository tarefaRepository;
	
	@Autowired
	private ConversorTarefa conversor;
	
	public void cadastro(TarefaResource resource) throws TarefaCouldNotCreateException{
		try {
			Tarefa tarefa = conversor.conversor(resource);
			if(tarefa.getPessoa().getId() == null || tarefa.getDescricao() == null || tarefa.getDescricao().equals(""))
				throw new TarefaCouldNotCreateException("Falha ao criar tarefa - parametros incorretos id_pessoa {"+tarefa.getPessoa().getId()+"} descricao {"+tarefa.getDescricao()+"}");
			tarefaRepository.saveAndFlush(tarefa);
		}catch (Exception e) {
			throw new TarefaCouldNotCreateException("Falha ao criar tarefa" + e.getMessage());
		}
	}
	
	public void cadastro(TarefaResource resource, Long id) throws TarefaCouldNotCreateException {
		try {
			Tarefa tarefa = conversor.conversor(resource, id);
			if(id == null || tarefa.getDescricao() == null || tarefa.getDescricao().equals(""))
				throw new TarefaCouldNotCreateException("Falha ao atualizar tarefa - parametros incorretos id_pessoa {"+tarefa.getPessoa().getId()+"} descricao {"+tarefa.getDescricao()+"}");
			tarefaRepository.saveAndFlush(tarefa);
		}catch (Exception e) {
			throw new TarefaCouldNotCreateException("Falha ao atualizar tarefa" + e.getMessage());
		}
	}

}
