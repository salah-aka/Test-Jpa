package fr.diginamic.entites;

import java.util.List;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Represente la classe livre
 * 
 * @author Salaheddine El Majdoub
 *
 */
@Entity
@Table(name = "livre") // optional

public class Livre {

	/** Integer : id du livre */
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/** String : titre du livre */
	private String titre;

	/** String : auteur du livre */
	private String auteur;

	@ManyToMany(mappedBy = "livres")
	/** List<Emprunt> : emprunts */
	private List<Emprunt> emprunts;

	
	/**constructeur
	 * @param id
	 * @param titre
	 * @param auteur
	 * @param emprunts
	 */
	public Livre(Integer id, String titre, String auteur, List<Emprunt> emprunts) {
			super();
			this.id = id;
			this.titre = titre;
			this.auteur = auteur;
			this.emprunts = emprunts;
		}	
	/**
	 * Getter
	 * 
	 * @return id du livre
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Setter
	 * @param id du livre
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Getter
	 * @return titre du livre
	 */
	public String getTitre() {
		return titre;
	}

	/**
	 * Setter
	 * @param titre du livre
	 */
	public void setTitre(String titre) {
		this.titre = titre;
	}

	/**
	 * Getter
	 * @return auteur du livre
	 */
	public String getAuteur() {
		return auteur;
	}

	/**
	 * Setter
	 * @param auteur du livre
	 */
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	/**Getter
	 * @return emprunts
	 */
	public List<Emprunt> getEmprunts() {
		return emprunts;
	}

	/**Setter
	 * @param emprunts
	 */
	public void setEmprunts(List<Emprunt> emprunts) {
		this.emprunts = emprunts;
	}

	@Override
	public String toString() {
		return "Livre [id=" + id + ", titre=" + titre + ", auteur=" + auteur + "]";

	}
}
