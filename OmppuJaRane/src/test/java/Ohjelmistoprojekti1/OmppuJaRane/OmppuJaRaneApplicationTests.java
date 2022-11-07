package Ohjelmistoprojekti1.OmppuJaRane;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import Ohjelmistoprojekti1.OmppuJaRane.web.ApparelController;
import Ohjelmistoprojekti1.OmppuJaRane.web.MakerController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class OmppuJaRaneApplicationTests {
	
	@Autowired
	private ApparelController apparelController;

	@Test
	void contextLoadsApparel() {
		assertThat(apparelController).isNotNull();
	}
	
	@Autowired
	private MakerController makerController;
	
	@Test
	void contextLoadsMaker() {
		assertThat(makerController).isNotNull();
	}

}
