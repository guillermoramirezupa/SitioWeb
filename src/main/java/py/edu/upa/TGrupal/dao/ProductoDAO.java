package py.edu.upa.TGrupal.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import py.edu.upa.TGrupal.entity.Producto;

@Stateless
public class ProductoDAO {
	@PersistenceContext
	EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<Producto> findWithFilter(String filter) {

		Session session = (Session) entityManager.getDelegate();
		Criteria criteria = session.createCriteria(Producto.class);
		
		criteria.add(Restrictions.and(
				Restrictions.ilike("description", filter),
				Restrictions.or(
						Restrictions.eq("deleted", false),
						Restrictions.isNull("deleted")
				)));
		
		return criteria.list();

	}
	
	@SuppressWarnings("unchecked")
	public List<Producto> find() {

		Session session = (Session) entityManager.getDelegate();
		Criteria criteria = session.createCriteria(Producto.class);
		
		criteria.add(Restrictions.or(
				Restrictions.eq("deleted", false),
				Restrictions.isNull("deleted")));
		
		return criteria.list();

	}
	
	public Producto findById(Integer id) {

		Session session = (Session) entityManager.getDelegate();
		Criteria criteria = session.createCriteria(Producto.class);
		
		criteria.add(Restrictions.eq("id", id));
		
		return (Producto) criteria.uniqueResult();

	}
	
	public void insert(Producto p){
		entityManager.persist(p);
	}
	
	public void update(Integer id, Producto producto){
		Producto p = findById(id);
		p.setDescription(producto.getDescription());
		p.setDeleted(producto.getDeleted());
		p.setLimitDate(producto.getLimitDate());
		p.setName(producto.getName());
		p.setUpdateDate(producto.getUpdateDate());
		p.setEstado(producto.getEstado());
		entityManager.merge(p);
	}
	
	public void delete(Integer id){
		Producto p = findById(id);
		p.setDeleted(true);
		entityManager.merge(p);
	}
	@SuppressWarnings("unchecked")
	public List<Producto> findByType(int id) {
		Session session = (Session) entityManager.getDelegate();
		Criteria criteria = session.createCriteria(Producto.class);
		criteria.add(Restrictions.eq("type.id",id));
		return(List<Producto>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<Producto> getPaginado(int pageSize, int first) {
		Session session = (Session) entityManager.getDelegate();
		Criteria criteria = session.createCriteria(Producto.class);
		criteria.setFirstResult(first);
		criteria.setMaxResults(pageSize);
		session.getTransaction().commit();

		return criteria.list();
	}
}