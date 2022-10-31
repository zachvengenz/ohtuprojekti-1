package Ohjelmistoprojekti1.OmppuJaRane.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Ohjelmistoprojekti1.OmppuJaRane.domain.Valmistaja;
import Ohjelmistoprojekti1.OmppuJaRane.domain.ValmistajaRepository;


@Controller
public class ValmistajaController {


	@Autowired
	private ValmistajaRepository valmistajarepository; 
			
	@RequestMapping(value="/valmistajalista", method = RequestMethod.GET)
	public String valmistajaList(Model model) {
		model.addAttribute("valmistaja", valmistajarepository.findAll());
		return "valmistajalista";
	}
	
	@RequestMapping(value = "/addvalmistaja")
    public String addValmistaja(Model model){
    	model.addAttribute("valmistaja", new Valmistaja());
        return "addvalmistaja";
    }     
    
    @RequestMapping(value = "/savevalmistaja", method = RequestMethod.POST)
    public String save(Valmistaja valmistaja){
        valmistajarepository.save(valmistaja);
        return "redirect:/valmistajalista";
    }    
    @GetMapping("/deletevalmistaja/{id}")
    public String deleteValmistaja(@PathVariable("id") Long id, Valmistaja valmistaja) {
    	valmistajarepository.deleteById(id);
        return "redirect:/valmistajalista";
    }
    @RequestMapping(value = "/editvalmistaja/{id}")
	public String editValmistaja(@PathVariable("id") Long id, Model model) {
		model.addAttribute("valmistaja", valmistajarepository.findById(id));
		return "editvalmistaja";   
    
} 
}


