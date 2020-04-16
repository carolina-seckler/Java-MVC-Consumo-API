package br.edu.infnet.vendamvc.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.edu.infnet.vendamvc.model.negocio.Tecido;

@Service
public class TecidoService {
	
	@Autowired
	private RestTemplate rest;
	
	@SuppressWarnings("unchecked")
	public List<Tecido> obterLista() {
		return (List<Tecido>)rest.getForObject("http://localhost:8080/api/tecido", List.class);
	}
	
	@SuppressWarnings("unchecked")
	public Optional<Tecido> obterPorId(Integer id) {
		return rest.getForEntity("http://localhost:8080/api/tecido" + "/"+ id, Optional.class).getBody();
	}
	
	public void incluir (Tecido tecido) {
		rest.postForEntity("http://localhost:8080/api/tecido", tecido, String.class);
	}
	
	public void excluir (Integer id) {
		rest.delete("http://localhost:8080/api/tecido/{id}", id);
	}
	
//	public List<Tecido> obterDisponiveis() {
//		return (List<Tecido>) repository.findAvailable();
//	}
	
	public RestTemplate getRest() {
		return rest;
	}

	public void setRest(RestTemplate rest) {
		this.rest = rest;
	}
}
