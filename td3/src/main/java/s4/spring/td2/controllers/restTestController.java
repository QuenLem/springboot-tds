package s4.spring.td2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import s4.spring.td2.entities.Organization;
import s4.spring.td2.repositories.OrgasRepository;

@RestController
public class restTestController {
	@Autowired
	private OrgasRepository repo;
	
	@ResponseBody
	@GetMapping("")
	public List<Organization> get(){
		return repo.findAll();
		
	}
	
	@PostMapping("create")
	@ResponseBody
	public Organization post(@RequestBody Organization orga) {
		return repo.saveAndFlush(orga);
	}

}
