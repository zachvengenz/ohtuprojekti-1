package Ohjelmistoprojekti1.OmppuJaRane.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Ohjelmistoprojekti1.OmppuJaRane.domain.Vaate;
import Ohjelmistoprojekti1.OmppuJaRane.domain.VaatteetRepository;
import Ohjelmistoprojekti1.OmppuJaRane.domain.ValmistajaRepository;


@Controller
public class VaateController {
	@Autowired
	private VaatteetRepository repository; 
	
	@Autowired
	private ValmistajaRepository vrepository;
	
	// etusivulle
	@GetMapping(value="/")
    public String etusivu() {	
        return "etusivu";
    }
	
    @GetMapping(value="/vaatelista")
    public String vaateList(Model model) {	
        model.addAttribute("vaatteet", repository.findAll());
        return "vaatelista";
    }
    
    @RequestMapping(value = "/add")
    public String addVaate(Model model){
    	model.addAttribute("vaate", new Vaate());
    	model.addAttribute("valmistajat", vrepository.findAll());
        return "addvaate";
    }     
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Vaate vaate){
        repository.save(vaate);
        return "redirect:vaatelista";
    }    

    @RequestMapping(value = "/edit/{id}")
	public String editVaate(@PathVariable("id") Long vaateId, Model model) {
		model.addAttribute("vaate", repository.findById(vaateId));
		model.addAttribute("valmistajat", vrepository.findAll());
		return "editvaate";   
    
} 
    @GetMapping("/delete/{id}")
    public String deleteVaate(@PathVariable("id") Long vaateId, Model model) {
    	repository.deleteById(vaateId);
        return "redirect:/vaatelista";
    }
    }