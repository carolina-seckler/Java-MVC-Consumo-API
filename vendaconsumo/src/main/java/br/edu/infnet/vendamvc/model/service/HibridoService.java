package br.edu.infnet.vendamvc.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.edu.infnet.vendamvc.model.negocio.Hibrido;

@Service
public class HibridoService {

	@Autowired
	private RestTemplate rest;
	
	@SuppressWarnings("unchecked")
	public List<Hibrido> obterLista() {
		return (List<Hibrido>)rest.getForObject("http://localhost:8080/api/hibrido", List.class);
	}
	
	@SuppressWarnings("unchecked")
	public Optional<Hibrido> obterPorId(Integer id) {
		return rest.getForEntity("http://localhost:8080/api/hibrido" + "/"+ id, Optional.class).getBody();
	}
	
	public void incluir (Hibrido hibrido) {
		rest.postForEntity("http://localhost:8080/api/hibrido", hibrido, String.class);
	}
	
	public void excluir (Integer id) {
		rest.delete("http://localhost:8080/api/hibrido/{id}", id);
	}
	
//	public List<Hibrido> obterDisponiveis() {
//		return (List<Hibrido>) repository.findAvailable();
//	}
	
	public RestTemplate getRest() {
		return rest;
	}

	public void setRest(RestTemplate rest) {
		this.rest = rest;
	}
}
