package qv.fr.uphf.BugTracking.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import qv.fr.uphf.BugTracking.entities.Bug;

public interface BugRepository extends JpaRepository<Bug, Integer>{
	Optional<Bug> findById(Integer id);
	List<Bug> findAll();
	
	@Modifying
	@Query("update Bug bug set bug.title = ?1 where bug.id_bug = ?2")
	void setBugTitleById(String titre, Integer id);
	
	/*@Modifying
	@Query("update User u set u.firstname = ?1, u.lastname = ?2 where u.id = ?3")
	void setUserInfoById(String firstname, String lastname, Integer userId);*/
}

