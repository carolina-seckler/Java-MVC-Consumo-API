package br.edu.infnet.vendamvc.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.vendamvc.model.negocio.Tecido;

@Repository
public interface ITecidoRepository extends CrudRepository<Tecido, Integer> {
	
	@Query("select t from Tecido t, Produto p where p.id = t.produto and p.venda is null")
	List<Tecido> findAvailable();

}
