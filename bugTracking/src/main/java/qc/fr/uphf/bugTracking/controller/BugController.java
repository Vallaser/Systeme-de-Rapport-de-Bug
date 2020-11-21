package qc.fr.uphf.bugTracking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import qc.fr.uphf.bugTracking.entities.Bug;
import qc.fr.uphf.bugTracking.repositories.BugRepository;

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
