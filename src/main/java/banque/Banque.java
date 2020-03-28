package banque;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**Entité Banque (la classe Banque hérite de la classe Client)
 * @author Salaheddine El Majdoub
 *
 */
@Entity
public class Banque extends BaseEntite {
	
	
	/** nom : nom de la banque*/
	private String nom;
	
	/**
	 * Constructor
	 *
	 */
	public Banque() {
		super();
	}

	/**
	 * Constructor
	 *
	 * @param nom du banque
	 */
	public Banque(String nom) {
		super();
		this.nom = nom;
	}
	
	@OneToMany(mappedBy="banque") 
	private List<Client> clients;
	

	/**Getter
	 * @return Nom de la banque
	 */
	public String getNom() {
		return nom;
	}

	/**Setter
	 * @param nom de la banque
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Banque [nom=" + nom + "]";
	}
	
}
