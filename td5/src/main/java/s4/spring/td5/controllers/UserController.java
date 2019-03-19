package s4.spring.td5.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
	@GetMapping("login")
	public String login() {
		return ("users/login");
	}
	
	
	
	

}
