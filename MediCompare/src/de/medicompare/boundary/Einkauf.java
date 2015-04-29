package de.medicompare.boundary;

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
@Named("einkauf")
public class Einkauf {
	
	@Inject
	private MedikamentControl medikamentControl;
	@Inject
	private PersonControl personControl;
	
	private Medikament medikament = new Medikament() ;
	
	
//	@PostConstruct
	public void init(){
		Person person = new Person();		
		person.setVorname("Pascal");
		person.setNachname("Stieber");
		person.setEmailAdresse("pascal.stieber.ps@googlemail.com");
		person.setPasswort("hallowelt");
		personControl.savePerson(person);
	}
	
	
	public Medikament getMedikament(){
		return this.medikament;
	}
	
	public String speicherMedikament(){
		medikamentControl.saveMedikament(this.medikament);
		medikament = new Medikament();
		return "index.xhtml?faces-redirect=true";
	}
	
	
	public String getEinkaufsliste(){	
		return "leer";
	}
	
	public String getAdminLink(){
		return "/admin/index.xhtml?faces-redirect=true";
	}
}
