package com.example.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.datasource.model.Tarefa;
import com.example.exceptions.TarefaNotFoundException;
import com.example.repository.TarefaRepository;

@Service
public class BuscarTarefaPorIdServiceImpl {
	
	@Autowired
	private TarefaRepository tarefaRepository;
	
	
	public Tarefa buscarPorId(Long id) throws TarefaNotFoundException {
		Optional<Tarefa> optionalTarefa = getOptional(id);
		Tarefa tarefa = null;
		if (!optionalTarefa.isPresent()) {
			throw new TarefaNotFoundException("Tarefa nao encontrado atraves do ID: " + id);
		} else {
			tarefa = optionalTarefa.get();
		}
		return tarefa;
	}

	private Optional<Tarefa> getOptional(Long id) {
		Optional<Tarefa> optionalTarefa = tarefaRepository.findById(id);
		return optionalTarefa;
	}
	
	public void deletarPorId(Long id) throws TarefaNotFoundException {
		Optional<Tarefa> optionalTarefa = getOptional(id);
		if (!optionalTarefa.isPresent()) {
			throw new TarefaNotFoundException("Tarefa nao encontrado atraves do ID: " + id);
		} else {
			tarefaRepository.delete(optionalTarefa.get());
		}

	}

}
