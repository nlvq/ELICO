package coeur_metier.ws;

import java.util.List;

import dao.WorkPackage;
import dao.WorkSpace;

public interface IWS {
	
	/**
	 * Creer un WorkSpace dans la BDD.
	 * @param name, le nom de WS.
	 * @param parentWs, le WS parent.
	 * @param orga, l'organisation au quel il est rattaché.
	 * @param list, la liste des WP liés.
	 */
	public void createWS(String name, WorkSpace parentWs, String orga, List<WorkPackage> list);
	
	/**
	 * Mets a jour le WS.
	 * @param ws, mets a jour le WS
	 */
	public void updateWS(WorkSpace ws);
	
	/**
	 * Supprime le WS.
	 * @param ws, supprime le WS
	 */
	public void deleteWS(WorkSpace ws);
	
	/**
	 * Trouve un WS.
	 * @param ws
	 * @return le ws trouvé, null sinon
	 */
	public List<WorkSpace> findWS(WorkSpace ws);
	
	/**
	 * Demande WorkPackage, et prend le lock dans le WS.
	 * @param wp, le WP voulu
	 * @param ws
	 */
	public void acquireWP(WorkPackage wp, WorkSpace ws);
	
	/**
	 * Demande au WP d'etre debloqué pour ecriture.
	 * @param wp
	 */
	public void unlockWP(WorkPackage wp);
	
	/**
	 * Le WP demande a etre validé par une personne habilité a le faire.
	 * @param wp
	 */
	public void promoteWP(WorkPackage wp);
	
	/**
	 * Methode invoqué par le validateur ou toute personne habilité a le faire.
	 * Il accepte le WS, et le mets a jours dans la BDD.
	 * @param wp
	 */
	public void publishWP(WorkPackage wp);
	
	/**
	 * Cette methode sert aux validateurs pour refuser le WP.
	 * Si le WP est refusé le valideur doit indiquer la raison pour laquel il a ete refuse.
	 * @param wp
	 * @param reason, le motif du refus
	 */
	public void refuseWP(WorkPackage wp, String reason);
	
	/**
	 * Synchronize le WP locale et le WP en BDD.
	 * @param wp
	 */
	public void synchronizeWP(WorkPackage wp);
	
}
