package Ohjelmistoprojekti1.OmppuJaRane.domain;

import java.util.List;


import org.springframework.data.repository.CrudRepository;

public interface ApparelRepository extends CrudRepository<Apparel, Long> {
	
	List<Apparel> findByName(String name);
	

}
