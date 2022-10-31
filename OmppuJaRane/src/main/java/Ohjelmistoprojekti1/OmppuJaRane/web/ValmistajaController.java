package Ohjelmistoprojekti1.OmppuJaRane.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    
    @RequestMapping(value = "/savecat", method = RequestMethod.POST)
    public String save(Valmistaja valmistaja){
        valmistajarepository.save(valmistaja);
        return "redirect:valmistjalista";
    }    
	
}


