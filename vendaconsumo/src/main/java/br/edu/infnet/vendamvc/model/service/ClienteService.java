package br.edu.infnet.vendamvc.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.edu.infnet.vendamvc.model.negocio.Cliente;

@Service
public class ClienteService {

	@Autowired
	private RestTemplate rest;
	
	@SuppressWarnings("unchecked")
	public List<Cliente> obterLista() {
		return (List<Cliente>)rest.getForObject("http://localhost:8080/api/cliente", List.class);
	}
	
	@SuppressWarnings("unchecked")
	public Optional<Cliente> obterPorId(Integer id) {
		return rest.getForEntity("http://localhost:8080/api/cliente" + "/"+ id, Optional.class).getBody();
	}
	
	public void incluir (Cliente cliente) {
		//ResponseEntity<String> r = rest.postForEntity("http://localhost:8080/api/cliente", cliente, String.class);
		rest.postForEntity("http://localhost:8080/api/cliente", cliente, String.class);
	}
	
	public void excluir (Integer id) {
		rest.delete("http://localhost:8080/api/cliente/{id}", id);
	}

	public RestTemplate getRest() {
		return rest;
	}

	public void setRest(RestTemplate rest) {
		this.rest = rest;
	}
	
}
