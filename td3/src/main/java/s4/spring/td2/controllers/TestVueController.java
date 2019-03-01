package s4.spring.td2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.github.jeemv.springboot.vuejs.VueJS;

@Controller
@RequestMapping("/vue")
public class TestVueController {
	@Autowired
	private VueJS vue;
	
	@GetMapping("test")
	public String test(Model model ) {
		model.addAttribute("message", "HEllo world!");
		return "vueJS/test";
		
	}

}
