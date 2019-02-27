package s4.spring.td0.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.view.RedirectView;

import s4.springs.td0.models.Element;

@Controller
@SessionAttributes("elements")
public class ElementsController {

	@ModelAttribute("elements")
	public List<Element> elements() {
		List<Element> elements = new ArrayList<>();
		return elements;
	}

	@RequestMapping("/")
	public String index(@ModelAttribute("elements") List<Element> elements) {
		Element elm = new Element();
		elm.setNom("Test");
		elements.add(elm);
		return "index";
	}

	@SessionAttributes("items")
	public class MainController {

		@ModelAttribute("items")
		public List<String> getItems() {
			return new ArrayList<>();
		}
	}
	
	
	@ModelAttribute("elements")
	public List<Element> getItems(){
		Element elm = new Element();
		List<Element> elms= new ArrayList<>();
		elms.add(elm);
		return elms;
		}
	
	
	@GetMapping("items")
	public String index(ModelMap model) {
		model.addAttribute("essai", "ooo");
		return "index";
	}

	@GetMapping("new")
	public String newItem() {
		return "newItem";
	}

	@PostMapping("addNewBis")
	public RedirectView addNewBis(HttpServletRequest request) {
		String nom = request.getParameter("nom");
		int eval = Integer.valueOf(request.getParameter("evaluation"));
		Element elm = new Element();
		elm.setNom(nom);
		elm.setEvaluation(eval);
		getItems().add(elm);
		return new RedirectView("/items");

	}

	@PostMapping("addNew")
	public RedirectView addNew(@RequestParam("nom") String nom, @RequestParam int evaluation) {
		Element elm = new Element();
		elm.setNom(nom);
		elm.setEvaluation(evaluation);
		getItems().add(elm);
		return new RedirectView("/items");

	}
}
