package de.medicompare.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import de.medicompare.entities.Person;
import de.medicompare.entities.Medikament;
import javax.persistence.ManyToOne;
import java.util.Collection;
import javax.persistence.ManyToMany;
import javax.persistence.GeneratedValue;

@Entity
public class GesamtBestellung implements Serializable {

	private static final long serialVersionUID = 1L;

	public GesamtBestellung() {
	}

	@Id
	@GeneratedValue
	private long id;
	@ManyToOne
	private Person person;
	@ManyToMany(mappedBy = "gesamtBestellung")
	private Collection<Medikament> medikament;
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Person getPerson() {
	    return person;
	}

	public void setPerson(Person param) {
	    this.person = param;
	}

	public Collection<Medikament> getMedikament() {
	    return medikament;
	}

	public void setMedikament(Collection<Medikament> param) {
	    this.medikament = param;
	}

}