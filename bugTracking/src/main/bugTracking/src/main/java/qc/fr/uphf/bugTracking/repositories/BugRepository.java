package qc.fr.uphf.bugTracking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import qc.fr.uphf.bugTracking.entities.Bug;

public interface BugRepository extends JpaRepository<Integer, Bug>{

}
