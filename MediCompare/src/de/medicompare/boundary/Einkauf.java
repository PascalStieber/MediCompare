package de.medicompare.boundary;

import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.inject.Named;

import de.medicompare.control.MedikamentControl;
import de.medicompare.entities.Medikament;

@Stateful
@Named("einkauf")
public class Einkauf {
	
	@Inject
	private MedikamentControl medikamentControl; 
	private Medikament medikament;
	
	public Medikament getMedikament(){
		return this.medikament;
	}
	
	public void speicherMedikament(){
		medikamentControl.saveMedikament(this.medikament);
	}
	
	
	public String getEinkaufsliste(){	
		return "leer";
	}
	
	public String getAdminLink(){
		return "/admin/index.xhtml?faces-redirect=true";
	}
}
