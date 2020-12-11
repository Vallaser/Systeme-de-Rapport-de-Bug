package qv.fr.uphf.BugTracking.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
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

/**
 * 
 * Bug est la classe représentant un bug
 * 
 * @author Quentin Colras
 * @param id_bug L'identifiant unique du bug
 * @param title Le titre du bug
 * @param description La description générale du bug
 * @param priority La priorité du bug : [HAUTE, MOYENNE, BASSE]
 * @param etat L'état d'avancement du bug : [TO_DO, IN_PROGRESS, DONE]
 * @param dateCreation La date de création du bug
 * @param developer Le developer auquel est assigné le bug
 * @param comments Liste des commentaires du bug
 *
 */

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
	@JoinColumn(name = "id_developer", nullable = true)
	private Developer developer;
	
	@OneToMany(mappedBy = "bug" , cascade = {CascadeType.REMOVE})
	@JsonManagedReference
	private List<Comment> comments; //Liste des commentaires du bug*/
	
	
	public Developer getDeveloper()
	{
		return this.developer;
	}
	
}
