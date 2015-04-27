package de.medicompare.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import de.medicompare.entities.GesamtBestellung;
import java.util.Collection;
import javax.persistence.OneToMany;

@Entity
@Table(name = "Person")
public class Person implements Serializable {

	private static final long serialVersionUID = 1L;

	public Person() {
	}

	@Id
	private long id;
	private String vorname;
	private String nachname;
	private String emailAdresse;
	private String passwort;
	@OneToMany(mappedBy = "person")
	private Collection<GesamtBestellung> gesamtBestellung;
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public Collection<GesamtBestellung> getGesamtBestellung() {
	    return gesamtBestellung;
	}

	public void setGesamtBestellung(Collection<GesamtBestellung> param) {
	    this.gesamtBestellung = param;
	}

}