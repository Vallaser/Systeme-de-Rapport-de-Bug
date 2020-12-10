package qv.fr.uphf.BugTracking.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
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
public class Bug {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_bug;
	private String title;
	private String description;
	private String priority;
	private String etat;
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "YYYY:MM:dd")
	private Date dateCreation;
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "id_developer")
	private Developer developer;
	
	@OneToMany(mappedBy = "bug")
	@JsonManagedReference
	private List<Comment> comments; //Liste des commentaires du bug*/
	
	public Developer getDeveloper()
	{
		return this.developer;
	}
	
}
