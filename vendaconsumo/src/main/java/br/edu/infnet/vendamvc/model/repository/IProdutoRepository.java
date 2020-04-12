package br.edu.infnet.vendamvc.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.vendamvc.model.negocio.Produto;

@Repository
public interface IProdutoRepository extends CrudRepository<Produto, Integer> {

}
