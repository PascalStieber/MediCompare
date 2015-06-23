package de.medicompare.entities;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class AdminWebsite implements Serializable {

	private static final long serialVersionUID = 1L;

	public AdminWebsite() {
	}

	@Id
	private long id;
	private String landingPageName;
	private String landingPageContent;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLandingPageName() {
		return landingPageName;
	}

	public void setLandingPageName(String param) {
		this.landingPageName = param;
	}

	public String getLandingPageContent() {
		return landingPageContent;
	}

	public void setLandingPageContent(String param) {
		this.landingPageContent = param;
	}

}