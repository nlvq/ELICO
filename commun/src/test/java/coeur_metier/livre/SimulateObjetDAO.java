package coeur_metier.livre;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.criterion.Criterion;

import dao.IObjetDAO;
import dao.Objet;


public class SimulateObjetDAO implements IObjetDAO{
	private final HashMap<Long, Objet> object_table=new HashMap<>();
		@Override
	public void createObjet(Objet objet) {
		
		
			objet.setId((long)object_table.size());
			object_table.put((long)object_table.size(), objet);
			
		
	}

	@Override
	public void updateObjet(Objet objet) {
		if (object_table.containsKey(objet.getId()))
		refresh(objet);
		
	}

	@Override
	public void deleteObjet(Objet objet) {
		
		remove(objet);
		
	}

	@Override
	public List<Objet> findObjet(Objet objet) {
	List<Objet> toFind= new ArrayList<Objet>();
		for(Objet o : object_table.values()){
			if(o.getId().equals(objet.getId())
					&& (o.getType().equals(objet.getType()))
					&&(o.getParent().equals(objet.getParent())))
				toFind.add(o);
		}
		return toFind;
		
	}

	@Override
	public Session getHibernateSession() {
		
		return null;
	}

	@Override
	public List<Objet> findByCriteria(Criterion... criteria) {
		return null;
	}

	@Override
	public List<Objet> findByExample(Objet instance, String[] excludeProperties) {
		return null;
	}

	@Override
	public boolean alreadyExists(Long key) {
		
		return object_table.containsKey(key);
	}

	@Override
	public Objet getReference(Long id) {
		
		return object_table.get(id);
	}

	@Override
	public Objet findById(Long id) {
		
		return getReference(id);
	}

	@Override
	public List<Objet> findByQuery(String query) {
	
		return null;
	}

	@Override
	public Objet findEntityByQuery(String query) {
		return null;
	}

	@Override
	public List<Objet> findByNamedQuery(String query) {
			return null;
	}

	@Override
	public Objet findEntityByNamedQuery(String query) {
		return null;
	}

	@Override
	public List<Objet> findAll() {
		return new ArrayList<Objet>(object_table.values());
		
	}

	@Override
	public Long findCountAll() {
		
		return (long)findAll().size();
		
	}

	@Override
	public Objet persist(Objet toPersist) {
		
		toPersist.setId((long) object_table.size());
		return object_table.put((long) object_table.size(), toPersist);
		
		
	}

	@Override
	public void remove(Objet toRemove) {
				
	}

	@Override
	public void flush() {
		
	}

	@Override
	public void clear() {
		
	}

	@Override
	public boolean contains(Objet isContained) {
		return false;
	}

	@Override
	public void refresh(Objet toRefresh) {
		
	}

	@Override
	public Objet merge(Objet toMerge) {
		return null;
	}

	@Override
	public Query createQuery(String query) {
		return null;
	}

	@Override
	public Query createNativeQuery(String query) {
		return null;
	}

	@Override
	public Query createNamedQuery(String query) {
		return null;
	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		
	}

	@Override
	public EntityManager getEntityManager() {
		return null;
	}

	@Override
	public Class<Objet> getEntityType() {
		return null;
	}

}
