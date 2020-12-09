package qv.fr.uphf.BugTracking.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter //Lombok
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity //JPA
public class Developer {
	@Id @GeneratedValue(strategy=GenerationType.AUTO) 
	private int id_developer;
	private String name;
	private String avatar; //à définir
	
	@OneToMany
	@JoinColumn(name = "id_developer")
	//@JsonManagedReference
	private List<Bug> bugs; //Liste des bugs affecter au developer/

}
