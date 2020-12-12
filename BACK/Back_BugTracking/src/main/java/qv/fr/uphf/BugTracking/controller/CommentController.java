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

import qv.fr.uphf.BugTracking.entities.Comment;
import qv.fr.uphf.BugTracking.entities.CreateComment;
import qv.fr.uphf.BugTracking.entities.Developer;
import qv.fr.uphf.BugTracking.exception.ResourceNotFoundException;
import qv.fr.uphf.BugTracking.repositories.BugRepository;
import qv.fr.uphf.BugTracking.repositories.CommentRepository;
import qv.fr.uphf.BugTracking.repositories.DeveloperRepository;

/**
 * CommentController la classe pour les methodes REST de l'entity Comment
 * @author Quentin Colras
 */

@RestController
public class CommentController {

	@Autowired
	CommentRepository commentsRepository;
	@Autowired
	BugRepository bugsRepository;
	@Autowired
	DeveloperRepository developersRepository;
	
	
	/**
	 * La fonction permettant de recuperer la liste des commentaires
	 * @return La liste des commentaires present dans la base de donnees H2
	 */
	@GetMapping("comments")
		public List<Comment> getComments() {
			return commentsRepository.findAll();
		}
	
	/**
	 * La fonction permettant de recuperer un commentaire specifique par son id
	 * @param id L'id du commentaire qu'on doit retourner
	 * @return Le commentaire ayant pour id_comment id
	 */
	@GetMapping("comments/{id}")
	    public Comment getComment(@PathVariable("id") Integer id) {
	        return commentsRepository.findById(id).orElse(null);
	    }
	
	/**
	 * La fonction permettant de recuperer le developppeur qui a ecrit le commentaire specifique par son id
	 * @param id L'id du commentaire
	 * @return Le developpeur qui a ecrit le commentaire sous la forme d'une liste
	 */
	@GetMapping("commentsDev/{id}")
	    public List<Developer> getDevByCommentId(@PathVariable("id") Integer id) {
			List<Developer> listeDeveloper = new ArrayList<Developer>();
			Optional<Comment> commentOpt = commentsRepository.findById(id);
			if(commentOpt.isPresent())
				listeDeveloper.add(commentOpt.get().getDeveloper());
	        return listeDeveloper;
	    }
	
	/**
	  * La fonction permettant de creer un nouveau commentaire dans la BDD
	  * @param comment Le nouveau commentaire a inserer, de type CreateComment
	  * @return L'entity Comment construit a partir du comment passe en parametre
	  */
	@PostMapping("comments")
	    public Comment createComment(@Validated @RequestBody CreateComment comment) { 
	        return commentsRepository.save(
	            Comment
	            .builder()
	            .comment(comment.getComment())
	            .dateComment(comment.getDateComment())
	            .bug(bugsRepository.findById(comment.getBug_id()).get())
	            .developer(developersRepository.findById(comment.getDeveloper_id()).get())
	            .build()
	        );
	    }
	
	/**
	  * La fonction permettant de supprimer un commentaire dans la BDD
	  * @param id L'id du commentaire que l'on doit supprimer
	  * @return Une reponse si c'est la suppression a fonctionne ou non
	  */
	@DeleteMapping("comments/{id}")
	    public ResponseEntity<?> deleteComment(@PathVariable("id") Integer id) {
	        return commentsRepository.findById(id)
	                .map(bug -> {
	                	commentsRepository.delete(bug);
	                    return ResponseEntity.ok().build();
	                }).orElseThrow(() -> new ResourceNotFoundException("Bug not found with id " + id));
	
	    }
	
	/**
	  * La fonction permettant de modifier le contenu d'un commentaire dans la BDD
	  * @param id L'id du commentaire que l'on doit modifier
	  * @param com Le nouveeau contenu a attribuer au commentaire
	  * @return Une reponse si la modification a fonctionne ou non
	  */
	@PutMapping("comments/{id}/comment={comment}")
		public ResponseEntity<?> updateCommentComment(@PathVariable("id") Integer id, @PathVariable("comment") String com) {
	        return commentsRepository.findById(id)
	                .map(comment -> {
	                	comment.setComment(com);
	                		commentsRepository.save(comment);
	                    return ResponseEntity.ok().build();
	                }).orElseThrow(() -> new ResourceNotFoundException("Bug not found with id " + id));
		}
	
	/**
	  * La fonction permettant de modifier la date d'un commentaire dans la BDD
	  * @param id L'id du commentaire que l'on doit modifier
	  * @param datecomment La nouvelle date a attribuer au commentaire
	  * @return Une reponse si la modification a fonctionne ou non
	  */
	@PutMapping("comments/{id}/datecomment={datecomment}")
		public ResponseEntity<?> updateCommentDateComment(@PathVariable("id") Integer id, @PathVariable("datecomment") 
			@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date datecomment) {
				return commentsRepository.findById(id)
		                .map(comment -> {
		                	comment.setDateComment(datecomment);
		                		commentsRepository.save(comment);
		                    return ResponseEntity.ok().build();
		                }).orElseThrow(() -> new ResourceNotFoundException("Bug not found with id " + id));
			}
	
}
