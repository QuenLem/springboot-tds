package s4.spring.td2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import io.github.jeemv.springboot.vuejs.VueJS;

@Controller
public class testCompo {
	@Autowired
	private VueJS vue;
	
	@GetMapping("testCompo")
	public String index() {
		return "index";
	}

}
