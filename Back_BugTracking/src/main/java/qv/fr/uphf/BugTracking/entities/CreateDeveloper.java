package qv.fr.uphf.BugTracking.entities;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateDeveloper {
	
	private String name;
	private String avatar; //à définir
	private List<Bug> bugs; //Liste des bugs affecter au developer/

}
