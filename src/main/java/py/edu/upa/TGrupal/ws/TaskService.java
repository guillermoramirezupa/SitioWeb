/*package py.edu.upa.test.ws;

import javax.enterprise.context.RequestScoped;
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

import py.edu.upa.test.business.TaskBC;
import py.edu.upa.test.entity.Task;

@Path("tasks")
@RequestScoped
public class TaskService {

	@Inject
	private TaskBC bc;

//  http://localhost:8080/rest/tasks
	@GET
	@Produces("application/json")
	public Response getAll() {
		try {
			System.out.println("Prueba");
			return Response.ok().entity(bc.find()).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("ERROR_GENERICO").build();
		}
	}

//  http://localhost:8080/rest/tasks
	@POST
	@Consumes({ "application/json" })
	@Produces({ "application/json" })
	public Response add(Task t) {
		try {
			bc.insert(t);
			return Response.ok().entity(t).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("ERROR_GENERICO").build();
		}
	}

//	http://localhost:8080/rest/tasks/1
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

//    http://localhost:8080/rest/tasks/1
	@PUT
	@Path("/{id: \\d+}")
	@Consumes({ "application/json" })
	@Produces({ "application/json" })
	public Response update(@PathParam("id") Integer id, Task t) {
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

//    http://localhost:8080/rest/tasks/prueba?filter=xx
	@GET
	@Path("/pruebas")
	@Produces({ "application/json" })
	public Response update(@QueryParam("filter") String filter) {
		try {
			return Response.ok().entity(bc.getWithFilter(filter)).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("ERROR_GENERICO").build();
		}
	}

//	http://localhost:8080/ws/rest/types
	@GET
	@Path("/byType")
	@Produces({ "application/json" })
	public Response getByType(@QueryParam("id") Integer id) {
		try {
			return Response.ok().entity(bc.byType(id)).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("ERROR_GENERICO").build();
		}

	}
}
*/
package py.edu.upa.test.ws;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import py.edu.upa.test.business.TaskBC;
import py.edu.upa.test.entity.Task;

@Path("tasks")
public class TaskService {

	@PersistenceContext
	EntityManager entityManager;

	@Inject
	private TaskBC bc;

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
	public Response add(Task t) {
		try {
			bc.insert(t);
			return Response.ok().entity(t).build();
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
	public Response update(@PathParam("id") Integer id, Task t) {
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
			List<Task> tasks = bc.getPaginated(page, PagSize);
			PaginatedTask paginatedList = new PaginatedTask();
			paginatedList.setTasks(tasks);
			List<Task> todos = bc.find();
			paginatedList.setCount(todos != null ? todos.size() : 0);
			return Response.ok().entity(paginatedList).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("ERROR_GENERICO").build();
		}
	}
}

class PaginatedTask {
	List<Task> tasks;
	int count;
	public List<Task> getTasks() {
		return tasks;
	}
	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
}