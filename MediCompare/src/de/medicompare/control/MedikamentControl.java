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

@Stateful
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class MedikamentControl {
	
	@PersistenceContext(type = PersistenceContextType.EXTENDED, unitName="MediCompare")
//	@PersistenceContext(type=PersistenceContextType.EXTENDED, unitName="ExampleDS")
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
	
	public Medikament findMedikamentByID(Long pId){
		//der Tatsache geschuldet, dass ein byte[] scheinbar trotz abschalten des 2nd level und query caches
		//gecached (wahrscheinlich sogar im 1st level cache) wird, muss das object komplett vom @persistenceContext
		//getrennt und somit neu geladen werden
		//@Edit:
		//es reicht die refresh Methode für das Objekt aufzurufen
//		entityManager.clear();
		
		Medikament lMedikament = entityManager.find(Medikament.class, pId);
		entityManager.refresh(lMedikament);
		return lMedikament;
	}
	
	public List<Medikament> findMedikamentByIDWithNamedQuery(Long pId){
		entityManager.clear();
		TypedQuery<Medikament> query= entityManager.createNamedQuery("Medikament.findByID", Medikament.class);
		query.setParameter("id", pId);
		List<Medikament> lMedikament = query.getResultList();
		return lMedikament;
	}
	
	public List<Medikament> findAllMedikamente(){
		//Entweder alle Objekte am PersistenceContext detachen...
		entityManager.clear();
		TypedQuery<Medikament> query= entityManager.createNamedQuery("Medikament.findAll", Medikament.class);
		//geht auch...
//		Query query = entityManager.createQuery("SELECT m FROM Medikament m");
		
		
		//Die Queries müssen von Hand auf Cacheable gesetzt werden, wenn 'hints' in der Entity an NamedQuery fehlt
//		query.setHint("org.hibernate.cacheable", true);
		List<Medikament> lMedikamentListe = query.getResultList();
		
		//oder alle Objekte refreshen.
//		for (Medikament lMedikament : lMedikamentListe) {
//			entityManager.refresh(lMedikament);
//		}
		
	
		return lMedikamentListe;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void deleteMedikament(Medikament pMedikament) {
//		Medikament foundMedikament = entityManager.find(Medikament.class, pMedikament.getId());
//		entityManager.remove(foundMedikament);
		entityManager.remove(entityManager.contains(pMedikament) ? pMedikament : entityManager.merge(pMedikament));
		entityManager.flush();		
	}
	
	
	public List<Medikament> findOfferOfTheDay(){
		TypedQuery<Medikament> query= entityManager.createNamedQuery("Medikament.findOfferOfTheDay", Medikament.class);
		List<Medikament> lMedikamentListe = query.getResultList();
		return lMedikamentListe ;
	}

	
}
