package fr.diginamic.entites;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "client")
public class Client {

	/** id : id du client */
	@Id
	private Integer id;

	/** nom : nom du client */
	@Column(name = "NOM")
	private String nom;

	/** prenom : prenom du client */
	@Column(name = "PRENOM")
	private String prenom;

	public Client() {
		super();
	}

	/**
	 * constructeur
	 * 
	 * @param id     du client
	 * @param nom    du client
	 * @param prenom du client
	 */
	public Client(Integer id, String nom, String prenom) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
	}

//	@OneToMany(mappedBy = "client")
//	private Set<Emprunt> emprunts;
//
//	public Client() {
//		emprunts = new HashSet<Emprunt>();
//	}
	
	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + "]";

	}
}
