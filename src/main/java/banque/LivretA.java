package banque;

import java.util.List;

import javax.persistence.Entity;

/**Entité LivretA
 * @author Salaheddine El Majdoub
 *
 */

@Entity
public class LivretA extends Compte {
	
	/** taux  de livretA*/
	private Double taux;

	/**constructeur
	 * 
	 */
	public LivretA() {
		super();
	}
	
	/**
	 * Constructor
	 *
	 * @param nom
	 * @param clients
	 */
	public LivretA(String nom, List<Client> clients, Double taux) {
		super(nom, clients);
		this.taux = taux;
	}


	public Double getTaux() {
		return taux;
	}

	public void setTaux(Double taux) {
		this.taux = taux;
	}
	
	@Override
	public String toString() {
		return super.toString() + "\n\t- Taux : " + taux;
	}


}
