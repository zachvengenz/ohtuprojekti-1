package Ohjelmistoprojekti1.OmppuJaRane.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Ohjelmistoprojekti1.OmppuJaRane.domain.Apparel;
import Ohjelmistoprojekti1.OmppuJaRane.domain.ApparelRepository;
import Ohjelmistoprojekti1.OmppuJaRane.domain.MakerRepository;


@Controller
public class ApparelController {
	@Autowired
	private ApparelRepository arepository; 
	
	@Autowired
	private MakerRepository mrepository;
	
	// etusivulle
	@GetMapping(value="/")
    public String etusivu() {	
        return "frontpage";
    }
	
    @GetMapping(value="/apparel_list")
    public String apparelList(Model model) {	
        model.addAttribute("apparels", arepository.findAll());
        return "apparellist";
    }
    
    @RequestMapping(value = "/add_apparel")
    public String addApparel(Model model){
    	model.addAttribute("apparel", new Apparel());
    	model.addAttribute("makers", mrepository.findAll());
        return "addapparel";
    }     
    
    @RequestMapping(value = "/save_apparel", method = RequestMethod.POST)
    public String save(Apparel apparel){
        arepository.save(apparel);
        return "redirect:/apparel_list";
    }    

    @RequestMapping(value = "/edit_apparel/{id}")
	public String editApparel(@PathVariable("id") Long apparelId, Model model) {
		model.addAttribute("apparel", arepository.findById(apparelId));
		model.addAttribute("makers", mrepository.findAll());
		return "editapparel";   
    
} 
    @GetMapping("/delete_apparel/{id}")
    public String deleteApparel(@PathVariable("id") Long apparelId, Model model) {
    	arepository.deleteById(apparelId);
        return "redirect:/apparel_list";
    }
    }