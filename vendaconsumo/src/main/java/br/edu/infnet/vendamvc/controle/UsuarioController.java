package br.edu.infnet.vendamvc.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import br.edu.infnet.vendamvc.model.negocio.Usuario;
import br.edu.infnet.vendamvc.model.service.UsuarioService;

@Controller
@SessionAttributes("user")
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;
	@RequestMapping(value = "/", method = RequestMethod.GET)	
	public String showInit(Model model) {
		return this.showLogin(model, null);
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLogin(Model model, @ModelAttribute Usuario user) {
		if (user != null) {
			model.addAttribute("user", user.getLogin());
			return "home";
		}
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String showHome(Model model, @RequestParam String login, @RequestParam String senha) {
		
		if (!service.isValid(login, senha)) {
			model.addAttribute("msg", "Acesso inválido!!!");
			return "login";
		}
		model.addAttribute("user", login);
		return "home";
	}
	
	@RequestMapping(value = "/usuario", method = RequestMethod.GET)
	public String showDetalhe() {
		return "usuario/detalhe";
	}
	
	@RequestMapping(value = "/usuarios", method = RequestMethod.GET)
	public String obterLista(Model model) {
		model.addAttribute("usuariosLista", service.obterLista());
		return "usuario/lista";
	}
	
	@RequestMapping(value = "/usuario", method = RequestMethod.POST)
	public String incluir(Model model, Usuario usuario) {
		
		service.incluir(usuario);
		
		return this.obterLista(model);
	}
	
	@RequestMapping(value = "/usuario/excluir/{id}", method = RequestMethod.GET)
	public String excluir(Model model, @PathVariable Integer id) {
		
		service.excluir(id);
		
		return this.obterLista(model);
	}

	public UsuarioService getService() {
		return service;
	}

	public void setService(UsuarioService service) {
		this.service = service;
	}

}
