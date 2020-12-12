package qv.fr.uphf.BugTracking.controller;

import java.util.ArrayList;
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
import qv.fr.uphf.BugTracking.entities.Comment;
import qv.fr.uphf.BugTracking.entities.CreateBug;
import qv.fr.uphf.BugTracking.entities.Developer;
import qv.fr.uphf.BugTracking.exception.ResourceNotFoundException;
import qv.fr.uphf.BugTracking.repositories.BugRepository;
import qv.fr.uphf.BugTracking.repositories.DeveloperRepository;

/**
 * BugController la classe pour les methodes REST de l'entity Bug
 * @author Quentin Colras
 */

@RestController
public class BugController {

	@Autowired
	BugRepository bugsRepository;
	@Autowired
	DeveloperRepository developersRepository;
	
	
	/**
	 * La fonction permettant de recuperer la liste des bugs
	 * @return La liste des bugs present dans la base de donnees H2
	 */
	@GetMapping("bugs")
		public List<Bug> getBugs() {
			return bugsRepository.findAll();
		}
	
	/**
	 * La fonction permettant de recuperer un bug specifique par son id
	 * @param id L'id du bug qu'on doit retourner
	 * @return Le bug ayant pour id_bug id
	 */
	@GetMapping("bugs/{id}")
	    public Bug getBug(@PathVariable("id") Integer id) {
	        return bugsRepository.findById(id).orElse(null);
	    }
	
	/**
	 * La fonction permettant de recuperer une liste contenant le bug specifique par son id
	 * @param id L'id du bug qu'on doit retourner
	 * @return Le bug ayant pour id_bug id
	 */
	@GetMapping("bugstab/{id}")
	    public List<Bug> getBugTab(@PathVariable("id") Integer id) {
			List<Bug> listeBug = new ArrayList<Bug>();
			listeBug.add(bugsRepository.findById(id).orElse(null));
	        return listeBug;
	    }
	
	/**
	 * La fonction permettant de recuperer la liste des bugs par leurs etats
	 * @param etat L'etat d'avancement du bug qu'on doit retourner
	 * @return Le bug ayant pour etat = etat
	 */
	@GetMapping("bugs/etat/{etat}")
		public List<Bug> getBugsEtat(@PathVariable("etat") String etat) {
			return bugsRepository.findByEtat(etat);
		}
	
	/**
	 * La fonction permettant de recuperer le index-ieme element de la liste des bugs obtenu par leurs etats
	 * @param index L'index du bug que l'on veut obtenir par rapport a la liste des bugs
	 * @param etat L'etat d'avancement du bug qui servent a obtenir la liste des bugs
	 * @return Le bug ayant pour etat = etat et etant le index_ieme element
	 */
	@GetMapping("bugs/{index}/etat/{etat}")
		public Bug getBugsIndexAndEtat(@PathVariable("index") Integer index, @PathVariable("etat") String etat) {
			ArrayList<Bug> listeBug = new ArrayList<Bug>(bugsRepository.findByEtat(etat));
			if(index < listeBug.size())
				return listeBug.get(index);
			return null;
		}
	
	/**
	 * La fonction permettant de recuperer l'identifiant du bug a partir de son index et de son etat
	 * @param index L'index du bug par rapport a la liste des bugs
	 * @param etat L'etat d'avancement du bug qui servent a obtenir la liste des bugs
	 * @return L'identifiant du bug ayant pour etat = etat et etant le index_ieme element
	 */
	@GetMapping("bugsGetId/{index}/etat/{etat}")
	public Integer getIdByBug(@PathVariable("index") Integer index, @PathVariable("etat") String etat) {
		ArrayList<Bug> listeBug = new ArrayList<Bug>(bugsRepository.findByEtat(etat));
		if(index < listeBug.size())
			return (Integer)listeBug.get(index).getId_bug();
		return null;
	}
	
	/**
	 * La fonction permettant de recuperer la liste des commentaires du bug avec l'id_bug = id
	 * @param id L'identifiant du bug
	 * @return La liste des commentaires du bug
	 */
	@GetMapping("bugscomments/{id}")
	public List<Comment> getCommentsByBug(@PathVariable("id") Integer id) {
		Optional<Bug> bugOpt = bugsRepository.findById(id);
		if(bugOpt.isPresent())
			return bugOpt.get().getComments();
		return null;
	}
	
	/**
	 * La fonction permettant de recuperer la liste avec le developer du bug avec l'id_bug = id
	 * @param id L'identifiant du bug
	 * @return La liste avec le developer du bug
	 */
	@GetMapping("bugsdeveloper/{id}")
	public List<Developer> getDeveloperByBug(@PathVariable("id") Integer id) {
		Optional<Bug> bugOpt = bugsRepository.findById(id);
		if(bugOpt.isPresent())
		{
			List<Developer> listeDev = new ArrayList<Developer>();
			listeDev.add(bugOpt.get().getDeveloper());
			return listeDev;
		}
		return null;
	}
	
