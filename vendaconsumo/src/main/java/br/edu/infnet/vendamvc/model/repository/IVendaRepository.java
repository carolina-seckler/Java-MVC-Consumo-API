package br.edu.infnet.vendamvc.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.vendamvc.model.negocio.Venda;

@Repository
public interface IVendaRepository extends CrudRepository<Venda, Integer> {
	
}
