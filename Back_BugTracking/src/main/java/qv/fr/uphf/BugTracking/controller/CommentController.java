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

import qv.fr.uphf.BugTracking.entities.Comment;
import qv.fr.uphf.BugTracking.entities.CreateComment;
import qv.fr.uphf.BugTracking.exception.ResourceNotFoundException;
import qv.fr.uphf.BugTracking.repositories.CommentRepository;

@RestController
public class CommentController {

	@Autowired
	CommentRepository commentsRepository;
	
	@GetMapping("comments")
	public List<Comment> getComments()
	{
		return commentsRepository.findAll();
	}
	
	@GetMapping("comments/{id}")
    public Comment getComment(@PathVariable("id") Integer id) {
        return commentsRepository.findById(id).orElse(null);
    }
	
	@PostMapping("comments")
    public Comment createComment(@Validated @RequestBody CreateComment comment) { 
        return commentsRepository.save(
            Comment
            .builder()
            .id_bug(comment.getId_bug())
            .comment(comment.getComment())
            .dateComment(comment.getDateComment())
            .id_developer(comment.getId_developer())
            .build()
        );
    }
 
	@DeleteMapping("comments/{id}")
    public ResponseEntity<?> deleteComment(@PathVariable("id") Integer id) {
        if(!commentsRepository.existsById(id)) {
            throw new ResourceNotFoundException("Bug not found with id " + id);
        }

        return commentsRepository.findById(id)
                .map(bug -> {
                	commentsRepository.delete(bug);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Bug not found with id " + id));

    }
}
