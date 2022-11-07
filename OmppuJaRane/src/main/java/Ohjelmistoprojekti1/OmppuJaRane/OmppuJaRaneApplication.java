package Ohjelmistoprojekti1.OmppuJaRane;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import Ohjelmistoprojekti1.OmppuJaRane.domain.Apparel;
import Ohjelmistoprojekti1.OmppuJaRane.domain.ApparelRepository;
import Ohjelmistoprojekti1.OmppuJaRane.domain.Maker;
import Ohjelmistoprojekti1.OmppuJaRane.domain.MakerRepository;

@SpringBootApplication
public class OmppuJaRaneApplication {

	public static void main(String[] args) {
		SpringApplication.run(OmppuJaRaneApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(ApparelRepository repository, MakerRepository vrepository)
	
		{return (args) -> {
			final Logger logger = LoggerFactory.getLogger(CommandLineRunner.class);
			
			Maker v1 = new Maker("Leikki");
			Maker v2 = new Maker("M&M");
			
			vrepository.save(v1);
			vrepository.save(v2);
			
			vrepository.findAll().forEach((maker) -> {
				logger.info("{}", maker);
			});
			
			Apparel va1 = new Apparel("JoustavaMeno", "Haalari", 59.00, vrepository.findByName("M&M").get(0));
			Apparel va2 = new Apparel("70-luku", "Haalari", 32.00, vrepository.findByName("Leikki").get(0));
			Apparel va3 = new Apparel("LämpöisäHaukku", "Talvihaalari", 92.00, vrepository.findByName("Leikki").get(0));
			
			repository.save(va1);
			repository.save(va2);
			repository.save(va3);
			
			repository.findAll().forEach((apparel) -> {
				logger.info("{}", apparel);
			});
		};

}
}
