package de.medicompare.control;

import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.enterprise.context.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import de.medicompare.entities.Medikament;

@Stateful
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class MedikamentControl {
	
	@PersistenceContext(type=PersistenceContextType.EXTENDED, unitName="MediCompare")
	private EntityManager entityManager;

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public Medikament saveMedikament(Medikament pMedikament){ 
		entityManager.persist(pMedikament);
		entityManager.flush();
		entityManager.refresh(pMedikament);
		return pMedikament;
	}
}
