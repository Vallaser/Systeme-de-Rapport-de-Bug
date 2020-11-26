package qc.fr.uphf.bugTracking.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import qc.fr.uphf.bugTracking.entities.Bug;

public interface BugRepository extends JpaRepository<Bug, Integer>{
	Optional<Bug> findById(Integer id);
}
