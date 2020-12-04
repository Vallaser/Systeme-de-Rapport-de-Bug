package qv.fr.uphf.BugTracking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import qv.fr.uphf.BugTracking.entities.Developer;
import qv.fr.uphf.BugTracking.repositories.DeveloperRepository;

@RestController
public class DeveloperController {
	
	@Autowired
	DeveloperRepository developersRepository;
	
	/* @RequestMapping(value = "/Developers", method = RequestMethod.GET)
	    public MappingJacksonValue listeProduits() {
	        Iterable<Developer> developers = developersRepository.findAll();

	        MappingJacksonValue developersFiltres = new MappingJacksonValue(developers);

	        return developersFiltres;
	    }*/
	
	@GetMapping("developers")
	public List<Developer> getDevelopers()
	{
		return developersRepository.findAll();
	}
	
	 @GetMapping("developers/{id}")
	    public Developer getDeveloper(@PathVariable("id") Integer id) {
	        return developersRepository.findById(id).orElse(null);
	    }

}
