package de.medicompare.boundary;

import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@SessionScoped
@Stateful
@Named("einkauf")
public class Einkauf {
	
	
	public String getAdminLink(){
		return "/admin/index.xhtml?faces-redirect=true";
	}
	
	
}
