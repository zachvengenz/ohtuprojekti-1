package Ohjelmistoprojekti1.OmppuJaRane.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public String addValmistaja(Model model){
    	model.addAttribute("maker", new Maker());
        return "addmaker";
    }     
    
    @RequestMapping(value = "/save_maker", method = RequestMethod.POST)
    public String save(Maker maker){
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
}


