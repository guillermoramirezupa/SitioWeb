package py.edu.upa.TGrupal.ws;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import py.edu.upa.TGrupal.business.CategoriaBC;
import py.edu.upa.TGrupal.entity.Categoria;


@Path("tasks")
public class CategoriaService {

	@PersistenceContext
	EntityManager entityManager;

	@Inject
	private CategoriaBC bc;

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
	public Response add(Categoria c) {
		try {
			bc.insert(c);
			return Response.ok().entity(c).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("ERROR_GENERICO").build();
		}
	}

//	http://localhost:8080/ws/rest/taks/1
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

//    http://localhost:8080/rest/taks/1?filter=xx
	@PUT
	@Path("/{id: \\d+}")
	@Consumes({ "application/json" })
	@Produces({ "application/json" })
	public Response update(@PathParam("id") Integer id, Categoria c) {
		try {
			bc.update(id, c);
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

//    http://localhost:8080/rest/tasks/prueba?filter=xx
	@GET
	@Path("/pruebas")
	@Produces({ "application/json" })
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

//  http://localhost:8080/rest/tasks/?findByType=xx
	@GET
	@Path("/findByType")
	@Produces({ "application/json" })
	public Response update(@QueryParam("id_type") int findByType) {
		System.out.println("=================================");
		System.out.println(findByType);
		try {
			return Response.ok().entity(bc.byType(findByType)).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("ERROR_GENERICO").build();

		}
	}

//  http://localhost:8080/ws/rest/tasks/paginated?PageSize=2&page=1
	@GET
	@Path("/paginated")
	@Produces({ "application/json" })
	public Response getPaginated(@QueryParam("PageSize") int PagSize, @QueryParam("page") int page){
		try {
			List<Categoria> tasks = bc.getPaginated(page, PagSize);
			PaginatedTask paginatedList = new PaginatedTask();
			paginatedList.setTasks(tasks);
			List<Categoria> todos = bc.find();
			paginatedList.setCount(todos != null ? todos.size() : 0);
			return Response.ok().entity(paginatedList).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("ERROR_GENERICO").build();
		}
	}
}

class PaginatedTask {
	List<Categoria> categoria;
	int count;
	public List<Categoria> getCategoria() {
		return categoria;
	}
	public void setTasks(List<Categoria> categoria) {
		this.categoria= categoria;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
}