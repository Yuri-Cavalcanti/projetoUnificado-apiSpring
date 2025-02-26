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
		Tarefa tarefa = tarefaRepository.findById(id).orElseThrow(() -> new TarefaNotFoundException("Tarefa nao encontrado atraves do ID: " + id));
		return tarefa;
	}
	
	public void deletarPorId(Long id) throws TarefaNotFoundException {
		Tarefa tarefa = tarefaRepository.findById(id).orElseThrow(() -> new TarefaNotFoundException("Tarefa nao encontrado atraves do ID: " + id));
		tarefaRepository.delete(tarefa);
	}

}
