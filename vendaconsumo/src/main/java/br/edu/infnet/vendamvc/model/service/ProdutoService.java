package br.edu.infnet.vendamvc.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.vendamvc.model.negocio.Cartonagem;
import br.edu.infnet.vendamvc.model.negocio.Hibrido;
import br.edu.infnet.vendamvc.model.negocio.Produto;
import br.edu.infnet.vendamvc.model.negocio.Tecido;
import br.edu.infnet.vendamvc.model.repository.ICartonagemRepository;
import br.edu.infnet.vendamvc.model.repository.IHibridoRepository;
import br.edu.infnet.vendamvc.model.repository.IProdutoRepository;
import br.edu.infnet.vendamvc.model.repository.ITecidoRepository;

@Service
public class ProdutoService {

	@Autowired
	IProdutoRepository repository;
	@Autowired
	ITecidoRepository tecidoRepository;
	@Autowired
	ICartonagemRepository cartonagemRepository;
	@Autowired
	IHibridoRepository hibridoRepository;
	
	public Optional<Produto> obterPorId(Integer id) {
		return repository.findById(id);
	}
	
	public void atualizar(Produto produto) {
		repository.save(produto);
	}
	
	public List<Produto> obterDisponiveis() {
		List<Produto> produtos = new ArrayList<Produto>();
		List<Tecido> tecidos = (List<Tecido>) tecidoRepository.findAvailable();
		List<Cartonagem> cartonagens = (List<Cartonagem>) cartonagemRepository.findAvailable();
		List<Hibrido> hibridos = (List<Hibrido>) hibridoRepository.findAvailable();
		produtos.addAll(tecidos);
		produtos.addAll(cartonagens);
		produtos.addAll(hibridos);
		return produtos;
	}
}
