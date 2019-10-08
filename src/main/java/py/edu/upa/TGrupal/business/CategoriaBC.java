package py.edu.upa.TGrupal.business;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import py.edu.upa.TGrupal.entity.Categoria;
import py.edu.upa.TGrupal.entity.Producto;
import py.edu.upa.TGrupal.dao.CategoriaDAO;

@Named
@RequestScoped
public class CategoriaBC {

	@EJB
	private CategoriaDAO dao;

	public List<Categoria> find() {
		return dao.find();
	}

	public Categoria findById(Integer id) {
		return dao.findById(id);
	}

	public void insert(Categoria c) {
		dao.insert(c);
	}

	public void update(Integer id, Categoria c) {
		dao.update(id, c);
	}

	public void delete(Integer id) {
		dao.delete(id);
	}

	public List<Categoria> getWithFilter(String filter) {
		return dao.findWithFilter(filter);
	}

	public List<Categoria> getPaginated(int pageSize, int first) {
		return dao.getPaginado(pageSize, first);
	}

	public List<Categoria> byType(int id) {
		return dao.findByType(id);
	}

}
