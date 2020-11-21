/*package qc.fr.uphf.bugTracking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import qc.fr.uphf.bugTracking.entities.Bug;
import qc.fr.uphf.bugTracking.repositories.BugRepository;

public class BugController {

	@Autowired
	BugRepository bugRepository;
	
	@GetMapping("bugs")
	public List<Bug> getBugs()
	{
		return bugRepository.findAll();
	}
}*/
