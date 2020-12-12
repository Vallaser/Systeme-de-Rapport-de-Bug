package qv.fr.uphf.BugTracking.entities;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * CreateBug est la classe permettant de créer une entity de la classe Bug
 * 
 * @author Quentin Colras
 * @param title Le titre du bug
 * @param description La description generale du bug
 * @param priority La priorite du bug : [HAUTE, MOYENNE, BASSE]
 * @param etat L'etat d'avancement du bug : [TO_DO, IN_PROGRESS, DONE]
 * @param dateCreation La date de creation du bug
 * @param developer_id L'identifiant du developer auquel est assigne le bug
 *
 */

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
