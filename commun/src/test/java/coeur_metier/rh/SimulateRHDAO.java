package coeur_metier.rh;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.criterion.Criterion;

import coeur_metier.livre.ILivre;

import dao.IUtilisateurDAO;
import dao.Objet;
import dao.Utilisateur;

public class SimulateRHDAO implements IUtilisateurDAO{
	
	private final HashMap<Long, Utilisateur> utilisateurs=new HashMap<>();
	@Override
	public Session getHibernateSession() {
		
		return null;
	}

	@Override
	public List<Utilisateur> findByCriteria(Criterion... criteria) {
		
		return null;
	}

	@Override
	public List<Utilisateur> findByExample(Utilisateur instance,
			String[] excludeProperties) {
		
		return null;
	}

	@Override
	public boolean alreadyExists(Long key) {
		utilisateurs.containsKey(key);
		return false;
	}

	@Override
	public Utilisateur getReference(Long id) {
		
		return utilisateurs.get(id);
		
	}

	@Override
	public Utilisateur findById(Long id) {
		return getReference(id);
		
	}

	@Override
	public List<Utilisateur> findByQuery(String query) {
		
		return null;
	}

	@Override
	public Utilisateur findEntityByQuery(String query) {
		
		return null;
	}

	@Override
	public List<Utilisateur> findByNamedQuery(String query) {
		
		return null;
	}

	@Override
	public Utilisateur findEntityByNamedQuery(String query) {
		
		return null;
	}

	@Override
	public List<Utilisateur> findAll() {
		return new ArrayList<>(utilisateurs.values());
	
	}

	@Override
	public Long findCountAll() {
		return (long) findAll().size();
		
	}

	@Override
	public Utilisateur persist(Utilisateur toPersist) {
		if (utilisateurs.containsKey(toPersist.getId()))
		  {
			toPersist.setId((long) utilisateurs.size());
			return utilisateurs.put((long) utilisateurs.size(), toPersist);
			}else return(null);
	}

	@Override
	public void remove(Utilisateur toRemove) {
		if (utilisateurs.containsKey(toRemove.getId()))
		  {
			utilisateurs.remove(toRemove);
		  }	
		
	}

	@Override
	public void flush() {
		
	}

	@Override
	public void clear() {
		
	}

	@Override
	public boolean contains(Utilisateur isContained) {
		
		return utilisateurs.containsValue(isContained);
	}

	@Override
	public void refresh(Utilisateur toRefresh) {
		utilisateurs.put(toRefresh.getId(), toRefresh);
		
	}

	@Override
	public Utilisateur merge(Utilisateur toMerge) {
		
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
		return null;
	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		
	}

	@Override
	public EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<Utilisateur> getEntityType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createUtilisateur(Utilisateur utilisateur) {
		
		if (!utilisateurs.containsKey(utilisateur.getId())){
			utilisateur.setId((long)utilisateurs.size());
			utilisateurs.put((long)utilisateurs.size(), utilisateur);
		}
		
	}

	@Override
	public void updateUtilisateur(Utilisateur utilisateur) {
		if(utilisateurs.containsValue(utilisateur))
			refresh(utilisateur);
		
	}

	@Override
	public void deleteUtilisateur(Utilisateur utilisateur) {
		if(utilisateurs.containsValue(utilisateur))
			remove(utilisateur);
		
	}

	@Override
	public List<Utilisateur> findUtilisateur(Utilisateur utilisateur) {
		ArrayList<Utilisateur> found= new ArrayList<Utilisateur>();
		for(Utilisateur u : utilisateurs.values()){
			// Add user if login and password are equals:
			if(u.getLogin().equals(utilisateur.getLogin())
					&& u.getPassword().equals(utilisateur.getPassword()))
				found.add(u);
		}
		return found;
	}
	

}
