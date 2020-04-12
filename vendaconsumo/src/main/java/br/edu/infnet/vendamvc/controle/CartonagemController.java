package br.edu.infnet.vendamvc.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import br.edu.infnet.vendamvc.model.negocio.Cartonagem;
import br.edu.infnet.vendamvc.model.service.CartonagemService;

@Controller
@SessionAttributes("user")
public class CartonagemController {

	@Autowired
	private CartonagemService service;
	
	@RequestMapping(value = "/cartonagem", method = RequestMethod.GET)
	public String showDetalhe() {
		return "cartonagem/detalhe";
	}
	
	@RequestMapping(value = "/cartonagens", method = RequestMethod.GET)
	public String obterLista(Model model) {
		model.addAttribute("cartonagensLista", service.obterLista());
		return "cartonagem/lista";
	}
	
	@RequestMapping(value = "/cartonagem", method = RequestMethod.POST)
	public String incluir(Model model, Cartonagem cartonagem) {
		
		service.incluir(cartonagem);
		
		return this.obterLista(model);
	}
	
	@RequestMapping(value = "/cartonagem/excluir/{id}", method = RequestMethod.GET)
	public String excluir(Model model, @PathVariable Integer id) {
		
		service.excluir(id);
		
		return this.obterLista(model);
	}
}
