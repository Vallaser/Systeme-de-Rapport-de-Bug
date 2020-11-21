/*package qc.fr.uphf.bugTracking.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class Commentaire {
	@Id @GeneratedValue(strategy=GenerationType.AUTO) 
	private int id;
	private int idBug;
	private int idDeveloper;
	private String commentaire;
	@Temporal(TemporalType.DATE)
	private Date dateCommentaire;
}
*/