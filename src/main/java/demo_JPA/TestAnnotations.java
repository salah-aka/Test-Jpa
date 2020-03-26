package demo_JPA;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.diginamic.entites.Emprunt;

public class TestAnnotations {

	private static Logger LOGGER = Logger.getLogger(TestAnnotations.class.getName());

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu_biblio");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Emprunt emprunt = entityManager.find(Emprunt.class, 1);

		LOGGER.log(Level.INFO, "Emprunt id(1) : {0}", emprunt);

		TypedQuery<Emprunt> query = entityManager.createQuery(
			"SELECT em FROM Emprunt em INNER JOIN Client cl ON cl.id = em.client WHERE cl.id = 1", Emprunt.class);

		List<Emprunt> empruntsClient = query.getResultList();

		for (Emprunt em : empruntsClient) {
			LOGGER.log(Level.INFO, "Emprunts du Client id(1) : {0}", em);
		}

		entityManager.close();
		entityManagerFactory.close();
	}

}
