package s4.spring.td5.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;





@Controller
@RequestMapping("/user/")
public class ConnController {
	
	@RequestMapping("login")
	public String index (ModelMap model) {
		return ("login");
	}

}

