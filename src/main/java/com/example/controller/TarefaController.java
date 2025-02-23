package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.datasource.model.Tarefa;
import com.example.exceptions.TarefaCouldNotCreateException;
import com.example.exceptions.TarefaNotFoundException;
import com.example.resource.model.TarefaResource;
import com.example.services.BuscarTarefaPorIdServiceImpl;
import com.example.services.BuscarTodasTarefasServiceImpl;
import com.example.services.CadastrarTarefaServiceImpl;

@RestController
@RequestMapping("/api")//caminho inicial da api
@CrossOrigin(origins = "http://localhost:4200")
public class TarefaController {
	
	@Autowired
	private BuscarTodasTarefasServiceImpl buscarTodasTarefas;
	
	@Autowired
	private BuscarTarefaPorIdServiceImpl buscarTarefaIdServiceImpl;
	
	@Autowired
	private CadastrarTarefaServiceImpl cadastrarTarefaServiceImpl;
	
	@GetMapping("/pegarTarefa")//caminho da api
	  public List<Tarefa> getTarefa() {
	    return buscarTodasTarefas.getTodasTarefas();
	  }
	
	@GetMapping("/pegarTarefa/{id}")//caminho da api
	  public Tarefa getTarefaId(@PathVariable(name = "id", required = true) Long id) throws TarefaNotFoundException {
	    return buscarTarefaIdServiceImpl.buscarPorId(id);
	  }
	
	@PostMapping(path = "/guardarTarefa/save")
	  public void salvarTarefa(@RequestBody TarefaResource tarefa) {
		try {
		  cadastrarTarefaServiceImpl.cadastro(tarefa);
		}catch (Exception e) {
			throw new TarefaCouldNotCreateException(e.getMessage());
		}
		
	  }
	
	@PatchMapping(path = "/guardarTarefa/save/{id}")
	  public void updateTarefa(@RequestBody TarefaResource tarefa, @PathVariable(name = "id", required = true) Long id) {
		cadastrarTarefaServiceImpl.cadastro(tarefa, id);
	 }
	
	@DeleteMapping(path = "/tarefa/delete/{id}")
	  public void deleteTarefa(@PathVariable(name = "id", required = true) Long id)
	      throws TarefaNotFoundException {
		buscarTarefaIdServiceImpl.deletarPorId(id);
	  }

}