	/**
	  * La fonction permettant de creer un nouveau bug dans la BDD
	  * @param bug Le nouveau bug a inserer, de type CreateBug
	  * @return L'entity Bug construit a partir du bug passe en parametre
	  */
	@PostMapping("bugs")
	    public Bug createBug(@Validated @RequestBody CreateBug bug) { 
			if(bug.getDeveloper_id() != null) //Si on tente d'insérer un developer par son id
			{
				Optional<Developer> devOptionel = developersRepository.findById(bug.getDeveloper_id());
				if(devOptionel.isPresent()) //Si le developer existe alors
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
			return bugsRepository.save( //Sinon mettre le developer a null
					Bug
		            .builder()
		            .title(bug.getTitle())
		            .description(bug.getDescription())
		            .priority(bug.getPriority())
		            .etat(bug.getEtat())
		            .dateCreation(bug.getDateCreation())
		            .developer(null)
		            .build()
		        );
		}
	        
	/**
	  * La fonction permettant de supprimer un bug dans la BDD
	  * @param id L'id du bug que l'on doit supprimer
	  * @return Une reponse si c'est la suppression a fonctionner ou non
	  */
	@DeleteMapping("bugs/{id}")
	    public ResponseEntity<?> deleteBug(@PathVariable("id") Integer id) {
	        return bugsRepository.findById(id)
	                .map(bug -> {
	                	bugsRepository.delete(bug);
	                    return ResponseEntity.ok().build();
	                }).orElseThrow(() -> new ResourceNotFoundException("Bug not found with id " + id));
	    }
	
	/**
	  * La fonction permettant de modifier le titre d'un bug dans la BDD
	  * @param id L'id du bug que l'on doit modifier
	  * @param title Le nouveau titre a attribuer au bug
	  * @return Une reponse si la modification a fonctionne ou non
	  */
	@PutMapping("bugs/{id}/title={title}")
		public ResponseEntity<?> updateBugTitle(@PathVariable("id") Integer id, @PathVariable("title") String title) {
			return bugsRepository.findById(id)
	                .map(bug -> {
	                		bug.setTitle(title);
	                	bugsRepository.save(bug);
	                    return ResponseEntity.ok().build();
	                }).orElseThrow(() -> new ResourceNotFoundException("Bug not found with id " + id));
		}
	
	/**
	  * La fonction permettant de modifier la description d'un bug dans la BDD
	  * @param id L'id du bug que l'on doit modifier
	  * @param description La nouvelle description a attribuer au bug
	  * @return Une reponse si la modification a fonctionne ou non
	  */
	@PutMapping("bugs/{id}/description={description}")
		public ResponseEntity<?> updateBugDescription(@PathVariable("id") Integer id, @PathVariable("description") String description) {
	        return bugsRepository.findById(id)
	                .map(bug -> {
	                		bug.setDescription(description);
	                	bugsRepository.save(bug);
	                    return ResponseEntity.ok().build();
	                }).orElseThrow(() -> new ResourceNotFoundException("Bug not found with id " + id));
		}
	
	/**
	  * La fonction permettant de modifier la prioritee d'un bug dans la BDD
	  * @param id L'id du bug que l'on doit modifier
	  * @param priority La nouvelle prioritee a attribuer au bug
	  * @return Une reponse si la modification a fonctionne ou non
	  */
	@PutMapping("bugs/{id}/priority={priority}")
		public ResponseEntity<?> updateBugPriority(@PathVariable("id") Integer id, @PathVariable("priority") String priority) {
	        return bugsRepository.findById(id)
	                .map(bug -> {
	                		bug.setPriority(priority);
	                	bugsRepository.save(bug);
	                    return ResponseEntity.ok().build();
	                }).orElseThrow(() -> new ResourceNotFoundException("Bug not found with id " + id));
		}
	
	/**
	  * La fonction permettant de modifier l'etat d'un bug dans la BDD
	  * @param id L'id du bug que l'on doit modifier
	  * @param etat Le nouvel etat d'avancement a attribuer au bug
	  * @return Une reponse si la modification a fonctionne ou non
	  */
	@PutMapping("bugs/{id}/etat={etat}")
		public ResponseEntity<?> updateBugEtat(@PathVariable("id") Integer id, @PathVariable("etat") String etat) {
			return bugsRepository.findById(id)
	                .map(bug -> {
	                		bug.setEtat(etat);
	                	bugsRepository.save(bug);
	                    return ResponseEntity.ok().build();
	                }).orElseThrow(() -> new ResourceNotFoundException("Bug not found with id " + id));
		}
	
	/**
	  * La fonction permettant de modifier l'etat d'un bug dans la BDD
	  * @param id L'id du bug que l'on doit modifier
	  * @param developer Le nouveau developer a attribuer au bug
	  * @return Une reponse si la modification a fonctionne ou non
	  */
	@PutMapping("bugs/{id}/developer={id_dev}")
		public ResponseEntity<?> updateBugDeveloper(@PathVariable("id") Integer id, @PathVariable("id_dev") Integer developer) {
	        return bugsRepository.findById(id)
	                .map(bug -> {
	                	Optional<Developer> optDev = developersRepository.findById(developer);
	                		if(optDev.isPresent())
	                			bug.setDeveloper(optDev.get());
	                		else bug.setDeveloper(null);
	                	bugsRepository.save(bug);
	                    return ResponseEntity.ok().build();
	                }).orElseThrow(() -> new ResourceNotFoundException("Bug not found with id " + id));
		}
}
