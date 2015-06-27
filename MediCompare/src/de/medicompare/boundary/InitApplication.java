package de.medicompare.boundary;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import de.medicompare.control.BestandControl;
import de.medicompare.control.GesamtBestellungControl;
import de.medicompare.control.MedikamentControl;
import de.medicompare.control.PersonControl;
import de.medicompare.control.ShopAnbieterControl;
import de.medicompare.entities.Bestand;
import de.medicompare.entities.GesamtBestellung;
import de.medicompare.entities.Medikament;
import de.medicompare.entities.Person;
import de.medicompare.entities.ShopAnbieter;

@SessionScoped
@Stateful 
@Named("initApplication")
public class InitApplication {

	@Inject
	private PersonControl personControl;
	@Inject
	private MedikamentControl medikamentControl;
	@Inject
	private GesamtBestellungControl gesamtBestellungControl;
	@Inject 
	private ShopAnbieterControl shopAnbieterControl;
	@Inject
	private BestandControl bestandControl;
	
	public void init(){
		Person lPerson1 = new Person();		
		lPerson1.setVorname("Pascal");
		lPerson1.setNachname("Stieber");
		lPerson1.setEmailAdresse("pascal.stieber.ps@googlemail.com");
		lPerson1.setPasswort("hallowelt");
		personControl.savePerson(lPerson1);
		
		Person lPerson2 = new Person();		
		lPerson2.setVorname("Tim");
		lPerson2.setNachname("Foerster");
		lPerson2.setEmailAdresse("foerster@dailytrade24.de");
		lPerson2.setPasswort("hallowelt");
		personControl.savePerson(lPerson2);
		
		Medikament medikament1 = new Medikament();
		medikament1.setBezeichnung("Diclofenac");
		medikament1.setAnzahlPackungsInhalt("25");
		medikament1.setHersteller("MYLAN dura");
		medikament1.setPzn("3952149");
		medikament1.setOfferOfTheDay(true);
		File lFile1 = new File("F:\\\\Development_Repos\\git\\MediCompare\\MediCompare\\WebContent\\resources\\img\\produktBilder\\diclofenac_dura.jpg");
		byte[] lbyte1 = new byte[(int)lFile1.length()];
		
		try {
			FileInputStream lFileIS1 = new FileInputStream(lFile1);
			lFileIS1.read(lbyte1);
			lFileIS1.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		medikament1.setBild(lbyte1);
		medikamentControl.saveMedikament(medikament1);
		
		Medikament medikament2 = new Medikament();
		medikament2.setBezeichnung("Ketostix");
		medikament2.setAnzahlPackungsInhalt("50");
		medikament2.setHersteller("BAYER");
		medikament2.setPzn("1266177");
		File lFile2 = new File("F:\\\\Development_Repos\\git\\MediCompare\\MediCompare\\WebContent\\resources\\img\\produktBilder\\ketostix.jpg");
		byte[] lbyte2 = new byte[(int)lFile2.length()];
		
		try {
			FileInputStream lFileIS2 = new FileInputStream(lFile2);
			lFileIS2.read(lbyte2);
			lFileIS2.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		medikament2.setBild(lbyte2);
		medikamentControl.saveMedikament(medikament2);
		
		Medikament medikament3 = new Medikament();
		medikament3.setBezeichnung("Lutschtabletten");
		medikament3.setAnzahlPackungsInhalt("24");
		medikament3.setHersteller("DoloDobendan");
		medikament3.setPzn("06865646");
		File lFile3 = new File("F:\\\\Development_Repos\\git\\MediCompare\\MediCompare\\WebContent\\resources\\img\\produktBilder\\dolodobendan.jpg");
		byte[] lbyte3 = new byte[(int)lFile3.length()];
		
		try {
			FileInputStream lFileIS3 = new FileInputStream(lFile3);
			lFileIS3.read(lbyte3);
			lFileIS3.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		medikament3.setBild(lbyte3);
		medikamentControl.saveMedikament(medikament3);
		
		Medikament medikament4 = new Medikament();
		medikament4.setBezeichnung("Ibuprofen");
		medikament4.setAnzahlPackungsInhalt("30");
		medikament4.setHersteller("DocMorris");
		medikament4.setPzn("7580420");
		File lFile4 = new File("F:\\\\Development_Repos\\git\\MediCompare\\MediCompare\\WebContent\\resources\\img\\produktBilder\\ibuprofen.jpg");
		byte[] lbyte4 = new byte[(int)lFile4.length()];
		
		try {
			FileInputStream lFileIS4 = new FileInputStream(lFile4);
			lFileIS4.read(lbyte4);
			lFileIS4.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		medikament4.setBild(lbyte4);
		medikamentControl.saveMedikament(medikament4);
		
		ArrayList<Medikament> lMedikamentenListe = new ArrayList<Medikament>();
		lMedikamentenListe.add(medikament1);
		lMedikamentenListe.add(medikament2);
		lMedikamentenListe.add(medikament3);
		lMedikamentenListe.add(medikament4);
		
		GesamtBestellung lGesamtBestellung = new GesamtBestellung();
		lGesamtBestellung.setPerson(lPerson1);
		lGesamtBestellung.setMedikament(medikament1);
		lGesamtBestellung.setMedikament(medikament2);
		lGesamtBestellung.setMedikament(medikament3);
		lGesamtBestellung.setMedikament(medikament4);
		gesamtBestellungControl.saveGesamtBestellung(lGesamtBestellung);
		
		
		//Bestände
		
		ShopAnbieter lShopAnbieter = new ShopAnbieter();
		lShopAnbieter.setEmailAdresse("doc@morris.de");
		lShopAnbieter.setFirmenName("DocMorris");
		shopAnbieterControl.saveShopAnbieter(lShopAnbieter);
		
		Bestand lBestand = new Bestand();
		lBestand.setShopAnbieter(lShopAnbieter);
		lBestand.setMedikament(medikament4);
		lBestand.setPreis("19,65");

		Bestand lBestand3 = new Bestand();
		lBestand3.setShopAnbieter(lShopAnbieter);
		lBestand3.setMedikament(medikament3);
		lBestand3.setPreis("8,50");
		
		
		Bestand lBestand2 = new Bestand();
		lBestand2.setShopAnbieter(lShopAnbieter);
		lBestand2.setMedikament(medikament2);
		lBestand2.setPreis("4,01");
		
		
		Bestand lBestand4 = new Bestand();
		lBestand4.setShopAnbieter(lShopAnbieter);
		lBestand4.setMedikament(medikament1);
		lBestand4.setPreis("12,90");	
		
		bestandControl.saveBestand(lBestand4);
		bestandControl.saveBestand(lBestand2);
		bestandControl.saveBestand(lBestand3);
		bestandControl.saveBestand(lBestand);
		
		ShopAnbieter lShopAnbieter2 = new ShopAnbieter();		
		lShopAnbieter2.setEmailAdresse("versand@apo.de");
		lShopAnbieter2.setFirmenName("VersandApo");
		shopAnbieterControl.saveShopAnbieter(lShopAnbieter2);
		
		Bestand lBestand6 = new Bestand();
		lBestand6.setShopAnbieter(lShopAnbieter2);
		lBestand6.setMedikament(medikament4);
		lBestand6.setPreis("12,65");

		Bestand lBestand7 = new Bestand();
		lBestand7.setShopAnbieter(lShopAnbieter2);
		lBestand7.setMedikament(medikament3);
		lBestand7.setPreis("4,50");
		
		Bestand lBestand8 = new Bestand();
		lBestand8.setShopAnbieter(lShopAnbieter2);
		lBestand8.setMedikament(medikament2);
		lBestand8.setPreis("2,01");
		
		Bestand lBestand9 = new Bestand();
		lBestand9.setShopAnbieter(lShopAnbieter2);
		lBestand9.setMedikament(medikament1);
		lBestand9.setPreis("15,90");
		
		bestandControl.saveBestand(lBestand6);
		bestandControl.saveBestand(lBestand7);
		bestandControl.saveBestand(lBestand8);
		bestandControl.saveBestand(lBestand9);
		
	}
}
