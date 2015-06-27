package de.medicompare.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

@NamedQueries({
		@NamedQuery(
				name = "Medikament.findAll", query = "SELECT m FROM Medikament m",
				hints = {
						@QueryHint(name="org.hibernate.cacheable", value="true")
						}
				),						
		@NamedQuery(name = "Medikament.findByPZN", query = "SELECT m FROM Medikament m WHERE m.pzn = :pzn"),
		@NamedQuery(name = "Medikament.findOfferOfTheDay", query = "SELECT m FROM Medikament m WHERE m.offerOfTheDay = true"),
		@NamedQuery(name = "Medikament.findByID", query = "SELECT m FROM Medikament m WHERE m.id = :id") })
@Entity
@Table(name = "Medikament")
@Cacheable
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
	private boolean offerOfTheDay;
	
	
//	@Column(columnDefinition= "VARBINARY")
	@Lob
	@Basic(fetch=FetchType.EAGER)
	private byte[] bild;
	@Transient
	private boolean editable;
	@Version
	private int versionNr;
	@OneToMany(mappedBy = "medikament")
	private Collection<Bestand> bestand;
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

	public byte[] getBild() {
		return bild;
	}

	public void setBild(byte[] param) {
		this.bild = param;
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean param) {
		this.editable = param;
	}

	public boolean isOfferOfTheDay() {
		return offerOfTheDay;
	}

	public void setOfferOfTheDay(boolean offerOfTheDay) {
		this.offerOfTheDay = offerOfTheDay;
	}

	public Collection<Bestand> getBestand() {
	    return bestand;
	}

	public void setBestand(Collection<Bestand> param) {
	    this.bestand = param;
	}

}