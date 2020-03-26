package fr.diginamic.entites;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**Represente la classe livre 
 * @author Salaheddine El Majdoub
 *
 */
@Entity
@Table(name = "livre") // optional

public class Livre {

	/** Integer : id du livre */
	/** id */
	@Id

	@Column(name = "id") // optional
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Integer id;

	/** String : titre du livre */
	private String titre;

	/** String : auteur du livre */
	private String auteur;

	/**constructeur
	 * @param id du livre 
	 * @param titre de livre
	 * @param auteur de livre
	 */
	public Livre(Integer id, String titre, String auteur) {
		super();

		this.id = id;
		this.titre = titre;
		this.auteur = auteur;

	}

	/**constructeur
	 * 
	 */
	public Livre() {
	}


	/**Getter
	 * @return id du livre
	 */
	public Integer getId() {
		return id;
	}
	
	/**Setter
	 * @param id du livre
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**Getter
	 * @return titre du livre
	 */
	public String getTitre() {
		return titre;
	}


	/**Setter
	 * @param titre du livre
	 */
	public void setTitre(String titre) {
		this.titre = titre;
	}

	/**Getter
	 * @return auteur de livre 
	 */
	public String getAuteur() {
		return auteur;
	}
	
	/**Setter
	 * @param auteur de livre 
	 */
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	
	@Override
	public String toString() {
		return "Livre [id=" + id + ", titre=" + titre + ", auteur=" + auteur + "]";

	}

}
