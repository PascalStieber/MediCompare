package de.medicompare.boundary;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import de.medicompare.control.MedikamentControl;
import de.medicompare.entities.Medikament;



@RequestScoped
@Named("imagesView")
@Stateful
public class ImagesView {

	@Inject
	private MedikamentControl medikamentControl;
	
	private List<Medikament> medikamentenListe = null;
	
	@PostConstruct
	public void fetchMedikamente(){
		medikamentenListe = medikamentControl.findAllMedikamente();
		
	}
	
	public List<Medikament> getMedikamentenListe() {
		return medikamentenListe;
	}
	
	
	
}
