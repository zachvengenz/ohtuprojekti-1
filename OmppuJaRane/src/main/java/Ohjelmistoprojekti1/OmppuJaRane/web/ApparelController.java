package Ohjelmistoprojekti1.OmppuJaRane.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    
    @GetMapping(value="/apparelmaker/{id}")
    public String apparelMaker(@PathVariable("id") Long id, Model model) {	
    	model.addAttribute("maker", mrepository.findByMakerId(id));
       	model.addAttribute("apparel", arepository.findAll());

        return "apparelmaker";
    }
    
    @RequestMapping(value = "/add_apparel")
    public String addApparel(Model model){
    	model.addAttribute("apparel", new Apparel());
    	model.addAttribute("makers", mrepository.findAll());
        return "addapparel";
    }     
    
    @RequestMapping(value = "/save_apparel", method = RequestMethod.POST)
    public String save(@Valid Apparel apparel, BindingResult result, Model model){
    	if (result.hasErrors()) {
    		model.addAttribute("makers", mrepository.findAll());
    		return "addapparel";
    	}
        arepository.save(apparel);
        return "redirect:/apparel_list";
    }    

    @GetMapping("/edit_apparel/{id}")
	public String editApparel(@PathVariable("id") Long apparelId, Model model) {
    	Apparel apparel = arepository.findById(apparelId)
    	.orElseThrow(() -> new IllegalArgumentException("Invalid id" + apparelId));

    	model.addAttribute("apparel", apparel);
		model.addAttribute("makers", mrepository.findAll());
		
		return "editapparel";   
    
} 
    
    @PostMapping("/update_apparel/{id}")
    public String updateApparel(@PathVariable("id") Long apparelId, Model model, Apparel apparel, BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("makers", mrepository.findAll());
            return "editapparel";
        }
        apparel.setId(apparelId);
        arepository.save(apparel);
        return "redirect:/apparel_list";
    }
    
    @GetMapping("/delete_apparel/{id}")
    void deleteApparel(@PathVariable("id") Long apparelId, Model model) {
    	arepository.deleteById(apparelId);
    }
    }