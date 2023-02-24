package resource;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import business.FluctuationBusiness;
import entities.Fluctuation;

@Path("Fluctuations")
public class FluctuationServices {

	@Inject
	private FluctuationBusiness FluctuationBusiness;

	@GET
	@Path("hello")
	@Produces(MediaType.TEXT_PLAIN)
	public Response helloWorld() {
		return Response.ok("Hello World").build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllFluctuations() {
		return Response.ok(FluctuationBusiness.getAllFluctuations()).build();
	}

	@GET
	@Path("last")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getLast() {
		return Response.ok(FluctuationBusiness.getLast()).build();
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getFluctuation(@PathParam("id") long id) {
		return Response.ok(FluctuationBusiness.get(id)).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addFluctuation(Fluctuation Fluctuation) {
		FluctuationBusiness.add(Fluctuation);
		return Response.noContent().build();
	}

	@DELETE
	@Path("{id}")
	public Response deleteFluctuation(@PathParam("id") long id) {
		FluctuationBusiness.delete(id);
		return Response.noContent().build();
	}

	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateFluctuation(@PathParam("id") long id, Fluctuation Fluctuation) {
		FluctuationBusiness.update(Fluctuation);
		return Response.noContent().build();
	}
	
	@GET
	@Path("search")
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchFluctuation(@QueryParam("name") String name) {
		return Response.ok(FluctuationBusiness.search(name)).build();
	}
	
}
