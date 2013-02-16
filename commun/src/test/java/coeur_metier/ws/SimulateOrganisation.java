package coeur_metier.ws;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.criterion.Criterion;

import dao.IOrganisationDAO;
import dao.Organisation;

public class SimulateOrganisation implements IOrganisationDAO {
	
	private Map<Long, Organisation> mapOrg=new HashMap<>();

	@Override
	public Session getHibernateSession() {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Organisation> findByCriteria(Criterion... criteria) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Organisation> findByExample(Organisation instance,
			String[] excludeProperties) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean alreadyExists(Long key) {
		return mapOrg.containsKey(key);
	}

	@Override
	public Organisation getReference(Long id) {
		return mapOrg.get(id);
	}

	@Override
	public Organisation findById(Long id) {
		return getReference(id);
	}

	@Override
	public List<Organisation> findByQuery(String query) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Organisation findEntityByQuery(String query) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Organisation> findByNamedQuery(String query) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Organisation findEntityByNamedQuery(String query) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Organisation> findAll() {
		return new ArrayList<>(mapOrg.values());
	}

	@Override
	public Long findCountAll() {
		return (long) findAll().size();
	}

	@Override
	public Organisation persist(Organisation toPersist) {
		toPersist.setId((long) mapOrg.size());
		return mapOrg.put((long) mapOrg.size(), toPersist);
	}

	@Override
	public void remove(Organisation toRemove) {
		mapOrg.remove(toRemove.getId());
	}

	@Override
	public void flush() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void clear() {
		mapOrg=new HashMap<>();
	}

	@Override
	public boolean contains(Organisation isContained) {
		return mapOrg.containsValue(isContained);
	}

	@Override
	public void refresh(Organisation toRefresh) {
		mapOrg.put(toRefresh.getId(), toRefresh);
	}

	@Override
	public Organisation merge(Organisation toMerge) {
		return toMerge;
	}

	@Override
	public Query createQuery(String query) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Query createNativeQuery(String query) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Query createNamedQuery(String query) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		throw new UnsupportedOperationException();
	}

	@Override
	public EntityManager getEntityManager() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Class<Organisation> getEntityType() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void createOrganisation(Organisation organisation) {
		mapOrg.put((long) mapOrg.size(), organisation);
	}

	@Override
	public void updateOrganisation(Organisation organisation) {
		refresh(organisation);
	}

	@Override
	public void deleteOrganisation(Organisation organisation) {
		remove(organisation);
	}

	@Override
	public List<Organisation> findOrganisation(Organisation organisation) {
		List<Organisation> list=new ArrayList<>();
		for(Organisation org: findAll()){
			if(organisation.getChilds()!=null && org.getChilds().equals(organisation.getChilds()))
					list.add(org);
			if(organisation.getId()!=null && org.getId().equals(organisation.getId()))
				list.add(org);
			if(organisation.getTitle()!=null && org.getTitle().equals(organisation.getTitle()))
				list.add(org);
			if(organisation.getType()!=null && org.getType().equals(organisation.getType()))
				list.add(org);
		}
		return list;
	}

}
