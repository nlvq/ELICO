package coeur_metier.livre;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.criterion.Criterion;

import dao.IObjetDAO;
import dao.Objet;

public class SimulateObjetDAO implements IObjetDAO{
	
	private ArrayList<Objet> objets;
	
	public SimulateObjetDAO(){
		objets = new ArrayList<Objet>();
	}

	@Override
	public Session getHibernateSession() {
		// dont need
		return null;
	}

	@Override
	public List<Objet> findByCriteria(Criterion... criteria) {
		// dont need
		return null;
	}

	@Override
	public List<Objet> findByExample(Objet instance,
			String[] excludeProperties) {
		// dont need
		return null;
	}

	@Override
	public boolean alreadyExists(Long key) {
		// dont need
		return false;
	}

	@Override
	public Objet getReference(Long id) {
		// dont need
		return null;
	}

	@Override
	public Objet findById(Long id) {
		// dont need
		return null;
	}

	@Override
	public List<Objet> findByQuery(String query) {
		// dont need
		return null;
	}

	@Override
	public Objet findEntityByQuery(String query) {
		// dont need
		return null;
	}

	@Override
	public List<Objet> findByNamedQuery(String query) {
		// dont need
		return null;
	}

	@Override
	public Objet findEntityByNamedQuery(String query) {
		// dont need
		return null;
	}

	@Override
	public List<Objet> findAll() {
		// dont need
		return null;
	}

	@Override
	public Long findCountAll() {
		// dont need
		return null;
	}

	@Override
	public Objet persist(Objet toPersist) {
		// dont need
		return null;
	}

	@Override
	public void remove(Objet toRemove) {
		// dont need
	}

	@Override
	public void flush() {
		// dont need
	}

	@Override
	public void clear() {
		// dont need
	}

	@Override
	public boolean contains(Objet isContained) {
		// dont need
		return false;
	}

	@Override
	public void refresh(Objet toRefresh) {
		// dont need
	}

	@Override
	public Objet merge(Objet toMerge) {
		// dont need
		return null;
	}

	@Override
	public Query createQuery(String query) {
		// dont need
		return null;
	}

	@Override
	public Query createNativeQuery(String query) {
		// dont need
		return null;
	}

	@Override
	public Query createNamedQuery(String query) {
		// dont need
		return null;
	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		// dont need
	}

	@Override
	public EntityManager getEntityManager() {
		// dont need
		return null;
	}

	@Override
	public Class<Objet> getEntityType() {
		// dont need
		return null;
	}

	@Override
	public void createObjet(Objet objet) {
		if(!objets.contains(objet)){
			objets.add(objet);
		}
	}

	@Override
	public void updateObjet(Objet objet) {
		if(objets.contains(objet)){
			objets.remove(objet);
			objets.add(objet);
		}
	}

	@Override
	public void deleteObjet(Objet objet) {
		if(objets.contains(objet)){
			objets.remove(objet);
		}
	}

	@Override
	public List<Objet> findObjet(Objet objet) {
		ArrayList<Objet> found= new ArrayList<Objet>();
		for(Objet o : objets){
			if(o.getContent().equals(objet.getContent())
					&& o.getType().equals(objet.getType())
					&& o.getDescription().equals(objet.getDescription()))
				found.add(o);
		}
		return found;
	}
	
}