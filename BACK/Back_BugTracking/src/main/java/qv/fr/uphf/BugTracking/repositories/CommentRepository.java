package qv.fr.uphf.BugTracking.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import qv.fr.uphf.BugTracking.entities.Comment;

/**
 * CommentRepository la classe qui interagit avec la base de donnees pour l'entity Comment
 * @author Quentin Colras
 */
public interface CommentRepository extends JpaRepository<Comment, Integer>{
	Optional<Comment> findById(Integer id);
	List<Comment> findAll();
}
