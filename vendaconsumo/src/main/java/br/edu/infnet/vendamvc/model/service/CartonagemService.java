package br.edu.infnet.vendamvc.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.edu.infnet.vendamvc.model.negocio.Cartonagem;

@Service
public class CartonagemService {

	@Autowired
	private RestTemplate rest;
	
	@SuppressWarnings("unchecked")
	public List<Cartonagem> obterLista() {
		return (List<Cartonagem>)rest.getForObject("http://localhost:8080/api/cartonagem", List.class);
	}
	
	@SuppressWarnings("unchecked")
	public Optional<Cartonagem> obterPorId(Integer id) {
		return rest.getForEntity("http://localhost:8080/api/cartonagem" + "/"+ id, Optional.class).getBody();
	}
	
	public void incluir (Cartonagem cartonagem) {
		rest.postForEntity("http://localhost:8080/api/cartonagem", cartonagem, String.class);
	}
	
	public void excluir (Integer id) {
		rest.delete("http://localhost:8080/api/cartonagem/{id}", id);
	}
	
	public RestTemplate getRest() {
		return rest;
	}

	public void setRest(RestTemplate rest) {
		this.rest = rest;
	}
}
