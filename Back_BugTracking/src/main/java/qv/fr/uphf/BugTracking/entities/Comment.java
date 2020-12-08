package qv.fr.uphf.BugTracking.entities;

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
public class Comment {
	@Id @GeneratedValue(strategy=GenerationType.AUTO) 
	private int id_comment;
	private int id_bug;
	private String comment;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateComment;
	private int id_developer;
	
}
