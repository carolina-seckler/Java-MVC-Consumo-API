package br.edu.infnet.vendamvc.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.edu.infnet.vendamvc.model.negocio.Venda;

@Service
public class VendaService {

	@Autowired
	private RestTemplate rest;
	
	@SuppressWarnings("unchecked")
	public List<Venda> obterLista() {
		return (List<Venda>)rest.getForObject("http://localhost:8080/api/venda", List.class);
	}
	
	@SuppressWarnings("unchecked")
	public Optional<Venda> obterPorId(Integer id) {
		return rest.getForEntity("http://localhost:8080/api/venda" + "/"+ id, Optional.class).getBody();
	}
	
	public void incluir (Venda venda) {
		rest.postForEntity("http://localhost:8080/api/venda", venda, String.class);
	}
	
	public void excluir (Integer id) {
		rest.delete("http://localhost:8080/api/venda/{id}", id);
	}
	
	public RestTemplate getRest() {
		return rest;
	}

	public void setRest(RestTemplate rest) {
		this.rest = rest;
	}
}
