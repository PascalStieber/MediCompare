package de.medicompare.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import de.medicompare.entities.Medikament;
import javax.persistence.ManyToOne;
import de.medicompare.entities.ShopAnbieter;

@Entity
@Table(name = "Bestand")
@NamedQueries({@NamedQuery(name = "Bestand.findAll", query = "SELECT b FROM Bestand b"),
			   @NamedQuery(name = "Bestand.searchUserTerm", query = "SELECT b FROM Bestand b JOIN b.medikament m JOIN b.shopAnbieter sa WHERE m.bezeichnung = :userTerm OR m.hersteller = :userTerm OR sa.firmenName = :userTerm ")})
public class Bestand implements Serializable {

	private static final long serialVersionUID = 1L;

	public Bestand() {
	}

	@Id
	@GeneratedValue
	private long id;
	private String preis;
	private String aktualisierungsDatum;
	@ManyToOne
	private Medikament medikament;
	@ManyToOne
	private ShopAnbieter shopAnbieter;
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPreis() {
		return preis;
	}

	public void setPreis(String param) {
		this.preis = param;
	}

	public String getAktualisierungsDatum() {
		return aktualisierungsDatum;
	}

	public void setAktualisierungsDatum(String param) {
		this.aktualisierungsDatum = param;
	}

	public Medikament getMedikament() {
	    return medikament;
	}

	public void setMedikament(Medikament param) {
	    this.medikament = param;
	}

	public ShopAnbieter getShopAnbieter() {
	    return shopAnbieter;
	}

	public void setShopAnbieter(ShopAnbieter param) {
	    this.shopAnbieter = param;
	}

}