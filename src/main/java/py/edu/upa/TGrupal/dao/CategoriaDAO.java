package py.edu.upa.TGrupal.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import py.edu.upa.TGrupal.entity.Categoria;
import py.edu.upa.TGrupal.entity.Producto;

@Stateless
public class CategoriaDAO {
	@PersistenceContext
	EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public List<Categoria> findWithFilter(String filter) {

		Session session = (Session) entityManager.getDelegate();
		Criteria criteria = session.createCriteria(Categoria.class);

		// criteria.add(Restrictions.and(Restrictions.ilike("description", filter),
		// Restrictions.or(Restrictions.eq("deleted", false),
		// Restrictions.isNull("deleted"))));

		return criteria.list();

	}

	@SuppressWarnings("unchecked")
	public List<Categoria> getPaginado(int pageSize, int first) {
		Session session = (Session) entityManager.getDelegate();
		Criteria criteria = session.createCriteria(Categoria.class);
		criteria.setFirstResult(first);
		criteria.setMaxResults(pageSize);
		session.getTransaction().commit();

		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<Categoria> find() {
		Session session = (Session) entityManager.getDelegate();
		Criteria criteria = session.createCriteria(Categoria.class);
		// criteria.add(Restrictions.or(Restrictions.eq("deleted", false),
		// Restrictions.isNull("deleted")));
		return criteria.list();

	}

	public Categoria findById(Integer id) {

		Session session = (Session) entityManager.getDelegate();
		Criteria criteria = session.createCriteria(Categoria.class);
		criteria.add(Restrictions.eq("id", id));
		return (Categoria) criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Categoria> findByType(int id) {
		Session session = (Session) entityManager.getDelegate();
		Criteria criteria = session.createCriteria(Producto.class);
		criteria.add(Restrictions.eq("type.id",id));
		return(List<Categoria>) criteria.list();
	}
	
	
	public void insert(Categoria c) {
		entityManager.persist(c);
	}

	public void delete(Categoria c) {
		entityManager.remove(c);
	}

	public void update(Integer id, Categoria categoria) {
		Categoria c = findById(id);
		c.setDescripcion(categoria.getDescripcion());
		c.setName(categoria.getNombre());
		entityManager.merge(c);
	}

	public void delete(Integer id) {
		Categoria c = findById(id);
		entityManager.merge(c);
	}
}