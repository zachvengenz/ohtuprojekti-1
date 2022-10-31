package Ohjelmistoprojekti1.OmppuJaRane.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;



public interface ValmistajaRepository extends CrudRepository<Valmistaja, Long>{

	List<Valmistaja> findByName(String name);
}


