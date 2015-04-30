package de.medicompare.rest;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;

import de.medicompare.entities.Medikament;

@RequestScoped
@Path("/medikamente")
public class MedikamentService {

	@POST
	@Consumes("application/json")
	public Response create(final Medikament medikament) {
		//TODO: process the given medikament 
		//here we use Medikament#getId(), assuming that it provides the identifier to retrieve the created Medikament resource. 
		return Response.created(
				UriBuilder.fromResource(MedikamentService.class)
						.path(String.valueOf(medikament.getId())).build())
				.build();
	}

	@GET
	@Path("/{id:[0-9][0-9]*}")
	@Produces("application/json")
	public Response findById(@PathParam("id") final Long id) {
		//TODO: retrieve the medikament 
		Medikament medikament = new Medikament();
		medikament.setId(1);
		medikament.setAnzahlPackungsInhalt("200");
		medikament.setBezeichnung("Kopfschmerztabletten");
		medikament.setHersteller("Ratiopharm");
		medikament.setPzn("132456789");
		
		return Response.ok(medikament).build();
	}

	@GET
	@Produces("application/json")
	public List<Medikament> listAll(
			@QueryParam("start") final Integer startPosition,
			@QueryParam("max") final Integer maxResult) {
		//TODO: retrieve the medikaments 
		final List<Medikament> medikaments = null;
		return medikaments;
	}

	@PUT
	@Path("/{id:[0-9][0-9]*}")
	@Consumes("application/json")
	public Response update(@PathParam("id") Long id, final Medikament medikament) {
		//TODO: process the given medikament 
		return Response.noContent().build();
	}

	@DELETE
	@Path("/{id:[0-9][0-9]*}")
	public Response deleteById(@PathParam("id") final Long id) {
		//TODO: process the medikament matching by the given id 
		return Response.noContent().build();
	}

}
