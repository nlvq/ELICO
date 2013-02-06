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
	 * Demande WorkPackage, et prend le lock.
	 * @param wp, le WP voulue
	 */
	public void acquireWP(WorkPackage wp);
	/**
	 * Demande a valider le WP par le validateur.
	 * @param wp
	 */
	public void promoteWP(WorkPackage wp);
	/**
	 * Envoie sur la BDD le WorkPackage.
	 * @param wp
	 */
	public void publishWP(WorkPackage wp);
	/**
	 * Synchronize le WP locale et le WP en BDD.
	 * @param wp.
	 */
	public void synchronizeWP(WorkPackage wp);
}
