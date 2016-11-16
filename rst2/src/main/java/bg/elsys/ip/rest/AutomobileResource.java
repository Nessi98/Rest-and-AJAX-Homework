package bg.elsys.ip.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/automobiles")
public class AutomobileResource {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUsers() {
		
		AutomobileService automobileService = AutomobileService.getInstance();
		
		return Response.ok(automobileService.getAutomobiles()).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createAutomobile(Automobile automobile) {
		AutomobileService.getInstance().addAutomobile(automobile);

		return Response.ok(automobile).status(Status.CREATED).build();
	}
}
