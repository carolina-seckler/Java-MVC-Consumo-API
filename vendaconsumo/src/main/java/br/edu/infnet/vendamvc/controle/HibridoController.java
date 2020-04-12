package br.edu.infnet.vendamvc.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import br.edu.infnet.vendamvc.model.negocio.Hibrido;
import br.edu.infnet.vendamvc.model.service.HibridoService;

@Controller
@SessionAttributes("user")
public class HibridoController {

	@Autowired
	private HibridoService service;
	
	@RequestMapping(value = "/hibrido", method = RequestMethod.GET)
	public String showDetalhe() {
		return "hibrido/detalhe";
	}
	
	@RequestMapping(value = "/hibridos", method = RequestMethod.GET)
	public String obterLista(Model model) {
		model.addAttribute("hibridosLista", service.obterLista());
		return "hibrido/lista";
	}
	
	@RequestMapping(value = "/hibrido", method = RequestMethod.POST)
	public String incluir(Model model, Hibrido hibrido) {
		
		service.incluir(hibrido);
		
		return this.obterLista(model);
	}
	
	@RequestMapping(value = "/hibrido/excluir/{id}", method = RequestMethod.GET)
	public String excluir(Model model, @PathVariable Integer id) {
		
		service.excluir(id);
		
		return this.obterLista(model);
	}
}
