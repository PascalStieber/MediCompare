package de.medicompare.control;

import java.util.List;

import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;

import de.medicompare.entities.ShopAnbieter;

@Stateful
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class ShopAnbieterControl {

//	@PersistenceContext(type=PersistenceContextType.EXTENDED, unitName="MediCompare")
	@PersistenceContext(type=PersistenceContextType.EXTENDED, unitName="ExampleDS")
	private EntityManager entityManager;

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public ShopAnbieter saveShopAnbieter(ShopAnbieter pShopAnbieter){ 
		entityManager.persist(pShopAnbieter);
		entityManager.flush();
		entityManager.refresh(pShopAnbieter);
		return pShopAnbieter;
	}
	
	public List<ShopAnbieter> findAllShopAnbieter(){
		entityManager.clear();
		TypedQuery<ShopAnbieter> query= entityManager.createNamedQuery("ShopAnbieter.findAll", ShopAnbieter.class);
		List<ShopAnbieter> lShopAnbieter = query.getResultList();
		return lShopAnbieter;
	}
}