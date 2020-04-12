package br.edu.infnet.vendamvc.auxiliar;

import java.beans.PropertyEditorSupport;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import br.edu.infnet.vendamvc.model.negocio.Produto;
import br.edu.infnet.vendamvc.model.service.ProdutoService;

public class ProdutoEditor extends PropertyEditorSupport {

	@Autowired
	private ProdutoService service;

    @Override
    public void setAsText(String text) {
        int id = new Integer(text);
        Optional<Produto> produto = service.obterPorId(id);
        super.setValue(produto);
    }
}
