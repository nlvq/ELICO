package coeur_metier.wp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.criterion.Criterion;

import dao.IWorkPackageDAO;
import dao.WorkPackage;

public class SimulateWorkPackageDAO implements IWorkPackageDAO {

	private final HashMap<Long, WorkPackage> map=new HashMap<>();
	
	@Override
	public Session getHibernateSession() {
		return null;
	}

	@Override
	public List<WorkPackage> findByCriteria(Criterion... criteria) {
		return null;
	}

	@Override
	public List<WorkPackage> findByExample(WorkPackage instance,
			String[] excludeProperties) {
		return null;
	}

	@Override
	public boolean alreadyExists(Long key) {
		return map.containsKey(key);
	}

	@Override
	public WorkPackage getReference(Long id) {
		return map.get(id);
	}

	@Override
	public WorkPackage findById(Long id) {
		return getReference(id);
	}

	@Override
	public List<WorkPackage> findByQuery(String query) {
		return null;
	}

	@Override
	public WorkPackage findEntityByQuery(String query) {
		return null;
	}

	@Override
	public List<WorkPackage> findByNamedQuery(String query) {
		return null;
	}

	@Override
	public WorkPackage findEntityByNamedQuery(String query) {
		return null;
	}

	@Override
	public List<WorkPackage> findAll() {
		return new ArrayList<>(map.values());
	}

	@Override
	public Long findCountAll() {
		return (long) findAll().size();
	}

	@Override
	public WorkPackage persist(WorkPackage toPersist) {
		toPersist.setId((long) map.size());
		return map.put((long) map.size(), toPersist);
	}

	@Override
	public void remove(WorkPackage toRemove) {
		map.remove(toRemove);
	}

	@Override
	public void flush() {
	}

	@Override
	public void clear() {
	}

	@Override
	public boolean contains(WorkPackage isContained) {
		return map.containsValue(isContained);
	}

	@Override
	public void refresh(WorkPackage toRefresh) {
		map.put(toRefresh.getId(), toRefresh);
	}

	@Override
	public WorkPackage merge(WorkPackage toMerge) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Query createQuery(String query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Query createNativeQuery(String query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Query createNamedQuery(String query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		// TODO Auto-generated method stub

	}

	@Override
	public EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<WorkPackage> getEntityType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createWorkPackage(WorkPackage wp) {
		wp.setId((long) map.size());
		map.put((long) map.size(), wp);
	}

	@Override
	public void updateWorkPackage(WorkPackage wp) {
		refresh(wp);

	}

	@Override
	public void deleteWorkPackage(WorkPackage wp) {
		remove(wp);
	}

	@Override
	public List<WorkPackage> findWorkPackage(WorkPackage wp) {
		List<WorkPackage> list= new ArrayList<>();
		for(WorkPackage w: map.values()){
			if(wp.equals(w))
				list.add(w);
			if(wp.getId().equals(w.getId()))
				list.add(w);
			if(wp.getTitle().equals(w.getTitle()))
				list.add(w);
			if(wp.getOrganisation().equals(w.getOrganisation()))
				list.add(w);
		}
		return list;
	}

}
