package main;

import ihm.IWindow;
import ihm.ValidatorWindow;

import java.util.ArrayList;
import java.util.List;

import coeur_metier.rh.RH;
import coeur_metier.wp.WorkPackageImpl;
import coeur_metier.ws.WorkSpaceImpl;
import dao.Objet;
import dao.WorkPackage;
import dao.WorkSpace;

public class mainYas {

	private static void init() {
		RH rh = ContextUtil.getRH();
		rh.createOrga("elico", "enterprise", null);
		rh.createUser("admin", "firstname", "lastname", "0123456789", "elico",
				"admin");
		WorkPackageImpl wp = ContextUtil.getWorkPackage();
		ArrayList<Objet> listObjet = new ArrayList<Objet>();
		Objet o1 = new Objet();
		o1.setContent("a a a");
		listObjet.add(o1);
		Objet o2 = new Objet();
		o2.setContent("b b b");
		listObjet.add(o2);
		wp.createWP("wp10", listObjet);

		WorkSpaceImpl ws = ContextUtil.getWorkSpace();
		WorkPackage wpToFind = new WorkPackage();
		wpToFind.setTitle("wp10");
		List<WorkPackage> wpFound = wp.findWP(wpToFind);
		ws.createWS("ws10", null, "orga1", wpFound);
		WorkSpace tofind = new WorkSpace();
		tofind.setTitle("ws10");
		WorkSpace w = ws.findWS(tofind).get(0);
		w.setUtilisateur(rh.findUser("admin").get(0));
		ws.updateWS(w);
	}

	public static void main(String[] args) {
		ContextUtil.createContext();
		init();
		IWindow window = new ValidatorWindow();
		window.createWindow();
		window.openWindow();
	}
}
