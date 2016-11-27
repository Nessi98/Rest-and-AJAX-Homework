package bg.elsys.ip.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Path("/automobiles")
@Api(value = "Api for querying automobiles")
public class AutomobileResource {
	
	@GET
	@ApiOperation(value = "get  all automobiles")
	@Produces(MediaType.APPLICATION_JSON)
	public PagedResponse getAutomobiles(@QueryParam("page") @DefaultValue("0") int page, 
			@QueryParam("perPage") @DefaultValue("12") int perPage, @QueryParam("with-name") String withBrand) {

		AutomobileService automobileService = AutomobileService.getInstance();
		PagedResponse automobilesInPages = automobileService.getAutomobilesInPagesFiltered(page, perPage, withBrand);
		
		return automobilesInPages;
	}
	public Response getAutomobile() {
		
		AutomobileService automobileService = AutomobileService.getInstance();
		
		return Response.ok(automobileService.getAutomobiles()).build();
	}

	@POST
	@ApiOperation(value = "create new automobile", response = Automobile.class)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createAutomobile(Automobile automobile) {
		AutomobileService.getInstance().addAutomobile(automobile);

		return Response.ok(automobile).status(Status.CREATED).build();
	}
}