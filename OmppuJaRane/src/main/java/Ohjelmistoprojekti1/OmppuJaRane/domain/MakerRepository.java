package Ohjelmistoprojekti1.OmppuJaRane.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;



public interface MakerRepository extends CrudRepository<Maker, Long>{

	List<Maker> findByName(String name);
	
}


