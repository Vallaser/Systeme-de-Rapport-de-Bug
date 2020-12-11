package qv.fr.uphf.BugTracking.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import qv.fr.uphf.BugTracking.entities.Bug;

/**
 * BugRepository la classe qui interagit avec la base de donnees pour l'entity Bug
 * @author Quentin Colras
 */
public interface BugRepository extends JpaRepository<Bug, Integer>{
	Optional<Bug> findById(Integer id);
	List<Bug> findAll();
	List<Bug> findByEtat(String etat);
}

