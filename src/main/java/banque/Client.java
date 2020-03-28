package banque;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entité Client
 * 
 * @author Salaheddine El Majdoub
 *
 */
@Entity
@Table(name = "client")
public class Client extends BaseEntite {

	/** nom : nom du client */
	private String nom;

	/** prenom : prenom du client */
	private String prenom;

	/** dateNaissance : date de naissance du client */
	private LocalDate dateNaissance;

	/** Adresse : adresse du client */
	@Embedded
	private Adresse adresse;

	/** banque : banque d'un client */
	@ManyToOne
	@JoinColumn(name = "BANQUE_ID")
	private Banque banque;

	/** comptes : liste des comptes du client */
	@ManyToMany
	@JoinTable(name = "client_compte", joinColumns = @JoinColumn(name = "CLIENT_ID", referencedColumnName = "ID"), 
	inverseJoinColumns = @JoinColumn(name = "COMPTE_ID", referencedColumnName = "ID"))
	private List<Compte> comptes;

	/**
	 * constructeur
	 * 
	 */
	public Client() {
		super();
	}

	/**
	 * Constructor
	 *
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param dateNaissance
	 * @param adresse
	 */
	public Client(String nom, String prenom, LocalDate dateNaissance, Adresse adresse, Banque banque) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.adresse = adresse;
		this.banque = banque;
		this.comptes = new ArrayList<>();
	}

	/**
	 * Methode pour ajouter un compte
	 * 
	 * @param c un compte
	 */
	public void addCompte(Compte c) {
		comptes.add(c);
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public List<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}



	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();

		builder.append("Client ").append(id).append(" ").append(nom).append(" ").append(prenom)
				.append(" \n\t- Banque : ").append(banque.getNom()).append("\n\t- Compte(s) : ");
		
		comptes.stream().map(c -> c.getId()).forEach(a -> builder.append(a).append(", "));
		return builder.toString();
	}
	

}
