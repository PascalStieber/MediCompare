package de.medicompare.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

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

}