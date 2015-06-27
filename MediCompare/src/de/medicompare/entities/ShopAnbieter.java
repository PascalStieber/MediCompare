package de.medicompare.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({@NamedQuery(name = "ShopAnbieter.findAll", query = "SELECT sa FROM ShopAnbieter sa")})
public class ShopAnbieter implements Serializable {

	private static final long serialVersionUID = 1L;

	public ShopAnbieter() {
	}

	@Id
	@GeneratedValue
	private long id;
	private String emailAdresse;
	private String firmenName;
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "shopAnbieter")
	private Collection<Bestand> bestand;
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmailAdresse() {
		return emailAdresse;
	}

	public void setEmailAdresse(String param) {
		this.emailAdresse = param;
	}

	public String getFirmenName() {
		return firmenName;
	}

	public void setFirmenName(String param) {
		this.firmenName = param;
	}

	public Collection<Bestand> getBestand() {
	    return bestand;
	}

	public void setBestand(Collection<Bestand> param) {
	    this.bestand = param;
	}

}