package py.edu.upa.TGrupal.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import py.edu.upa.TGrupal.entity.Proveedor;

@Stateless
public class ProveedorDAO {
	@PersistenceContext
	EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public List<Proveedor> findWithFilter(String filter) {

		Session session = (Session) entityManager.getDelegate();
		Criteria criteria = session.createCriteria(Proveedor.class);

		// criteria.add(Restrictions.and(Restrictions.ilike("description", filter),
		// Restrictions.or(Restrictions.eq("deleted", false),
		// Restrictions.isNull("deleted"))));

		return criteria.list();

	}

	@SuppressWarnings("unchecked")
	public List<Proveedor> getPaginado(int pageSize, int first) {
		Session session = (Session) entityManager.getDelegate();
		Criteria criteria = session.createCriteria(Proveedor.class);
		criteria.setFirstResult(first);
		criteria.setMaxResults(pageSize);
		session.getTransaction().commit();

		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<Proveedor> find() {
		Session session = (Session) entityManager.getDelegate();
		Criteria criteria = session.createCriteria(Proveedor.class);
		// criteria.add(Restrictions.or(Restrictions.eq("deleted", false),
		// Restrictions.isNull("deleted")));
		return criteria.list();

	}

	public Proveedor findById(Integer id) {

		Session session = (Session) entityManager.getDelegate();
		Criteria criteria = session.createCriteria(Proveedor.class);
		criteria.add(Restrictions.eq("id", id));
		return (Proveedor) criteria.uniqueResult();
	}

	public void insert(Proveedor p) {
		entityManager.persist(p);
	}

	public void delete(Proveedor p) {
		entityManager.remove(p);
	}

	public void update(Integer id, Proveedor proveedor) {
		Proveedor p = findById(id);
		p.setDescripcion(proveedor.getDescripcion());
		p.setName(proveedor.getNombre());
		entityManager.merge(p);
	}
	public void delete(Integer id) {
		Proveedor p = findById(id);
		entityManager.merge(p);
	}
}