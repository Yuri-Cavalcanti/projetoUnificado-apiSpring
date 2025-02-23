package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.datasource.model.Tarefa;
import com.example.repository.TarefaRepository;

@Service
public class BuscarTodasTarefasServiceImpl {
	
	@Autowired
	private TarefaRepository tarefaRepository;
	
	
	public List<Tarefa> getTodasTarefas() {
		List<Tarefa> tarefas = this.tarefaRepository.findAll();
		return tarefas;
	}
}
