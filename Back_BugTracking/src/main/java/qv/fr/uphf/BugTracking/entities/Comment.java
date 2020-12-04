package qv.fr.uphf.BugTracking.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	private String comment;
	@Temporal(TemporalType.DATE)
	private Date dateComment;
	
	@ManyToOne
	@JoinColumn(name = "id_bug")
	private Bug bug;
	@ManyToOne
	@JoinColumn(name = "id_developer")
	private Developer developer;
}
