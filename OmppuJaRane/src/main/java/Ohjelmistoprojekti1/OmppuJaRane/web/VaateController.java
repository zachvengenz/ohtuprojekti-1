package Ohjelmistoprojekti1.OmppuJaRane.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Ohjelmistoprojekti1.OmppuJaRane.domain.Vaate;
import Ohjelmistoprojekti1.OmppuJaRane.domain.VaatteetRepository;


@Controller
public class VaateController {
	@Autowired
	private VaatteetRepository repository; 
	
    @RequestMapping(value="/vaatelista")
    public String studentList(Model model) {	
        model.addAttribute("vaate", repository.findAll());
        return "vaatelista";
    }
    
    @RequestMapping(value = "/add")
    public String addVaate(Model model){
    	model.addAttribute("vaate", new Vaate());
        return "addvaate";
    }     
    
    @RequestMapping(value = "/edit/{id}")
	public String editVaate(@PathVariable("id") Long vaateId, Model model) {
		model.addAttribute("vaate", repository.findById(vaateId));
		return "editvaate";
    
    
} 
    }