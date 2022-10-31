package Ohjelmistoprojekti1.OmppuJaRane;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import Ohjelmistoprojekti1.OmppuJaRane.domain.VaatteetRepository;
import Ohjelmistoprojekti1.OmppuJaRane.domain.Valmistaja;
import Ohjelmistoprojekti1.OmppuJaRane.domain.ValmistajaRepository;

@SpringBootApplication
public class OmppuJaRaneApplication {

	public static void main(String[] args) {
		SpringApplication.run(OmppuJaRaneApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(VaatteetRepository repository, ValmistajaRepository vrepository)
	
		{return (args) -> {
			final Logger logger = LoggerFactory.getLogger(CommandLineRunner.class);
			
			Valmistaja v1 = new Valmistaja("Leikki");
			Valmistaja v2 = new Valmistaja("M&M");
			
			vrepository.save(v1);
			vrepository.save(v2);
			
			vrepository.findAll().forEach((valmistaja) -> {
				logger.info("{}", valmistaja);
			});
			
			
		
		}
		}

}
