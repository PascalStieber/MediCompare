package de.medicompare.boundary;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import javax.inject.Inject;
import javax.inject.Named;

import com.sun.prism.Image;

import de.medicompare.control.GesamtBestellungControl;
import de.medicompare.control.MedikamentControl;
import de.medicompare.entities.Medikament;
import de.medicompare.entities.Person;

@SessionScoped
@Stateful 
@Named("administration")
public class Administration {
	
	@Inject
	private MedikamentControl medikamentControl;
	@Inject
	private GesamtBestellungControl gesamtBestellungControl;
	
	private Medikament medikament = new Medikament() ;
	private List<Medikament> medikamentenListe = null;
	private List<Person> personen = null;
	
	
	
	@PostConstruct
	public void init(){
		getAllMedikamente();
	}
	
	public List<Person> getPersonen(){
		return this.personen;
	}
	
	public Medikament getMedikament(){
		return this.medikament;
	}
	
	public List<Medikament> getMedikamentenListe(){
		return this.medikamentenListe;
	}
	
	public List<Medikament> getAllMedikamente(){
		this.medikamentenListe = medikamentControl.findAllMedikamente();
		return medikamentenListe;
	}
	
	public String speicherMedikament(){
		medikamentControl.saveMedikament(this.medikament);
		medikament = new Medikament();
		getAllMedikamente();
		return "index.xhtml?faces-redirect=true";
	}
	
	public String editMedikament(Medikament pMedikament) {
		pMedikament.setEditable(true);
		return null;
	}
	public String loescheMedikament(Medikament pMedikament) {
		medikamentControl.deleteMedikament(pMedikament);
		getAllMedikamente();
		return null;
	}
	public String speicherMedikament(Medikament pMedikament){
		pMedikament.setEditable(false);
		medikamentControl.updateMedikament(pMedikament);
		getAllMedikamente();
		return "index.xhtml?faces-redirect=true";
	}
	
		
	public Person getPersonenFromMedikament(Medikament pMedikament){		
//		this.medikament = gesamtBestellungControl.findAllGesamtBestellung().get(0).getMedikament();		
//		return gesamtBestellungControl.findAllGesamtBestellung().get(0).getPerson();
		return null;
	}
	
	public void rufeEinMedikament(){
		medikamentControl.findMedikamentByID(3L);
	}
	
}
