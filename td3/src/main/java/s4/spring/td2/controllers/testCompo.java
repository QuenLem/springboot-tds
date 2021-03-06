package s4.spring.td2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import io.github.jeemv.springboot.vuejs.VueJS;

@Controller
public class testCompo {
	@Autowired
	private VueJS vue;
	
	@GetMapping("testCompo")
	public String index(Model model) {
		model.addAttribute("vue",vue);
		vue.addData("message", "VOulez-vous afficher une alerte?");
		vue.addMethod("validate", "alert('validation!');");
		vue.addDataRaw("headers", "[{text:'Nom',value:'nom'}]");
		vue.addDataRaw("items", "[{nom:'SMITH'},{nom:'DUPONT'}]");
		return "index";
	}

}
