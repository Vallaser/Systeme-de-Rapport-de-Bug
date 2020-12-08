package qv.fr.uphf.BugTracking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import qv.fr.uphf.BugTracking.entities.CreateDeveloper;
import qv.fr.uphf.BugTracking.entities.Developer;
import qv.fr.uphf.BugTracking.exception.ResourceNotFoundException;
import qv.fr.uphf.BugTracking.repositories.DeveloperRepository;

@RestController
public class DeveloperController {
	
	@Autowired
	DeveloperRepository developersRepository;
	
	@GetMapping("developers")
	public List<Developer> getDevelopers()
	{
		return developersRepository.findAll();
	}
	
	 @GetMapping("developers/{id}")
	    public Developer getDeveloper(@PathVariable("id") Integer id) {
	        return developersRepository.findById(id).orElse(null);
	    }
	 
	 @PostMapping("developers")
	    public Developer createDeveloper(@Validated @RequestBody CreateDeveloper developer) { 
	        return developersRepository.save(
	            Developer
	            .builder()
	            .name(developer.getName())
	            .avatar(developer.getAvatar())
	            //.bugs(developer.getBugs())
	            .build()
	        );
	    }
	 
	 @DeleteMapping("developers/{id}")
	    public ResponseEntity<?> deleteDeveloper(@PathVariable("id") Integer id) {
	        if(!developersRepository.existsById(id)) {
	            throw new ResourceNotFoundException("Developer not found with id " + id);
	        }

	        return developersRepository.findById(id)
	                .map(developer -> {
	                	developersRepository.delete(developer);
	                    return ResponseEntity.ok().build();
	                }).orElseThrow(() -> new ResourceNotFoundException("Developer not found with id " + id));

	    }

}
