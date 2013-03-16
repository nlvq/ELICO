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
		WorkPackageImpl wp = ContextUtil.getWorkPackage();
		WorkSpaceImpl ws = ContextUtil.getWorkSpace();
		
		rh.createUser("admin", "firstname", "lastname", "0123456789", "elico", "admin");
		rh.createUser("ing", "firstname", "lastname", "0123456789", "elico", "ing");
		
		ArrayList<Objet> listObjet1 = new ArrayList<Objet>();
		Objet o1 = new Objet();
		o1.setContent("a a a");
		listObjet1.add(o1);
		Objet o2 = new Objet();
		o2.setContent("b b b");
		listObjet1.add(o2);
		wp.createWP("wp10", listObjet1);
		
		ArrayList<Objet> listObjet2 = new ArrayList<Objet>();
		Objet o3 = new Objet();
		o3.setContent("ccc");
		listObjet2.add(o3);
		Objet o4 = new Objet();
		o4.setContent("ddd");
		listObjet2.add(o4);
		wp.createWP("wp20", listObjet2);

		WorkPackage wpToFind = new WorkPackage();
		wpToFind.setTitle("wp10");
		List<WorkPackage> wpFound = wp.findWP(wpToFind);
		ws.createWS("ws10", null, "orga1", wpFound);
		WorkSpace tofind = new WorkSpace();
		tofind.setTitle("ws10");
		WorkSpace w = ws.findWS(tofind).get(0);
		w.setUtilisateur(rh.findUser("admin").get(0));
		ws.updateWS(w);

		wpToFind = new WorkPackage();
		wpToFind.setTitle("wp20");
		WorkPackage wpp = wp.findWP(wpToFind).get(0);
		wpp.setWorkSpace(ws.findWS(tofind).get(0));
		wp.updateWP(wpp);
	}

	public static void main(String[] args) {
		ContextUtil.createContext();
		init();
		IWindow window = new ValidatorWindow();
		window.createWindow();
		window.openWindow();
	}
}
