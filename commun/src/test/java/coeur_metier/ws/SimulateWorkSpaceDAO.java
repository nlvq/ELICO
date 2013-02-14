package coeur_metier.ws;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.criterion.Criterion;

import dao.IWorkSpaceDAO;
import dao.WorkSpace;

public class SimulateWorkSpaceDAO implements IWorkSpaceDAO {

	private final HashMap<Long, WorkSpace> map=new HashMap<>();
	
	@Override
	public Session getHibernateSession() {
		return null;
	}

	@Override
	public List<WorkSpace> findByCriteria(Criterion... criteria) {
		return null;
	}

	@Override
	public List<WorkSpace> findByExample(WorkSpace instance,
			String[] excludeProperties) {
		return null;
	}

	@Override
	public boolean alreadyExists(Long key) {
		return map.containsKey(key);
	}

	@Override
	public WorkSpace getReference(Long id) {
		return map.get(id);
	}

	@Override
	public WorkSpace findById(Long id) {
		return getReference(id);
	}

	@Override
	public List<WorkSpace> findByQuery(String query) {
		return null;
	}

	@Override
	public WorkSpace findEntityByQuery(String query) {
		return null;
	}

	@Override
	public List<WorkSpace> findByNamedQuery(String query) {
		return null;
	}

	@Override
	public WorkSpace findEntityByNamedQuery(String query) {
		return null;
	}

	@Override
	public List<WorkSpace> findAll() {
		return new ArrayList<>(map.values());
	}

	@Override
	public Long findCountAll() {
		return (long) findAll().size();
	}

	@Override
	public WorkSpace persist(WorkSpace toPersist) {
		toPersist.setId((long) map.size());
		return map.put((long) map.size(), toPersist);
	}

	@Override
	public void remove(WorkSpace toRemove) {
		map.remove(toRemove);
	}

	@Override
	public void flush() {
	}

	@Override
	public void clear() {
	}

	@Override
	public boolean contains(WorkSpace isContained) {
		return map.containsValue(isContained);
	}

	@Override
	public void refresh(WorkSpace toRefresh) {
		map.put(toRefresh.getId(), toRefresh);
	}

	@Override
	public WorkSpace merge(WorkSpace toMerge) {
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
	public Class<WorkSpace> getEntityType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createWorkSpace(WorkSpace ws) {
		ws.setId((long) map.size());
		map.put((long) map.size(), ws);
	}

	@Override
	public void updateWorkSpace(WorkSpace ws) {
		refresh(ws);

	}

	@Override
	public void deleteWorkSpace(WorkSpace ws) {
		remove(ws);
	}

	@Override
	public List<WorkSpace> findWorkSpace(WorkSpace ws) {
		List<WorkSpace> list= new ArrayList<>();
		for(WorkSpace w: map.values()){
			if(ws.equals(w))
				list.add(w);
			if(ws.getId().equals(w.getId()))
				list.add(w);
			if(ws.getTitle().equals(w.getTitle()))
				list.add(w);
			if(ws.getOrganisation().equals(w.getOrganisation()))
				list.add(w);
			if(ws.getUtilisateur().equals(w.getUtilisateur()))
				list.add(w);
		}
		return list;
	}

}
