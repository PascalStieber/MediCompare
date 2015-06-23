package de.medicompare.boundary;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import de.medicompare.control.MedikamentControl;
import de.medicompare.entities.Medikament;

@SessionScoped
@Stateful
@Named("einkauf")
public class Einkauf {
	
	@Inject
	MedikamentControl medikamentControl = null;
	
	
	
	private List<Medikament> medikamentenListe = null;
	private Medikament medikament = null;
	private Long suchBegriff = 0L;
	private Medikament offerOfTheDay = null;
	
	
	
	
	public Medikament getOfferOfTheDay() {
		List<Medikament> offerOfTheDayList = medikamentControl.findOfferOfTheDay(); 
		for (Medikament lMedikament : offerOfTheDayList) {
			offerOfTheDay = lMedikament;
		}
		
		return offerOfTheDay;
	}	

	public void setOfferOfTheDay(Medikament offerOfTheDay) {
		this.offerOfTheDay = offerOfTheDay;
	}
	
	public Long getSuchBegriff() {
		return suchBegriff;
	}
	
	public void setSuchBegriff(Long pSuchBegriff) {
		this.suchBegriff = pSuchBegriff;
	}

	public List<Medikament> getMedikamentenListe(){
		return this.medikamentenListe;
	}
	
	
	public Medikament getMedikament() {
		return medikament;	
	}

	
	
	public void sucheMedikamente(){
		this.medikament = medikamentControl.findMedikamentByID(suchBegriff);
	}
	

	public void sucheOfferOfTheDay(){
		this.setOfferOfTheDay(medikamentControl.findOfferOfTheDay().get(0));
	}
	
	public String getAdminLink(){
		return "/faces/admin/index.xhtml?faces-redirect=true";
	}


	
	
}
