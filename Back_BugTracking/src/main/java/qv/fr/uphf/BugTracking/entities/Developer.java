package qv.fr.uphf.BugTracking.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * Developer est la classe representant un developpeur
 * 
 * @author Quentin Colras
 * @param id_developer L'identifiant unique du developpeur
 * @param name Le nom du developpeur
 * @param avatar Le chemin d'acces de l'image d'un developpeur
 * @param bugs La liste des bugs affecter au developpeur
 * @param comments La lites des commentaires qu'a poster le developpeur
 *
 */

@Getter //Lombok
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity //JPA
public class Developer {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) 
	private int id_developer;
	private String name;
	private String avatar;
	
	@OneToMany(mappedBy = "developer")
	@JsonManagedReference
	private List<Bug> bugs; //Liste des bugs affecter au developer/
	
	@OneToMany(mappedBy = "developer", cascade = {CascadeType.REMOVE})
	@JsonIgnore
	private List<Comment> comments; //Liste des commentaires qu'a poster le developpeur

}
