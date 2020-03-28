package banque;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;

/**Entité AssuranceVie
 * @author Salaheddine El Majdoub
 *
 */
@Entity
public class AssuranceVie extends Compte{
	
	/** dateFin : date de fin de l'assurance d'un compte */
	private LocalDate dateFin;
	/** taux : taux de l'AssuranceVie */
	private Double taux;

	/**constructeur
	 * 
	 */
	public AssuranceVie() {
		super();
	}
	
	/**constructeur
	 * @param nom nom de compte
	 * @param clients liste des clients
	 * @param dateFin de l'assurance
	 * @param taux
	 */
	public AssuranceVie(String nom, List<Client> clients, LocalDate dateFin, Double taux) {
		super(nom, clients);
		this.dateFin = dateFin;
		this.taux = taux;
	}

	
	/**Getter
	 * @return date de fin d'assurance
	 */
	public LocalDate getDateFin() {
		return dateFin;
	}

	/**Setter
	 * @param dateFin : date de fin d'assurance
	 */
	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	/**Getter
	 * @return taux de l'assurance de vie
	 */
	public Double getTaux() {
		return taux;
	}

	/**Setter
	 * @param taux : taux de l'assurance de vie
	 */
	public void setTaux(Double taux) {
		this.taux = taux;
	}
	
	@Override
	public String toString() {
		return super.toString() + "\n\t- Date de fin : " + dateFin.toString() + "\n\t- Taux : " + taux;
	}	
}
