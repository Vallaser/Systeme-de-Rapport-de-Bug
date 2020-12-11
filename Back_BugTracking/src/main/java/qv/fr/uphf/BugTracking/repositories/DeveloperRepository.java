package qv.fr.uphf.BugTracking.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import qv.fr.uphf.BugTracking.entities.Developer;

/**
 * DeveloperRepository la classe qui interagit avec la base de donnees pour l'entity Comment
 * @author Quentin Colras
 */
public interface DeveloperRepository extends JpaRepository<Developer, Integer>{
	Optional<Developer> findById(Integer id);
	List<Developer> findAll();
}
