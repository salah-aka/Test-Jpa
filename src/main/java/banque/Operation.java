package banque;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Entité Opération
 * 
 * @author Salaheddine El Majdoub
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE")
@DiscriminatorValue("OP")
public class Operation extends BaseEntite {

	/** date : date de l'operation */
	private LocalDateTime date;
	/** montant : montant de l'operation */
	private Double montant;
	/** motif : : motif de l'operation */
	private String motif;

	/** Compte : compte lié à l'opération */
	@ManyToOne
	@JoinColumn(name = "COMPTE_ID")
	private Compte compte;

	/**
	 * Constructor
	 *
	 */
	public Operation() {
		super();
	}

	/**
	 * Constructor
	 *
	 * 
	 * @param date
	 * @param montant
	 * @param motif de l'operation
	 */
	public Operation(LocalDateTime date, Double montant, String motif, Compte compte) {
		super();
		this.date = date;
		this.montant = montant;
		this.motif = motif;
		this.compte = compte;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public Double getMontant() {
		return montant;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();

		builder.append("\n\t").append(this.getClass().getSimpleName()).append(" du ").append(date.toString())
				.append("\n\t- Montant : ").append(montant).append("€").append("\n\t- Motif : ").append(motif);

		return builder.toString();
	}


	
}
