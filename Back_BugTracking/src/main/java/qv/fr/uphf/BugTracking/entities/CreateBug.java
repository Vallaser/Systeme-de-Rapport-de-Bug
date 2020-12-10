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
public class CreateBug {

	private String title;
	private String description;
	private String priority;
	private String etat;
	private Date dateCreation;
	private Integer developer_id;
}
