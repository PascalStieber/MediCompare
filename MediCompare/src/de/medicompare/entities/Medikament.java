package de.medicompare.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import de.medicompare.entities.GesamtBestellung;
import java.util.Collection;
import javax.persistence.ManyToMany;
import javax.persistence.GeneratedValue;

@Entity
@Table(name = "Medikament")
public class Medikament implements Serializable {

	private static final long serialVersionUID = 1L;

	public Medikament() {
	}

	@Id
	@GeneratedValue
	private long id;
	private String bezeichnung;
	private String hersteller;
	private String anzahlPackungsInhalt;
	private String pzn;
	@ManyToMany
	private Collection<GesamtBestellung> gesamtBestellung;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBezeichnung() {
		return bezeichnung;
	}

	public void setBezeichnung(String param) {
		this.bezeichnung = param;
	}

	public String getHersteller() {
		return hersteller;
	}

	public void setHersteller(String param) {
		this.hersteller = param;
	}

	public String getAnzahlPackungsInhalt() {
		return anzahlPackungsInhalt;
	}

	public void setAnzahlPackungsInhalt(String param) {
		this.anzahlPackungsInhalt = param;
	}

	public String getPzn() {
		return pzn;
	}

	public void setPzn(String param) {
		this.pzn = param;
	}

	public Collection<GesamtBestellung> getGesamtBestellung() {
		return gesamtBestellung;
	}

	public void setGesamtBestellung(Collection<GesamtBestellung> param) {
		this.gesamtBestellung = param;
	}

}