package coeur_metier.livre;

import java.util.List;

import dao.IObjetDAO;
import dao.Objet;
import dao.impl.DefaultObjetDAO;

public class Livre implements ILivre{
	private Objet obj;
	private IObjetDAO daoObjet; 
	
	

	public Livre(IObjetDAO dao) {
		super();
		this.daoObjet = dao;
	}

	@Override
	public void CreateObject(Objet object) {
		
		obj=new Objet();
		obj.setDescription(null);
		obj.setType("Livre");
		obj.setContent(null);
		obj.setParent(null);
		daoObjet.createObjet(obj);

		
	}

	@Override
	public void CreateChapter(Objet VolPere) {
		obj=new Objet();
		obj.setDescription(null);
		obj.setType("Chapter");
		obj.setContent(null);
		obj.setParent(VolPere);
		daoObjet.createObjet(obj);

		
	}

	@Override
	public void CreateVolume(Objet VolLivre) {
		obj=new Objet();
		obj.setDescription(null);
		obj.setType("Volume");
		obj.setContent(null);
		obj.setParent(VolLivre);
		daoObjet.createObjet(obj);
		
		
	}

	@Override
	public void CreateParagraph(Objet ChapPere) {
		obj=new Objet();
		obj.setDescription(null);
		obj.setType("Volume");
		obj.setContent(null);
		obj.setParent(ChapPere);
		daoObjet.createObjet(obj);
		
		
	}

	@Override
	public void UpdateObject(Objet object) {
		if (daoObjet.findObjet(object)!=null)
		daoObjet.updateObjet(object);
		else System.out.print("message :objet inexistant");
		
	}

	@Override
	public void DeleteObject(Objet object) {
		if (daoObjet.findObjet(object)!=null)
		daoObjet.deleteObjet(object);
			
	}

	@Override
	public List<Objet> FindObject(Objet object) {
		if (daoObjet.findObjet(object)==null)
		{System.out.print("Liste vide"); }
		return daoObjet.findObjet(object);
		
	}

}
