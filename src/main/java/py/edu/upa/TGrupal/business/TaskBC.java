package py.edu.upa.test.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import py.edu.upa.test.dao.TaskDAO;
import py.edu.upa.test.entity.Task;

@Stateless
public class TaskBC {
	
    @Inject
	private TaskDAO dao;
	

	public List<Task> find() {
		return dao.find();
	}
	
	public Task findById(Integer id) {
		return dao.findById(id);
	}
	
	public void insert(Task t){
		dao.insert(t);
	}
	
	public void update(Integer id, Task t){
		dao.update(id, t);
	}
	
	public void delete(Integer id){
		dao.delete(id);
	}
	
	public List<Task> getWithFilter(String filter) {
		return dao.findWithFilter(filter);
	}
	
	public List<Task> byType(int id){
		return dao.findByType(id);
	}

	public List<Task> getPaginated(int pageSize,int first) {
		return dao.getPaginado(first,pageSize );}
}

