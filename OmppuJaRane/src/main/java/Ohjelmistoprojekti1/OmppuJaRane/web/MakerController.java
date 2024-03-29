package Ohjelmistoprojekti1.OmppuJaRane.web;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	@PreAuthorize("hasAuthority('ADMIN')")
    public String addValmistaja(Model model){
    	model.addAttribute("maker", new Maker());
        return "addmaker";
    }     
    
    @RequestMapping(value = "/save_maker", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('ADMIN')")
    public String save(@Valid Maker maker, BindingResult result, Model model){  
        if (result.hasErrors()) {
    		model.addAttribute("makers", mrepository.findAll());
    		return "addmaker";
    	}
        mrepository.save(maker);
        return "redirect:/maker_list";
    }    
    @GetMapping("/delete_maker/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteMaker(@PathVariable("id") Long id, Maker maker) {
    	mrepository.deleteById(id);
        return "redirect:/maker_list";
    }
    @RequestMapping(value = "/edit_maker/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
	public String editMaker(@PathVariable("id") Long id, Model model) {
		model.addAttribute("maker", mrepository.findById(id));
		return "editmaker";   
    
} 
    @PostMapping("/update_maker/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String updateMaker(@PathVariable("id") long makerId, Model model, Maker maker) {
    	maker.setId(makerId);
    	mrepository.save(maker);
    	return "redirect:/apparel_list";
    }
    
 
}


