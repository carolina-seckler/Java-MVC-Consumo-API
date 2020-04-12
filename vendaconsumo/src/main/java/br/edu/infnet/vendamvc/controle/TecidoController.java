package br.edu.infnet.vendamvc.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import br.edu.infnet.vendamvc.model.negocio.Tecido;
import br.edu.infnet.vendamvc.model.service.TecidoService;

@Controller
@SessionAttributes("user")
public class TecidoController {

	@Autowired
	private TecidoService service;
	
	@RequestMapping(value = "/tecido", method = RequestMethod.GET)
	public String showDetalhe() {
		return "tecido/detalhe";
	}
	
	@RequestMapping(value = "/tecidos", method = RequestMethod.GET)
	public String obterLista(Model model) {
		model.addAttribute("tecidosLista", service.obterLista());
		return "tecido/lista";
	}
	
	@RequestMapping(value = "/tecido", method = RequestMethod.POST)
	public String incluir(Model model, Tecido tecido) {
		
		service.incluir(tecido);
		
		return this.obterLista(model);
	}
	
	@RequestMapping(value = "/tecido/excluir/{id}", method = RequestMethod.GET)
	public String excluir(Model model, @PathVariable Integer id) {
		
		service.excluir(id);
		
		return this.obterLista(model);
	}
}
