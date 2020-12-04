package qv.fr.uphf.BugTracking.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import qv.fr.uphf.BugTracking.entities.Bug;

public interface BugRepository extends JpaRepository<Bug, Integer>{
	Optional<Bug> findById(Integer id);
}
