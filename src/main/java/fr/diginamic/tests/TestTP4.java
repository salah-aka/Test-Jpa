package fr.diginamic.tests;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import banque.Adresse;
import banque.AssuranceVie;
import banque.Banque;
import banque.Client;
import banque.Compte;
import banque.LivretA;
import banque.Operation;
import banque.Virement;


/**
 * TP4(28/03/2020)
 * 
 * @author Salaheddine El Majdoub
 *
 */
public class TestTP4 {

	private static Logger LOGGER = Logger.getLogger(TestTP4.class.getName());

	/**
	 * @param args void
	 */
	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu_banque");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Banque banque1 = new Banque("Société générale");
		Banque banque2 = new Banque("LCL Banque");

		Client client1 = new Client("EL Majdoub", "Salaheddine", LocalDate.now(),
				new Adresse(5, "rue du bassin", 13000, "Marseille"), banque1);
		Client client2 = new Client("Souss", "Maissa", LocalDate.now(),
				new Adresse(6, "place jordan", 87000, "Limoges"), banque1);
		Client client3 = new Client("Bendkhil", "rayo", LocalDate.now(),
				new Adresse(6, "place de grenoble", 13000, "Marseille"), banque2);

		Compte compte1 = new Compte("compte1", Arrays.asList(client1));
		Compte compte2 = new Compte("compte2", Arrays.asList( client2));
		Compte compte3 = new Compte("compte3", Arrays.asList( client3));
		
		Compte livretA = new LivretA("compte3", Arrays.asList(client2), 1.0);
		Compte assuranceVie = new AssuranceVie("compte4", Arrays.asList(client1), LocalDate.now(), 2.0);
		Compte livretA1 = new LivretA("compte3", Arrays.asList(client3), 2.0);
		Compte assuranceVie1 = new AssuranceVie("compte4", Arrays.asList(client3), LocalDate.now(), 3.0);

		Operation ope1 = new Operation(LocalDateTime.now(), 200.0, "Credit", compte2);
		Operation ope2 = new Operation(LocalDateTime.now(), 100.0, "Debit", compte2);
		Operation virement = new Virement(LocalDateTime.now(), 500.0, "Debit", compte1, "Nadia");
		Operation ope3 = new Operation(LocalDateTime.now(), 500.0, "Credit", compte3);
		Operation ope4 = new Operation(LocalDateTime.now(), 600.0, "Debit", compte3);
		
		compte1.addOperation(virement);
		compte2.addOperation(ope1);
		compte2.addOperation(ope2);
		compte3.addOperation(ope3);
		compte3.addOperation(ope4);

		client2.addCompte(livretA);
		client1.addCompte(assuranceVie);
		client1.addCompte(compte1);
		client1.addCompte(compte2);
		client2.addCompte(compte2);
		
		client3.addCompte(livretA1);
		client3.addCompte(assuranceVie1);
		client3.addCompte(compte3);

		
		
		// La première transaction
		EntityTransaction t1 = entityManager.getTransaction();

		t1.begin();

		Arrays.asList(banque1, banque2, client1, client2, client3, compte1, compte2, compte3, livretA, assuranceVie, livretA1, assuranceVie1, ope1, ope2, ope3, ope4,virement)
				.forEach(entityManager::persist);

		t1.commit();

		TypedQuery<Client> query = entityManager.createQuery("Select cl FROM Client cl", Client.class);

		for (Client cl : query.getResultList()) {
			LOGGER.log(Level.INFO, cl.toString());
		}

		TypedQuery<Compte> query1 = entityManager.createQuery("Select c FROM Compte c", Compte.class);

		for (Compte c : query1.getResultList()) {
			LOGGER.log(Level.INFO, c.toString());
		}

		// insertions des nouvelles opérations
		Operation ope5 = new Operation(LocalDateTime.now(), 42.42, "Credit", livretA);
		Operation virement2 = new Virement(LocalDateTime.now(), 123334.789, "Anniversaire", assuranceVie, "Madame");

		livretA.addOperation(ope5);
		assuranceVie.addOperation(virement2);

		// Deuxième transavtion
		EntityTransaction t2 = entityManager.getTransaction();

		t2.begin();

		entityManager.persist(assuranceVie);
		entityManager.persist(livretA);
		entityManager.persist(assuranceVie1);
		entityManager.persist(livretA1);
		
		t2.commit();

		TypedQuery<Compte> query3 = entityManager.createQuery("Select c FROM Compte c", Compte.class);

		for (Compte c : query3.getResultList()) {
			LOGGER.log(Level.INFO, c.toString());
		}

		entityManager.close();

		entityManagerFactory.close();

	}

}
