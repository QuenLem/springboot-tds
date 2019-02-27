package s4.spring.td2.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

import s4.spring.td2.entities.Groupe;
import s4.spring.td2.entities.Organization;
import s4.spring.td2.repositories.GroupeRepository;
import s4.spring.td2.repositories.OrgasRepository;

@Controller
@RequestMapping("/orgas")
public class OrgasController<repoGroupes> {
	@Autowired
	private OrgasRepository orgasRepo;
	@Autowired
	private GroupeRepository repoGroupes;
	
	@RequestMapping("index")
	public String index(ModelMap model) {
		List<Organization> orgas = orgasRepo.findAll();
		model.addAttribute("orgas",orgas);
		return "index";
	}
	
	@PostMapping("submit/{id}")
	public RedirectView submit(@PathVariable int id,Organization postedOrga) {
		Optional<Organization> opt= orgasRepo.findById(id);
		if (opt.isPresent()) {
			Organization orga=opt.get();
			copyFrom(postedOrga,orga);
			orgasRepo.save(orga);
		}
		return new RedirectView("/orgas/");
		
	}
	
	@PostMapping("submit")
	public RedirectView submitNew(Organization postedOrga){
		orgasRepo.save(postedOrga);
		return new RedirectView("/orgas/");
		
		
	}
	
	@GetMapping("new")
	public String frmNew(Model model) {
		model.addAttribute("orga", new Organization());
		return "orgas/frm";
	}
	
	@GetMapping("edit/{id}")
	public String frmNew(@PathVariable int id, Model model) {
		Optional<Organization> opt= orgasRepo.findById(id);
		if (opt.isPresent()) {
			model.addAttribute("orga",opt.get());
			return "orgas/frm";
		}
		return "orgas/404";
		
	}
	
	private void copyFrom(Organization source, Organization dest) {
		dest.setName(source.getName());
		dest.setDomain(source.getDomain());
		dest.setAliases(source.getAliases());
	}

	@RequestMapping("create")
	@ResponseBody
	public String createOrga() {
		Organization organization= new Organization();
		organization.setName("Iut IFs ");
		organization.setDomain("unicaen.fr");
		organization.setAliases("iutc3.unicaen.fr");
		organization.setCity("Palavas les flots");
		orgasRepo.save(organization);		
		return organization+" ajoutée dans la BDD";
	}
	
	@RequestMapping("groupes")
	public String createGroupe() {
		Groupe groupe = new Groupe();
		repoGroupes.save(groupe);
		return "Groupe créé";
	}
	@RequestMapping("create/groupes/{id}")
	@ResponseBody
	public String createOrgaWithGroupes(@PathVariable int id) {
		Optional<Organization> optOrga= orgasRepo.findById(id);
		if(optOrga.isPresent()) {
			Organization organization =optOrga.get();
		Groupe groupe=new Groupe();
		groupe.setName("Etudiant");
		organization.addGroupe(groupe);
		orgasRepo.save(organization);		
		return organization+" ajoutée dans la BDD";
		}
		return "Orga inexistante";
	}
	

}
