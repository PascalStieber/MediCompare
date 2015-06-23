package de.medicompare.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import de.medicompare.entities.Medikament;
import de.medicompare.entities.ShopAnbieter;

import javax.persistence.OneToOne;
import javax.persistence.MapsId;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "Bestand")
@NamedQueries({@NamedQuery(name = "Bestand.findAll", query = "SELECT b FROM Bestand b")})
public class Bestand implements Serializable {

	private static final long serialVersionUID = 1L;

	public Bestand() {
	}

	@Id
	@GeneratedValue
	private long id;
	private String preis;
	private String aktualisierungsDatum;
	@OneToOne
	private Medikament medikament;
	@OneToOne
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