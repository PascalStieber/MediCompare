package de.medicompare.control;

import java.util.List;

import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;

import de.medicompare.entities.GesamtBestellung;
import de.medicompare.entities.Medikament;
import de.medicompare.entities.Person;

@Stateful
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class GesamtBestellungControl {

//	@PersistenceContext(type=PersistenceContextType.EXTENDED, unitName="MediCompare")
	@PersistenceContext(type=PersistenceContextType.EXTENDED, unitName="ExampleDS")
	private EntityManager entityManager;

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public GesamtBestellung saveGesamtBestellung(GesamtBestellung pGesamtBestellung){ 
		entityManager.persist(pGesamtBestellung);
		entityManager.flush();
		entityManager.refresh(pGesamtBestellung);
		return pGesamtBestellung;
	}
	
	public List<GesamtBestellung> findAllGesamtBestellung(){
		entityManager.clear();
		TypedQuery<GesamtBestellung> query= entityManager.createNamedQuery("GesamtBestellung.findAll", GesamtBestellung.class);

		List<GesamtBestellung> lGesamtBestellung = query.getResultList();
		return lGesamtBestellung;
	}
}