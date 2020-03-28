package banque;


import javax.persistence.Embeddable;

/**Classe Adresse herite de la classe client
 * @author Salaheddine El Majdoub
 *
 */
@Embeddable
public class Adresse {
	
	/** numero : numero de l'adresse*/
	private Integer numero; 
	/** rue : rue de l'adresse */
	private String rue;
	/** codePostal : codePostal de l'adresse */
	private Integer codePostal; 
	/** ville ; : ville de l'adresse */
	private String ville;
	

	/**constructeur
	 * 
	 */
	public Adresse() {
		super();
	}
	
	
	/**constructeur
	 * @param numero
	 * @param rue
	 * @param codePostal
	 * @param ville
	 */
	public Adresse(Integer numero, String rue, Integer codePostal, String ville) {
		super();
		this.numero = numero;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}
	

	public Integer getNumero() {
		return numero;
	}


	public void setNumero(Integer numero) {
		this.numero = numero;
	}


	public String getRue() {
		return rue;
	}


	public void setRue(String rue) {
		this.rue = rue;
	}


	public Integer getCodePostal() {
		return codePostal;
	}


	public void setCodePostal(Integer codePostal) {
		this.codePostal = codePostal;
	}


	public String getVille() {
		return ville;
	}


	public void setVille(String ville) {
		this.ville = ville;
	}


	@Override
	public String toString() {
		return "Adresse [numero=" + numero + ", rue=" + rue + ", codePostal=" + codePostal + ", ville=" + ville + "]";
	}

	
}
