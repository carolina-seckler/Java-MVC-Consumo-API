package br.edu.infnet.vendamvc.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.vendamvc.model.negocio.Hibrido;

@Repository
public interface IHibridoRepository extends CrudRepository<Hibrido, Integer> {
	
	@Query("select h from Hibrido h, Produto p where p.id = h.produto and p.venda is null")
	List<Hibrido> findAvailable();

}
