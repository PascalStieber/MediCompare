package de.medicompare.boundary;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import de.medicompare.control.MedikamentControl;
import de.medicompare.control.PersonControl;
import de.medicompare.entities.Medikament;
import de.medicompare.entities.Person;

@SessionScoped
@Stateful 
@Named("administration")
public class Administration {
	
	@Inject
	private PersonControl personControl;
	@Inject
	private MedikamentControl medikamentControl;
		
	private Medikament medikament = new Medikament() ;
	private List<Medikament> medikamentenListe = null;
	
	@PostConstruct
	public void init(){
		Person person = new Person();		
		person.setVorname("Pascal");
		person.setNachname("Stieber");
		person.setEmailAdresse("pascal.stieber.ps@googlemail.com");
		person.setPasswort("hallowelt");
		personControl.savePerson(person);
		
		Person partner = new Person();		
		person.setVorname("Tim");
		person.setNachname("Foerster");
		person.setEmailAdresse("foerster@dailytrade24.de");
		person.setPasswort("hallowelt");
		personControl.savePerson(partner);
		
		getAllMedikamente();
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
		getAllMedikamente();
		medikamentControl.saveMedikament(this.medikament);
		medikament = new Medikament();
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
		return "index.xhtml?faces-redirect=true";
	}
}
