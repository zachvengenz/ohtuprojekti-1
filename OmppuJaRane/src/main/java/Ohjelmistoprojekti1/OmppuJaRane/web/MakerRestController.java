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

import Ohjelmistoprojekti1.OmppuJaRane.domain.Maker;
import Ohjelmistoprojekti1.OmppuJaRane.domain.MakerRepository;

@Controller
@CrossOrigin
public class MakerRestController {
	
	@Autowired
	private MakerRepository mrepository;
	
	// RESTful service to get all makers
    @RequestMapping(value="/makers", method = RequestMethod.GET)
    public @ResponseBody List<Maker> makerListRest() {	
        return (List<Maker>) mrepository.findAll();
    }    

	// RESTful service to get maker by id
    @RequestMapping(value="/makers/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Maker> findMakerRest(@PathVariable("id") Long makerId) {	
    	return mrepository.findById(makerId);
    }      
    
    // RESTful service to save new maker
    @RequestMapping(value="/makers", method = RequestMethod.POST)
    public @ResponseBody Maker saveMakerRest(@RequestBody Maker maker) {	
    	return mrepository.save(maker);
    }
    
    // RESTful service to delete maker
    @DeleteMapping("/makers/{id}")
    void deleteMaker(@PathVariable Long id) {
    	mrepository.deleteById(id);
    }

}
