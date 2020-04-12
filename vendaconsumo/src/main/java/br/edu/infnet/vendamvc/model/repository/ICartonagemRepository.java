package br.edu.infnet.vendamvc.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.vendamvc.model.negocio.Cartonagem;

@Repository
public interface ICartonagemRepository extends CrudRepository<Cartonagem, Integer> {
	
	@Query("select c from Cartonagem c, Produto p where p.id = c.produto and p.venda is null")
	List<Cartonagem> findAvailable();

}
