package fr.diginamic.entites;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 * @author Salaheddine El Majdoub
 *
 */
public class Emprunt {

	/** id : id de l'Emprunt */
	@Id
	private Integer id;

	/** dateD : date de debut */
	@Column(name = "DATE_DEBUT")
	private Date dateD;

	/** dateF: date de fn */
	@Column(name = "DATE_FIN")
	private Date dateF;

	/** delai : delai de l'Emprunt */
	@Column(name = "DELAI")
	private Integer delai;

	/** client : le client qui "Emprunt" */
	@ManyToOne
	@JoinColumn(name = "ID_CLIENT")
	private Client client;

	// List<Livre> : listes des livres de l'emprunt */
	@ManyToMany
	@JoinTable(name = "compo", joinColumns = @JoinColumn(name = "ID_EMP", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "ID_LIV", referencedColumnName = "ID"))
	private List<Livre> livres;

	/** 
	 * Constructor
	 * 
	 */
	public Emprunt() {
		super();
	}

	/**constructeur
	 * @param id
	 * @param dateD
	 * @param dateF
	 * @param delai
	 * @param client
	 */
	public Emprunt(Integer id, Date dateD, Date dateF, Integer delai, Client client) {
		super();
		this.id = id;
		this.dateD = dateD;
		this.dateF = dateF;
		this.delai = delai;
		this.client = client;
	}

	/**Getter
	 * @return id de l'Emprunt
	 */
	public Integer getId() {
		return id;
	}

	/**Setter
	 * @param id de l'Emprunt
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**Getter
	 * @return date : date de debut de l'Emprunt
	 */
	public Date getDateD() {
		return dateD;
	}

	/**Setter
	 * @param dateD : date de debut de l'Emprunt
	 */
	public void setDateD(Date dateD) {
		this.dateD = dateD;
	}

	/**Getter
	 * @return dateF : date de fin de l'Emprunt
	 */
	public Date getDateF() {
		return dateF;
	}

	/**Setter
	 * @param dateF : date de fin de l'Emprunt
	 */
	public void setDateF(Date dateF) {
		this.dateF = dateF;
	}

	/**Getter
	 * @return delai : delai de l'Emprunt
	 */
	public Integer getDelai() {
		return delai;
	}

	/**Setter
	 * @param delai :  delai de l'Emprunt
	 */
	public void setDelai(Integer delai) {
		this.delai = delai;
	}

	/**Getter
	 * @return client : client qui Emprunt
	 */
	public Client getClient() {
		return client;
	}

	/**Setter
	 * @param client : client qui Emprunt
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "Emprunt [id=" + id + ", dateD=" + dateD + ", dateF=" + dateF + ", delai=" + delai + ", client=" + client
				+ ", livres=" + livres + "]";
	}	
}
