package qv.fr.uphf.BugTracking.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
public class Bug {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_bug;
	private String title;
	private String description;
	private String priority;
	private String etat;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreation;
	
	@Column(nullable = true)
	private Integer id_developer;
	
	@OneToMany//(mappedBy = "bug")
	@JoinColumn(name = "id_bug")
	private List<Comment> comments; //Liste des commentaires du bug
}
