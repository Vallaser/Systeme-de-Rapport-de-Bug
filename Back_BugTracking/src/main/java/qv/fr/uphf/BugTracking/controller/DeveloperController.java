package qv.fr.uphf.BugTracking.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
import qv.fr.uphf.BugTracking.entities.CreateDeveloper;
import qv.fr.uphf.BugTracking.entities.Developer;
import qv.fr.uphf.BugTracking.exception.ResourceNotFoundException;
import qv.fr.uphf.BugTracking.repositories.DeveloperRepository;


/**
 * DeveloperController la classe pour les methodes REST de l'entity Developer
 * @author Quentin Colras
 */

@RestController
public class DeveloperController {
	
	@Autowired
	DeveloperRepository developersRepository;
	
	
	/**
	 * La fonction permettant de recuperer la liste des developpeurs
	 * @return La liste des developpeurs present dans la base de donnees H2
	 */
	@GetMapping("developers")
		public List<Developer> getDevelopers() {
			return developersRepository.findAll();
		}
	
	/**
	 * La fonction permettant de recuperer un developpeur specifique par son id
	 * @param id L'id du developpeur qu'on doit retourner
	 * @return Le developpeur ayant pour id_developer id
	 */
	 @GetMapping("developers/{id}")
	 	public Developer getDeveloper(@PathVariable("id") Integer id) {
		 	return developersRepository.findById(id).orElse(null);
	 	}
	 
	 /**
		 * La fonction permettant de recuperer la liste des bugs d'un developpeur specifique par son id entre deux dates
		 * @param id L'id du developpeur qu'on doit retourner
		 * @param datemin La date minimale
		 * @param datemax La date maximale
		 * @return La liste des bugs ayant pour id_developer id et comprise entre datemin et datemax
		 */
		 @GetMapping("developersFiltre/{id}/{datemin}/{datemax}")
		 	public List<Bug> getDeveloperFiltre(@PathVariable("id") Integer id, @PathVariable("datemin") 
		 	@DateTimeFormat(pattern="yyyy-MM-dd")Date datemin,
		 	@PathVariable("datemax") @DateTimeFormat(pattern="yyyy-MM-dd") Date datemax) {
			 	Optional<Developer> devOpt = developersRepository.findById(id);
			 	if(devOpt.isPresent())
			 	{
			 		List<Bug> listeBugFiltre = new ArrayList<Bug>();
			 		for(Bug bug : devOpt.get().getBugs())
			 			if(datemax.after(bug.getDateCreation()) && datemin.before(bug.getDateCreation()))
			 				listeBugFiltre.add(bug);
			 		return listeBugFiltre;
			 	}
			 	return null;
		 	}
	 
	 /**
	  * La fonction permettant de creer un nouveau developpeur dans la BDD
	  * @param developer Le nouveau developpeur a inserer, de type CreateDeveloper
	  * @return L'entity Developer construit a partir du developer passe en parametre
	  */
	 @PostMapping("developers")
	    public Developer createDeveloper(@Validated @RequestBody CreateDeveloper developer) { 
	        return developersRepository.save(
	            Developer
	            .builder()
	            .name(developer.getName())
	            .avatar(developer.getAvatar())
	            .build()
	        );
	    }
	 
	 /**
	  * La fonction permettant de supprimer un developpeur dans la BDD
	  * @param id L'id du developpeur que l'on doit supprimer
	  * @return Une reponse si c'est la suppression a fonctionne ou non
	  */
	 @DeleteMapping("developers/{id}")
	    public ResponseEntity<?> deleteDeveloper(@PathVariable("id") Integer id) {
	        return developersRepository.findById(id)
	                .map(developer -> {
	                	for(Bug bug : developer.getBugs())
	                		bug.setDeveloper(null);
	                	developersRepository.delete(developer);
	                    return ResponseEntity.ok().build();
	                }).orElseThrow(() -> new ResourceNotFoundException("Developer not found with id " + id));

	    }
	 
	 /**
	  * La fonction permettant de modifier l'avatar d'un developpeur dans la BDD
	  * @param id L'id du developpeur que l'on doit modifier
	  * @param avatar Le nouvel avatar a attribuer au developpeur
	  * @return Une reponse si la modification a fonctionne ou non
	  */
	 @PutMapping("developers/{id}/avatar={avatar}")
		public ResponseEntity<?> updateDeveloperAvatar(@PathVariable("id") Integer id, @PathVariable("avatar") String avatar) {
	        return developersRepository.findById(id)
	                .map(developer -> {
	                	developer.setAvatar(avatar);
	                	developersRepository.save(developer);
	                    return ResponseEntity.ok().build();
	                }).orElseThrow(() -> new ResourceNotFoundException("Bug not found with id " + id));
		}

}
