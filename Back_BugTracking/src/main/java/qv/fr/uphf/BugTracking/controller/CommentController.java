package qv.fr.uphf.BugTracking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import qv.fr.uphf.BugTracking.entities.Comment;
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
}
