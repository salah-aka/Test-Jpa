package demo_JPA;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.diginamic.entites.Livre;

public class TestLivre {

	private static Logger LOGGER = Logger.getLogger(TestLivre.class.getName());

public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu_biblio");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		// find simple permettant d’extraire un livre en fonction de son id. 
		Livre l = entityManager.find(Livre.class, 1);

		LOGGER.log(Level.INFO, "Find livre id(1) : {0}", l);

		// selection d'un livre en fonction de son titre
		TypedQuery<Livre> query = entityManager.createQuery("SELECT l FROM Livre l WHERE l.titre = 'Guerre et Paix'", Livre.class);

			Livre l1 = query.getSingleResult();

			System.out.println(l1);

			entityManager.close();
			entityManagerFactory.close();
		}
	}