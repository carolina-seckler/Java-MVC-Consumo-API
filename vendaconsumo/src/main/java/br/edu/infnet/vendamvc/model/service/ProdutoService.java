package br.edu.infnet.vendamvc.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.edu.infnet.vendamvc.model.negocio.Produto;

@Service
public class ProdutoService {

	@Autowired
	private RestTemplate rest;
	
	@SuppressWarnings("unchecked")
	public List<Produto> obterDisponiveis() {
		return (List<Produto>)rest.getForObject("http://localhost:8080/api/produto", List.class);
	}
	
	@SuppressWarnings("unchecked")
	public Optional<Produto> obterPorId(Integer id) {
		return rest.getForEntity("http://localhost:8080/api/produto" + "/"+ id, Optional.class).getBody();
	}
	
	public void atualizar(Produto produto) {
		rest.postForEntity("http://localhost:8080/api/produto", produto, String.class);
	}
}
