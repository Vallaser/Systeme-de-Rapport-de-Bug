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

import qv.fr.uphf.BugTracking.entities.Bug;
import qv.fr.uphf.BugTracking.entities.CreateBug;
import qv.fr.uphf.BugTracking.exception.ResourceNotFoundException;
import qv.fr.uphf.BugTracking.repositories.BugRepository;

@RestController
public class BugController {

	@Autowired
	BugRepository bugsRepository;
	
	@GetMapping("bugs")
	public List<Bug> getBugs()
	{
		return bugsRepository.findAll();
	}
	
	@GetMapping("bugs/{id}")
    public Bug getBug(@PathVariable("id") Integer id) {
        return bugsRepository.findById(id).orElse(null);
    }
	
	@PostMapping("bugs")
    public Bug createBug(@Validated @RequestBody CreateBug bug) { 
        return bugsRepository.save(
            Bug
            .builder()
            .title(bug.getTitle())
            .description(bug.getDescription())
            .priority(bug.getPriority())
            .etat(bug.getEtat())
            .dateCreation(bug.getDateCreation())
            .id_developer(bug.getId_developer())
            //.comments(bug.getComments())
            .build()
        );
    }
 
	@DeleteMapping("bugs/{id}")
    public ResponseEntity<?> deleteBug(@PathVariable("id") Integer id) {
        if(!bugsRepository.existsById(id)) {
            throw new ResourceNotFoundException("Bug not found with id " + id);
        }

        return bugsRepository.findById(id)
                .map(bug -> {
                	bugsRepository.delete(bug);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Bug not found with id " + id));

    }
}
