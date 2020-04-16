package br.edu.infnet.vendamvc.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.edu.infnet.vendamvc.model.negocio.Usuario;

@Service
public class UsuarioService {
	
	@Autowired
	private RestTemplate rest;
	
	public boolean isValid(String login, String senha) {
		return "admin".equalsIgnoreCase(login) &&
			   "admin".equalsIgnoreCase(senha);
	}
		
	@SuppressWarnings("unchecked")
	public List<Usuario> obterLista() {
		return (List<Usuario>)rest.getForObject("http://localhost:8080/api/usuario", List.class);
	}
	
	@SuppressWarnings("unchecked")
	public Optional<Usuario> obterPorId(Integer id) {
		return rest.getForEntity("http://localhost:8080/api/usuario" + "/"+ id, Optional.class).getBody();
	}
	
	public void incluir (Usuario usuario) {
		rest.postForEntity("http://localhost:8080/api/usuario", usuario, String.class);
	}
	
	public void excluir (Integer id) {
		rest.delete("http://localhost:8080/api/usuario/{id}", id);
	}

	public RestTemplate getRest() {
		return rest;
	}

	public void setRest(RestTemplate rest) {
		this.rest = rest;
	}
}
