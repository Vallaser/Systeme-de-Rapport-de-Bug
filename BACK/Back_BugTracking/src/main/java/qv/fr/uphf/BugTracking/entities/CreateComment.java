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
	
	private String comment;
	private Date dateComment;
	private Integer bug_id;
	private Integer developer_id;
	
}
