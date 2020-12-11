package qv.fr.uphf.BugTracking.entities;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * CreateComment est la classe permettant de créer une entity de la classe Comment
 * 
 * @author Quentin Colras
 * @param comment Le contenu du commentaire
 * @param dateComment La date de creation ou de modification du commentaire
 * @param bug_id L'identifiant du bug auquel appartient le commentaire
 * @param developer_id L'identifiant du developpeur qui a poste le commentaire
 *
 */

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
