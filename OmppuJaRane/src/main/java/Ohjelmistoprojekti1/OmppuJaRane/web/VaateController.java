package Ohjelmistoprojekti1.OmppuJaRane.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class VaateController {
	@Autowired
	private VaatteetRepository repository; 
	
    @RequestMapping(value="/vaatelist")
    public String studentList(Model model) {	
        model.addAttribute("vaate", repository.findAll());
        return "vaatelist";
    }