package Ohjelmistoprojekti1.OmppuJaRane.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import Ohjelmistoprojekti1.OmppuJaRane.domain.VaatteetRepository;

public class ValmistajaController {




	@Controller
	public class VaatteetController {
			@Autowired
			private VaatteetRepository repository; 
			
		    @RequestMapping(value="/studentlist")
		    public String studentList(Model model) {	
		        model.addAttribute("students", repository.findAll());
		        return "studentlist";
		    }

	}

}
