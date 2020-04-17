package br.edu.infnet.vendamvc.controle;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import br.edu.infnet.vendamvc.auxiliar.ProdutoEditor;
import br.edu.infnet.vendamvc.model.negocio.Produto;
import br.edu.infnet.vendamvc.model.negocio.Venda;
import br.edu.infnet.vendamvc.model.service.ClienteService;
import br.edu.infnet.vendamvc.model.service.ProdutoService;
import br.edu.infnet.vendamvc.model.service.VendaService;

@Controller
@SessionAttributes("user")
public class VendaController {
	
	@Autowired
	private VendaService service;
	@Autowired
	private ClienteService clienteService;
	@Autowired
	private ProdutoService produtoService;
	
	@RequestMapping(value = "/venda", method = RequestMethod.GET)
	public String showDetalhe(Model model) {
		model.addAttribute("clientesLista", clienteService.obterLista());
		model.addAttribute("produtosLista", produtoService.obterDisponiveis());
		return "venda/detalhe";
	}
	
	@RequestMapping(value = "/vendas", method = RequestMethod.GET)
	public String obterLista(Model model) {
		model.addAttribute("vendasLista", service.obterLista());
		return "venda/lista";
	}
	
	@InitBinder     
	public void initBinder(WebDataBinder binder){
	     binder.registerCustomEditor(Produto.class, new ProdutoEditor());   
	}
	
	@RequestMapping(value = "/venda", method = RequestMethod.POST)
	public String incluir(Model model, Venda venda) {
		
		service.incluir(venda);
		for (Produto produto : venda.getProdutos()) {
			produto.setVenda(venda);
			produtoService.atualizar(produto);
		}
		
		return this.obterLista(model);
	}
	
	@RequestMapping(value = "/venda/excluir/{id}", method = RequestMethod.GET)
	public String excluir(Model model, @PathVariable Integer id) {
		
		Optional<Venda> venda = service.obterPorId(id);
		for (Produto produto : venda.get().getProdutos()) {
			produto.setVenda(null);
			produtoService.atualizar(produto);
		}
		service.excluir(id);
		
		return this.obterLista(model);
	}

	public VendaService getService() {
		return service;
	}

	public void setService(VendaService service) {
		this.service = service;
	}	

}
