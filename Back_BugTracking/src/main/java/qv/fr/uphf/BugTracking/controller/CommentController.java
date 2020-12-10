package qv.fr.uphf.BugTracking.controller;

import java.util.Date;
import java.util.List;

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
import qv.fr.uphf.BugTracking.exception.ResourceNotFoundException;
import qv.fr.uphf.BugTracking.repositories.BugRepository;
import qv.fr.uphf.BugTracking.repositories.CommentRepository;
import qv.fr.uphf.BugTracking.repositories.DeveloperRepository;

@RestController
public class CommentController {

	@Autowired
	CommentRepository commentsRepository;
	@Autowired
	BugRepository bugsRepository;
	@Autowired
	DeveloperRepository developersRepository;
	
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
            .comment(comment.getComment())
            .dateComment(comment.getDateComment())
            .bug(bugsRepository.findById(comment.getBug_id()).get())
            .developer(developersRepository.findById(comment.getDeveloper_id()).get())
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
	
	@PutMapping("comments/{id}/comment=/{comment}")
	public ResponseEntity<?> updateCommentComment(@PathVariable("id") Integer id, @PathVariable("comment") String com)
	{
		if(!commentsRepository.existsById(id)) {
            throw new ResourceNotFoundException("Bug not found with id " + id);
        }

        return commentsRepository.findById(id)
                .map(comment -> {
                	comment.setComment(com);
                		commentsRepository.save(comment);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Bug not found with id " + id));
	}
	
	@PutMapping("comments/{id}/datecomment=/{datecomment}")
	public ResponseEntity<?> updateCommentDateComment(@PathVariable("id") Integer id, @PathVariable("datecomment") @DateTimeFormat(pattern="yyyy-MM-dd") Date datecomment)
	{
		if(!commentsRepository.existsById(id)) {
            throw new ResourceNotFoundException("Bug not found with id " + id);
        }

        return commentsRepository.findById(id)
                .map(comment -> {
                	comment.setDateComment(datecomment);
                		commentsRepository.save(comment);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Bug not found with id " + id));
	}
	
}
