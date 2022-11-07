package Ohjelmistoprojekti1.OmppuJaRane.web;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import Ohjelmistoprojekti1.OmppuJaRane.domain.Apparel;
import Ohjelmistoprojekti1.OmppuJaRane.domain.Maker;
import Ohjelmistoprojekti1.OmppuJaRane.domain.MakerRepository;


@Controller
public class MakerController {


	@Autowired
	private MakerRepository mrepository; 
			
	@RequestMapping(value="/maker_list", method = RequestMethod.GET)
	public String valmistajaList(Model model) {
		model.addAttribute("makers", mrepository.findAll());
		return "makerlist";
	}
	
	@RequestMapping(value = "/add_maker")
    public String addValmistaja(Model model){
    	model.addAttribute("maker", new Maker());
        return "addmaker";
    }     
    
    @RequestMapping(value = "/save_maker", method = RequestMethod.POST)
    public String save(@Valid Maker maker, BindingResult result, Model model){  
        if (result.hasErrors()) {
    		model.addAttribute("makers", mrepository.findAll());
    		return "addmaker";
    	}
        mrepository.save(maker);
        return "redirect:/maker_list";
    }    
    @GetMapping("/delete_maker/{id}")
    public String deleteMaker(@PathVariable("id") Long id, Maker maker) {
    	mrepository.deleteById(id);
        return "redirect:/maker_list";
    }
    @RequestMapping(value = "/edit_maker/{id}")
	public String editMaker(@PathVariable("id") Long id, Model model) {
		model.addAttribute("maker", mrepository.findById(id));
		return "editmaker";   
    
} 
    @PostMapping("/update_maker/{id}")
    public String updateMaker(@PathVariable("id") long makerId, Model model, Maker maker) {
    	maker.setId(makerId);
    	mrepository.save(maker);
    	return "redirect:/apparel_list";
    }
    
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
}


