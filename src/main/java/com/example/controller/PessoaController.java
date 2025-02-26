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

import com.example.datasource.model.Pessoa;
import com.example.exceptions.PessoaCouldNotCreateException;
import com.example.exceptions.PessoaNotFoundException;
import com.example.exceptions.TarefaNotFoundException;
import com.example.resource.model.PessoaResource;
import com.example.services.BuscarPessoaPorIdServiceImpl;
import com.example.services.BuscarTodasPessoasServiceImpl;
import com.example.services.CadastrarPessoaServiceImpl;

@RestController
@RequestMapping("/api")//caminho inicial da api
@CrossOrigin(origins = "http://localhost:4200")
public class PessoaController {
	
	@Autowired
	private BuscarTodasPessoasServiceImpl buscarTodasPessoasServiceImpl;
	
	@Autowired
	private BuscarPessoaPorIdServiceImpl buscarPessoaPorIdServiceImpl;
	
	@Autowired
	private CadastrarPessoaServiceImpl cadastrarPessoaServiceImpl;
	
	@GetMapping("/pegarPessoa")//caminho da api
	  public List<Pessoa> getPessoa() {
	    return buscarTodasPessoasServiceImpl.buscarTodasPessoas();
	  }
	
	@GetMapping("/pegarPessoa/{id}")//caminho da api
	  public Pessoa getPessoaId(@PathVariable(name = "id", required = true) Long id) throws PessoaNotFoundException {
	    return buscarPessoaPorIdServiceImpl.buscarPorId(id);
	  }
	
	@PostMapping(path = "/guardarPessoa/save")
	  public void salvarTarefa(@RequestBody PessoaResource pessoa) throws PessoaCouldNotCreateException {
		cadastrarPessoaServiceImpl.cadastro(pessoa);
	  }
	
	@PatchMapping(path = "/guardarPessoa/save/{id}")
	  public void updateTarefa(@RequestBody PessoaResource pessoa, @PathVariable(name = "id", required = true) Long id) throws PessoaCouldNotCreateException {
		cadastrarPessoaServiceImpl.cadastro(pessoa, id);
	 }
	
	@DeleteMapping(path = "/pessoa/delete/{id}")
	  public void deleteTarefa(@PathVariable(name = "id", required = true) Long id)
	      throws TarefaNotFoundException, PessoaNotFoundException {
		buscarPessoaPorIdServiceImpl.deletarPorId(id);
	  }

}
