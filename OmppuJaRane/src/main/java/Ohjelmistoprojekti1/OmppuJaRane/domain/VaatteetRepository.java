package Ohjelmistoprojekti1.OmppuJaRane.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface VaatteetRepository extends CrudRepository<Vaate, Long> {
	
	List<Vaate> findByName(String name);

}
