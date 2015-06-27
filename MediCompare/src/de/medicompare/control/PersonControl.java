package de.medicompare.control;

import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.enterprise.context.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import de.medicompare.entities.Person;

@Stateful
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class PersonControl {

	@PersistenceContext(type=PersistenceContextType.EXTENDED, unitName="MediCompare")
//	@PersistenceContext(type=PersistenceContextType.EXTENDED, unitName="ExampleDS")
	private EntityManager entityManager;

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public Person savePerson(Person pPerson){ 
		entityManager.persist(pPerson);
		entityManager.flush();
		entityManager.refresh(pPerson);
		return pPerson;
	}
}