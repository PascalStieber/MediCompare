package de.medicompare.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Version;
import de.medicompare.entities.Medikament;

@Entity

@NamedQueries({@NamedQuery(name = "GesamtBestellung.findAll", query = "SELECT gb FROM GesamtBestellung gb")})
public class GesamtBestellung implements Serializable {

	private static final long serialVersionUID = 1L;

	public GesamtBestellung() {
	}

	@Id
	@GeneratedValue
	private long id;
	@ManyToOne
	private Person person;
	public long getId() {
		return id;
	}
	@Version
	private int versionNr;
	@ManyToOne
	private Medikament medikament;
	public void setId(long id) {
		this.id = id;
	}

	public Person getPerson() {
	    return person;
	}

	public void setPerson(Person param) {
	    this.person = param;
	}

	public Medikament getMedikament() {
	    return medikament;
	}

	public void setMedikament(Medikament param) {
	    this.medikament = param;
	}

}