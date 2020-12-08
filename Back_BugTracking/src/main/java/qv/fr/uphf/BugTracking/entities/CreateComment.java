package qv.fr.uphf.BugTracking.entities;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateComment {
	
	private int id_bug;
	private String comment;
	private Date dateComment;
	private int id_developer;

}
