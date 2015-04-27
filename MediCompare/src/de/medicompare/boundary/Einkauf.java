package de.medicompare.boundary;

import javax.ejb.Stateful;
import javax.inject.Named;

import de.medicompare.entities.Medikament;

@Stateful
@Named("einkauf")
public class Einkauf {

	private Medikament medikament;
	
	public Medikament getMedikament(){
		return this.medikament;
	}
	
	public String getAdminLink(){
		return "/admin/index.xhtml?faces-redirect=true";
	}
	
	public String getEinkaufsliste(){	
		return "leer";
	}
}
