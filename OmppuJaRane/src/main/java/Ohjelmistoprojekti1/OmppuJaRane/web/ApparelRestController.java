package Ohjelmistoprojekti1.OmppuJaRane.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import Ohjelmistoprojekti1.OmppuJaRane.domain.Apparel;
import Ohjelmistoprojekti1.OmppuJaRane.domain.ApparelRepository;

@Controller
@CrossOrigin
public class ApparelRestController {
	
	@Autowired
	private ApparelRepository arepository;
	
	// RESTful service to get all apparel
    @RequestMapping(value="/apparels", method = RequestMethod.GET)
    public @ResponseBody List<Apparel> apparelListRest() {	
        return (List<Apparel>) arepository.findAll();
    }

	// RESTful service to get apparel by id
    @RequestMapping(value="/apparels/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Apparel> findApparelRest(@PathVariable("id") Long apparelId) {	
    	return arepository.findById(apparelId);
    }      
    
    // RESTful service to save new apparel
    @RequestMapping(value="/apparels", method = RequestMethod.POST)
    public @ResponseBody Apparel saveApparelRest(@RequestBody Apparel apparel) {	
    	return arepository.save(apparel);
    }
    
    // RESTful service to delete apparel
    @DeleteMapping("/apparels/{id}")
    public @ResponseBody void deleteApparel(@PathVariable("id") Long id) {
    	arepository.deleteById(id);
    }

}
