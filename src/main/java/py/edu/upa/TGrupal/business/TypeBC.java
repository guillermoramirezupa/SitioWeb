package py.edu.upa.test.business;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import py.edu.upa.test.dao.TypeDAO;
import py.edu.upa.test.entity.Type;

@Named
@RequestScoped
public class TypeBC {

	@EJB
	private TypeDAO dao;

	public List<Type> find() {
		return dao.find();
	}

	public Type findById(Integer id) {
		return dao.findById(id);
	}

	public void insert(Type t) {
		dao.insert(t);
	}

	public void update(Integer id, Type t) {
		dao.update(id, t);
	}

	public void delete(Integer id) {
		dao.delete(id);
	}

	public List<Type> getWithFilter(String filter) {
		return dao.findWithFilter(filter);}

		public List<Type> getPaginated(int pageSize,int first) {
			return dao.getPaginado(pageSize,first );}
			
		
}
