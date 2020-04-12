package br.edu.infnet.vendamvc.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.vendamvc.model.negocio.Usuario;
import br.edu.infnet.vendamvc.model.repository.IUsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private IUsuarioRepository repository;
	
	public boolean isValid(String login, String senha) {
		return "admin".equalsIgnoreCase(login) &&
			   "admin".equalsIgnoreCase(senha);
	}
	
	public List<Usuario> obterLista() {
		return (List<Usuario>) repository.findAll();
	}
	
	public void incluir(Usuario usuario) {
		repository.save(usuario);
	}

	public void excluir(Integer id) {
		repository.deleteById(id);
	}
}
