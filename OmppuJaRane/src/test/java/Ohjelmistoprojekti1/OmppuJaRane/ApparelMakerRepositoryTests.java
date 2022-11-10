package Ohjelmistoprojekti1.OmppuJaRane;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import Ohjelmistoprojekti1.OmppuJaRane.domain.Apparel;
import Ohjelmistoprojekti1.OmppuJaRane.domain.ApparelRepository;
import Ohjelmistoprojekti1.OmppuJaRane.domain.Maker;
import Ohjelmistoprojekti1.OmppuJaRane.domain.MakerRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest

public class ApparelMakerRepositoryTests {
	
	@Autowired
	private ApparelRepository repository;
	
	@Autowired
	private MakerRepository mrepository;
	
	@Test
	public void findByNameShouldReturnApparel() {
		List<Apparel> apparels = repository.findByName("JoustavaMeno");
		
		assertThat(apparels).hasSize(1);
		assertThat(apparels.get(0).getType()).isEqualTo("Haalari");
	}
	
	@Test
	public void findByNameShouldReturn() {
		List<Maker> makers = mrepository.findByName("M&M");
		
		assertThat(makers).hasSize(1);
		assertThat(makers.get(0).getName()).isEqualTo("M&M");
	}
	
	@Test
	public void createNewApparel() {
		Apparel apparel = new Apparel("Venyvä", "Liivi", 25.50, mrepository.findByName("Leikki").get(0));
		repository.save(apparel);
		
		assertThat(apparel.getId()).isNotNull();
	}
	
	@Test
	public void createNewMaker() {
		Maker maker = new Maker("Q&Q");
		mrepository.save(maker);
		
		assertThat(maker.getId()).isNotNull();
	}
	
	@Test
	public void deleteApparel() {
		Long apparelId=(long) 01;
		
		repository.deleteById(apparelId);
		
		assertThat(repository.findById((long) 01).isEmpty());
	}

}
