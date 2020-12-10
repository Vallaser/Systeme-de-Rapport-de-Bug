package qv.fr.uphf.BugTracking.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import qv.fr.uphf.BugTracking.entities.Bug;
import qv.fr.uphf.BugTracking.entities.CreateBug;
import qv.fr.uphf.BugTracking.entities.Developer;
import qv.fr.uphf.BugTracking.exception.ResourceNotFoundException;
import qv.fr.uphf.BugTracking.repositories.BugRepository;
import qv.fr.uphf.BugTracking.repositories.DeveloperRepository;

@RestController
public class BugController {

	@Autowired
	BugRepository bugsRepository;
	@Autowired
	DeveloperRepository developersRepository;
	
	@GetMapping("bugs")
	public List<Bug> getBugs()
	{
		return bugsRepository.findAll();
	}
	
	@GetMapping("bugs/{id}")
    public Bug getBug(@PathVariable("id") Integer id) {
        return bugsRepository.findById(id).orElse(null);
    }
	
	@GetMapping("bugs2/{etat}")
	public List<Bug> getBugsEtat(@PathVariable("etat") String etat)
	{
		return bugsRepository.findByEtat(etat);
	}
	
	@GetMapping("bugsdev/{id}")
	public Developer getBugDev(@PathVariable("id") Integer id) {
		Optional<Bug> bugOpt = bugsRepository.findById(id);
		if(bugOpt.isPresent())
		{
			return bugOpt.get().getDeveloper();
		}
		return null;
    }
	
	@PostMapping("bugs")
    public Bug createBug(@Validated @RequestBody CreateBug bug) { 
		if(bug.getDeveloper_id() != null)
		{
			Optional<Developer> devOptionel = developersRepository.findById(bug.getDeveloper_id());
			if(devOptionel.isPresent())
				return bugsRepository.save(
			            Bug
			            .builder()
			            .title(bug.getTitle())
			            .description(bug.getDescription())
			            .priority(bug.getPriority())
			            .etat(bug.getEtat())
			            .dateCreation(bug.getDateCreation())
			            .developer(devOptionel.get())
			            //.comments(bug.getComments())
			            .build()
			        );
		}
			return bugsRepository.save(
	            Bug
	            .builder()
	            .title(bug.getTitle())
	            .description(bug.getDescription())
	            .priority(bug.getPriority())
	            .etat(bug.getEtat())
	            .dateCreation(bug.getDateCreation())
	            .developer(null)
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
	
	/*@PutMapping("bugs/{id}/{title}")
	public ResponseEntity<?> updateBugTitle(@PathVariable("id") Integer id, @PathVariable("title") String title)
	{
		if(!bugsRepository.existsById(id)) {
            throw new ResourceNotFoundException("Bug not found with id " + id);
        }

        return bugsRepository.findById(id)
                .map(bug -> {
                	bugsRepository.setBugTitleById(title, id);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Bug not found with id " + id));
	}*/
	
	@PutMapping("bugs/{id}")
	public void updateBug(@RequestBody Bug nbug, @PathVariable Integer id)
	{
		bugsRepository.findById(id)
			.map(bug -> {
	    		bug.setTitle(nbug.getTitle());
	    	bugsRepository.save(bug);
	        return ResponseEntity.ok().build();
	    });
	}
	
	@PutMapping("bugs/{id}/{title}")
	public ResponseEntity<?> updateBugTitle1(@PathVariable("id") Integer id, @PathVariable("title") String title)
	{
		if(!bugsRepository.existsById(id)) {
            throw new ResourceNotFoundException("Bug not found with id " + id);
        }

        return bugsRepository.findById(id)
                .map(bug -> {
                		bug.setTitle(title);
                	bugsRepository.save(bug);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Bug not found with id " + id));
	}
	
	@PutMapping("bugs/{id}/titre=/{title}")
	public ResponseEntity<?> updateBugTitle(@PathVariable("id") Integer id, @PathVariable("title") String title)
	{
		if(!bugsRepository.existsById(id)) {
            throw new ResourceNotFoundException("Bug not found with id " + id);
        }

        return bugsRepository.findById(id)
                .map(bug -> {
                		bug.setTitle(title);
                	bugsRepository.save(bug);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Bug not found with id " + id));
	}
	
	@PutMapping("bugs/{id}/description=/{description}")
	public ResponseEntity<?> updateBugDescription(@PathVariable("id") Integer id, @PathVariable("description") String description)
	{
		if(!bugsRepository.existsById(id)) {
            throw new ResourceNotFoundException("Bug not found with id " + id);
        }

        return bugsRepository.findById(id)
                .map(bug -> {
                		bug.setDescription(description);
                	bugsRepository.save(bug);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Bug not found with id " + id));
	}
	
	@PutMapping("bugs/{id}/priority=/{priority}")
	public ResponseEntity<?> updateBugPriority(@PathVariable("id") Integer id, @PathVariable("priority") String priority)
	{
		if(!bugsRepository.existsById(id)) {
            throw new ResourceNotFoundException("Bug not found with id " + id);
        }

        return bugsRepository.findById(id)
                .map(bug -> {
                		bug.setPriority(priority);
                	bugsRepository.save(bug);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Bug not found with id " + id));
	}
	
	@PutMapping("bugs/{id}/etat=/{etat}")
	public ResponseEntity<?> updateBugEtat(@PathVariable("id") Integer id, @PathVariable("etat") String etat)
	{
		if(!bugsRepository.existsById(id)) {
            throw new ResourceNotFoundException("Bug not found with id " + id);
        }

        return bugsRepository.findById(id)
                .map(bug -> {
                		bug.setEtat(etat);
                	bugsRepository.save(bug);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Bug not found with id " + id));
	}
	
	/*@PutMapping("bugs/{id}/developer=/{developer}")
	public ResponseEntity<?> updateBugDescription(@PathVariable("id") Integer id, @PathVariable("developer") Integer developer)
	{
		if(!bugsRepository.existsById(id)) {
            throw new ResourceNotFoundException("Bug not found with id " + id);
        }

        return bugsRepository.findById(id)
                .map(bug -> {
                		bug.setId_developer(developer);
                	bugsRepository.save(bug);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Bug not found with id " + id));
	}*/
}
