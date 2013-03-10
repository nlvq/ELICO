package coeur_metier.ws;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.criterion.Criterion;

import dao.IOrganisationDAO;
import dao.Organisation;

public class SimulateOrganisationDAO implements IOrganisationDAO{
	
	private ArrayList<Organisation> organisations;
	
	public SimulateOrganisationDAO(){
		organisations = new ArrayList<Organisation>();
	}

	@Override
	public Session getHibernateSession() {
		// dont need
		return null;
	}

	@Override
	public List<Organisation> findByCriteria(Criterion... criteria) {
		// dont need
		return null;
	}

	@Override
	public List<Organisation> findByExample(Organisation instance,
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
	public Organisation getReference(Long id) {
		// dont need
		return null;
	}

	@Override
	public Organisation findById(Long id) {
		// dont need
		return null;
	}

	@Override
	public List<Organisation> findByQuery(String query) {
		// dont need
		return null;
	}

	@Override
	public Organisation findEntityByQuery(String query) {
		// dont need
		return null;
	}

	@Override
	public List<Organisation> findByNamedQuery(String query) {
		// dont need
		return null;
	}

	@Override
	public Organisation findEntityByNamedQuery(String query) {
		// dont need
		return null;
	}

	@Override
	public List<Organisation> findAll() {
		// dont need
		return null;
	}

	@Override
	public Long findCountAll() {
		// dont need
		return null;
	}

	@Override
	public Organisation persist(Organisation toPersist) {
		// dont need
		return null;
	}

	@Override
	public void remove(Organisation toRemove) {
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
	public boolean contains(Organisation isContained) {
		// dont need
		return false;
	}

	@Override
	public void refresh(Organisation toRefresh) {
		// dont need
	}

	@Override
	public Organisation merge(Organisation toMerge) {
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
	public Class<Organisation> getEntityType() {
		// dont need
		return null;
	}

	@Override
	public void createOrganisation(Organisation organisation) {
		if(!organisations.contains(organisation)){
			organisations.add(organisation);
		}
	}

	@Override
	public void updateOrganisation(Organisation organisation) {
		if(organisations.contains(organisation)){
			organisations.remove(organisation);
			organisations.add(organisation);
		}
	}

	@Override
	public void deleteOrganisation(Organisation organisation) {
		if(organisations.contains(organisation)){
			organisations.remove(organisation);
		}
	}

	@Override
	public List<Organisation> findOrganisation(Organisation organisation) {
		ArrayList<Organisation> found= new ArrayList<Organisation>();
		for(Organisation o : organisations){
			if(o.getTitle().equals(organisation.getTitle()))
				found.add(o);
		}
		return found;
	}
	
}