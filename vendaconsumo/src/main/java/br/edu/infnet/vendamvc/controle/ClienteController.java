package br.edu.infnet.vendamvc.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import br.edu.infnet.vendamvc.model.negocio.Cliente;
import br.edu.infnet.vendamvc.model.service.ClienteService;

@Controller
@SessionAttributes("user")
public class ClienteController {
	
	@Autowired
	private ClienteService service;	
	
	@RequestMapping(value = "/cliente", method = RequestMethod.GET)
	public String showDetalhe() {
		return "cliente/detalhe";
	}
	
	@RequestMapping(value = "/clientes", method = RequestMethod.GET)
	public String obterLista(Model model) {
		model.addAttribute("clientesLista", service.obterLista());
		return "cliente/lista";
	}
	
	@RequestMapping(value = "/cliente", method = RequestMethod.POST)
	public String incluir(Model model, Cliente cliente) {
		
		service.incluir(cliente);
		
		return this.obterLista(model);
	}
	
	@RequestMapping(value = "/cliente/excluir/{id}", method = RequestMethod.GET)
	public String excluir(Model model, @PathVariable Integer id) {
		
		service.excluir(id);
		
		return this.obterLista(model);
	}

	public ClienteService getService() {
		return service;
	}

	public void setService(ClienteService service) {
		this.service = service;
	}

}
