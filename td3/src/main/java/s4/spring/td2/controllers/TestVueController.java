package s4.spring.td2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import io.github.jeemv.springboot.vuejs.VueJS;
import io.github.jeemv.springboot.vuejs.utilities.Http;

@Controller
@RequestMapping("/vue")
public class TestVueController {
	@Autowired
	private VueJS vue;
	
	@GetMapping("test")
	public String test(Model model ) {
		model.addAttribute("message", "HEllo world!");
		model.addAttribute("vue",vue);
		vue.addMethod("update", "this.message='Message modifié!';");
		vue.addMethod("testAjax","var self=this;"+ Http.post("/vue/test/ajax","{v:self.inputValue}",
				"self.ajaxMessage=response.data;self.alertVisible=true"));
		vue.addData("message", "Hello world!");
		vue.addData("alertVisible", false);
		vue.addData("ajaxMessage");
		vue.addData("inputValue");
		return "vueJs/test";
		
	}
	
	@PostMapping("test/ajax")
	@ResponseBody
	public String testAjax (@RequestBody String v) {
		return "Test ok!"+v;
	}

}
