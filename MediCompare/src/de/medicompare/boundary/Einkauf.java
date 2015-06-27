package de.medicompare.boundary;

import java.util.List;

import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import de.medicompare.control.BestandControl;
import de.medicompare.control.MedikamentControl;
import de.medicompare.entities.Bestand;
import de.medicompare.entities.Medikament;

@SessionScoped
@Stateful
@Named("einkauf")
public class Einkauf {
	
	@Inject
	MedikamentControl medikamentControl = null;
	@Inject
	BestandControl bestandControl = null;
	
	
	private List<Bestand> bestandsListe = null;
	private Medikament medikament = null;
	private String suchBegriff = "Suchbegriff...";
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
	
	public String getSuchBegriff() {
		return suchBegriff;
	}
	
	public void setSuchBegriff(String pSuchBegriff) {
		this.suchBegriff = pSuchBegriff;
	}

	public List<Bestand> getBestandsListe(){
		return this.bestandsListe;
	}
	
	
	public Medikament getMedikament() {
		return medikament;	
	}

	
	public void sucheMedikamente(){
		this.bestandsListe = bestandControl.searchUserTermInBestand(suchBegriff);
	}
	

	public void sucheOfferOfTheDay(){
		this.setOfferOfTheDay(medikamentControl.findOfferOfTheDay().get(0));
	}
	
	public String getAdminLink(){
		return "/faces/admin/index.xhtml?faces-redirect=true";
	}


	
	
}
