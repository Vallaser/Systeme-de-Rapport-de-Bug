package qv.fr.uphf.BugTracking.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
	
	@OneToMany(mappedBy = "developer")
	private List<Comment> comments;
	@OneToMany(mappedBy = "developer")
	private List<Bug> bugs;	

}
