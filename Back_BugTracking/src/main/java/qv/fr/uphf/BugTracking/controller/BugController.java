package qv.fr.uphf.BugTracking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import qv.fr.uphf.BugTracking.entities.Bug;
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
}
