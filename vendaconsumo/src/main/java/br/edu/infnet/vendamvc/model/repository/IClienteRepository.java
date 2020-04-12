package br.edu.infnet.vendamvc.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.vendamvc.model.negocio.Cliente;

@Repository
public interface IClienteRepository extends CrudRepository<Cliente, Integer> {
	
}
