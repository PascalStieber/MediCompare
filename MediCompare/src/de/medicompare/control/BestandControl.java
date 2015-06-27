package de.medicompare.control;

import java.util.List;

import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;

import de.medicompare.entities.Bestand;

@Stateful
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class BestandControl {

	@PersistenceContext(type=PersistenceContextType.EXTENDED, unitName="MediCompare")
//	@PersistenceContext(type=PersistenceContextType.EXTENDED, unitName="ExampleDS")
	private EntityManager entityManager;

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public Bestand saveBestand(Bestand pBestand){ 
		entityManager.persist(pBestand);
		entityManager.flush();
		entityManager.refresh(pBestand);
		return pBestand;
	}
	
	public List<Bestand> findAllBestand(){
		entityManager.clear();
		TypedQuery<Bestand> query= entityManager.createNamedQuery("Bestand.findAll", Bestand.class);
		List<Bestand> lBestand = query.getResultList();
		return lBestand;
	}

	public List<Bestand> searchUserTermInBestand(String suchBegriff) {
		entityManager.clear();
		TypedQuery<Bestand> query= entityManager.createNamedQuery("Bestand.searchUserTerm", Bestand.class);
		query.setParameter("userTerm", suchBegriff);
		List<Bestand> lBestand = query.getResultList();
		return lBestand;
	}
}