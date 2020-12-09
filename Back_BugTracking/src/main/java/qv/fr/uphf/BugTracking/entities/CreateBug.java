package qv.fr.uphf.BugTracking.entities;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateBug {

	private String title;
	private String description;
	private String priority;
	private String etat;
	private Date dateCreation;
	private Integer id_developer;
	private List<Comment> comments; //Liste des commentaires du bug
}
