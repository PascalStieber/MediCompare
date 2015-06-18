package de.medicompare.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

@Entity
@Table(name = "Person")
public class Person implements Serializable {

	private static final long serialVersionUID = 1L;

	public Person() {
	}

	@Id
	@GeneratedValue
	private long id;
	private String vorname;
	private String nachname;
	private String emailAdresse;
	private String passwort;
	@Version
	private int versionNr;
	@Transient
	private boolean editable;
	
	
	public long getId() {
		return id;
	}

	
	public void setId(long id) {
		this.id = id;
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String param) {
		this.vorname = param;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String param) {
		this.nachname = param;
	}

	public String getEmailAdresse() {
		return emailAdresse;
	}

	public void setEmailAdresse(String param) {
		this.emailAdresse = param;
	}

	public String getPasswort() {
		return passwort;
	}

	public void setPasswort(String param) {
		this.passwort = param;
	}

}