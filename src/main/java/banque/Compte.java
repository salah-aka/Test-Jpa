package banque;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;


/**Entité Compte
 * @author Salaheddine El Majdoub
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Compte extends BaseEntite  {
	
	
	/** nom : nom de compte */
	private String  nom; 	
	
	
	/** operations : une liste des operations effectuées sur le compte */
	@OneToMany
	@JoinColumn(name = "compte")
	private List<Operation> operations;
	
	/**clients: une liste les clients qui peuvent accéder au compte */
	@ManyToMany(mappedBy = "comptes")
	private List<Client> clients;

	
	/**constructeur
	 * 
	 */
	public Compte() {
		super();
	}


	/**
	 * Constructor
	 *
	 * @param id      du compte
	 * @param nom     du compte
	 * @param clients pouvant accéder au compte
	 */
	public Compte(String nom, List<Client> clients) {
		super();
		this.nom = nom;
		this.clients = clients;
		this.operations = new ArrayList<>();
	}

	/**
	 * Ajoute une opération au compte
	 * 
	 * @param o : une operation à ajouter
	 */
	public void addOperation(Operation o) {
		operations.add(o);
	}

	/**
	 * Getter
	 * @return nom: nom de compte
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Getter
	 * @return la liste des clients
	 */
	public List<Client> getClients() {
		return clients;
	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();

		builder.append(this.getClass().getSimpleName()).append(" ").append(nom).append("\n\t- propriétaire(s) : ");
		clients.stream().map(c -> c.getId()).forEach(i -> builder.append("client ").append(i).append(", "));
		builder.append("\n\t - Operations : ");
		operations.stream().forEach(o -> builder.append(o));

		return builder.toString();
	}

}

