package py.edu.upa.TGrupal.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import py.edu.upa.TGrupal.dao.ProductoDAO;
import py.edu.upa.TGrupal.entity.Producto;

@Stateless
public class ProductoBC {

	@Inject
	private ProductoDAO dao;

	public List<Producto> find() {
		return dao.find();
	}

	public Producto findById(Integer id) {
		return dao.findById(id);
	}

	public void insert(Producto t) {
		dao.insert(t);
	}

	public void update(Integer id, Producto p) {
		dao.update(id, p);
	}

	public void delete(Integer id) {
		dao.delete(id);
	}

	public List<Producto> getWithFilter(String filter) {
		return dao.findWithFilter(filter);
	}

	public List<Producto> byType(int id) {
		return dao.findByType(id);
	}

	public List<Producto> getPaginated(int pageSize, int first) {
		return dao.getPaginado(first, pageSize);
	}
}
