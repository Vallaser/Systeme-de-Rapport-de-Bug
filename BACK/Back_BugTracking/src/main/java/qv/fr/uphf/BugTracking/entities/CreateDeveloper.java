package qv.fr.uphf.BugTracking.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * 
 * CreateDeveloper est la classe permettant de créer une entity de la classe Developer
 * @author Quentin Colras
 * @param name Le nom du developpeur
 * @param avatar Le chemin d'acces de l'image d'un developpeur
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateDeveloper {
	
	private String name;
	private String avatar;

}

