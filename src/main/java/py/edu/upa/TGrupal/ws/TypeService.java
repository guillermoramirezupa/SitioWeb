/*package py.edu.upa.test.ws;

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
import javax.ws.rs.core.Response;

import py.edu.upa.test.business.TypeBC;
import py.edu.upa.test.entity.Type;

@Path("types")
public class TypeService {

	@Inject
	private TypeBC bc;

	@GET
	@Produces("application/json")
	public Response getAll() {
		try {
			return Response.ok().entity(bc.find()).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("ERROR_GENERICO").build();
		}
	}

	@POST
	@Consumes({ "application/json" })
	@Produces({ "application/json" })
	public Response add(Type t) {
		try {
			bc.insert(t);
			return Response.ok().entity(t).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("ERROR_GENERICO").build();
		}
	}

//	http://localhost:8080/ws/rest/types
	@GET
	@Path("/{id: \\d+}")
	@Produces({ "application/json" })
	public Response get(@PathParam("id") Integer id) {
		try {
			return Response.ok().entity(bc.findById(id)).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("ERROR_GENERICO").build();
		}
	}

//    http://localhost:8080/ws/rest/types/1?filter=xx
	@PUT
	@Path("/{id: \\d+}")
	@Consumes({ "application/json" })
	@Produces({ "application/json" })
	public Response update(@PathParam("id") Integer id, Type t) {
		try {
			bc.update(id, t);
			return Response.ok().entity("OK").build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("ERROR_GENERICO").build();
		}
	}

	@DELETE
	@Path("/{id: \\d+}")
	@Produces({ "application/json" })
	public Response delete(@PathParam("id") Integer id) {
		try {
			bc.delete(id);
			return Response.ok().entity("OK").build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("ERROR_GENERICO").build();
		}
	}

//    http://localhost:8080/ws/rest/types/pruebas?filter=xx
	@GET
	@Path("/pruebas")
	@Produces("application/json")
	public Response update(@QueryParam("filter") String filter) {
		System.out.println("=================================");
		System.out.println(filter);
		try {
			return Response.ok().entity(bc.getWithFilter(filter)).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("ERROR_GENERICO").build();
		}
	}

	@GET
	@Path("/paginated")
	@Produces("application/json")
	public Response paginated(@QueryParam("pageSize")int pageSize,@QueryParam("first") int first) {
		System.out.println("================");
		System.out.println(pageSize);
		System.out.println(first);
		
		try {
			return Response.ok().entity(bc.getPaginated(pageSize, first)).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("ERROR_GENERICO").build();
		}
		}}*/

package py.edu.upa.test.ws;

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
import javax.ws.rs.core.Response;

import py.edu.upa.test.business.TypeBC;
import py.edu.upa.test.entity.Type;

@Path("types")
public class TypeService {

	@Inject
	private TypeBC bc;

	@GET
    @Produces("application/json")
	public Response getAll() {
		try {
			return Response.ok().entity(bc.find()).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity("ERROR_GENERICO")
					.build();
		}
	}
	
	@POST
    @Consumes({"application/json"})
    @Produces({"application/json"})
	public Response add(Type t) {
		try {
			bc.insert(t);
			return Response.ok().entity(t).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity("ERROR_GENERICO")
					.build();
		}
	}

//	http://localhost:8080/rest/types/1
    @GET
    @Path("/{id: \\d+}")
    @Produces({"application/json"})
    public Response get(@PathParam("id") Integer id) {
    	try {
			return Response.ok().entity(bc.findById(id)).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity("ERROR_GENERICO")
					.build();
		}
    }

//    http://localhost:8080/rest/types/1?filter=xx
    @PUT
    @Path("/{id: \\d+}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response update(@PathParam("id") Integer id, Type t) {
    	try {
    		bc.update(id,t);
			return Response.ok().entity("OK").build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity("ERROR_GENERICO")
					.build();
		}
    }

    @DELETE
    @Path("/{id: \\d+}")
    @Produces({"application/json"})
    public Response delete(@PathParam("id") Integer id) {
    	try {
    		bc.delete(id);
			return Response.ok().entity("OK").build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity("ERROR_GENERICO")
					.build();
		}
    }
    
//    http://localhost:8080/rest/types/prueba?filter=xx
    @GET
    @Path("/pruebas")
    @Produces({"application/json"})
    public Response update(@QueryParam("filter") String filter) {
    	System.out.println("=================================");
    	System.out.println(filter);
    	try {
			return Response.ok().entity(bc.getWithFilter(filter)).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity("ERROR_GENERICO")
					.build();
		}
    }
	
	

}


