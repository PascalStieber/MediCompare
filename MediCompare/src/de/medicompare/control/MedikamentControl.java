package de.medicompare.control;

import java.util.List;

import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;

import de.medicompare.entities.Medikament;

//@Stateless
@Stateful
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class MedikamentControl {
	
	@PersistenceContext(type=PersistenceContextType.EXTENDED, unitName="MediCompare")
//	@PersistenceContext
	private EntityManager entityManager;

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public Medikament saveMedikament(Medikament pMedikament){ 
		entityManager.persist(pMedikament);
		entityManager.flush();
		entityManager.refresh(pMedikament);
		return pMedikament;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public Medikament updateMedikament(Medikament pMedikament){
		entityManager.merge(pMedikament);
		entityManager.flush();
		entityManager.refresh(pMedikament);
		return pMedikament;
	}
	
	
	public List<Medikament> findMedikamentByID(Long pId){
		TypedQuery<Medikament> query= entityManager.createNamedQuery("Medikament.findByID", Medikament.class);
		query.setParameter("id", pId);
		List<Medikament> lMedikament = query.getResultList();
		
//		Query query = entityManager.createNamedQuery("SELECT m FROM Medikament m");
//		List<Medikament> lMedikament = query.getResultList();
		
		return lMedikament;
	}
	
	public List<Medikament> findAllMedikamente(){
		TypedQuery<Medikament> query= entityManager.createNamedQuery("Medikament.findAll", Medikament.class);
		List<Medikament> lMedikament = query.getResultList();
		return lMedikament;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void deleteMedikament(Medikament pMedikament) {
		entityManager.remove(pMedikament);
		entityManager.flush();
		entityManager.refresh(pMedikament);
		
	}
	
	
}
