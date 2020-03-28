package banque;

import java.time.LocalDateTime;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**Entité Virement
 * @author Salaheddine El Majdoub
 *
 */
@Entity
@DiscriminatorValue("VIR")
public class Virement extends Operation {
	
	/** beneficiaire : : beneficiaire du virement*/
	private String beneficiaire;


	/**constructeur
	 * 
	 */
	public Virement() {
		super();
	}
	
	/**
	 * Constructor
	 *
	 * @param date
	 * @param montant
	 * @param modif
	 * @param compte
	 */
	public Virement(LocalDateTime date, Double montant, String motif, Compte compte, String beneficiaire) {
		super( date, montant, motif, compte);
		this.beneficiaire = beneficiaire;
	}

	@Override
	public String toString() {
		return super.toString() + "\n\t- Bénéficiaire : " + beneficiaire;
	}

}
