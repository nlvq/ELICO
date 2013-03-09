package coeur_metier.livre;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.IObjetDAO;
import dao.Objet;

@Transactional
@Service("livre")
public class Livre implements ILivre {

	@Autowired
	private IObjetDAO objetDAO;

	/**
	 * @return the objetDAO
	 */
	public IObjetDAO getObjetDAO() {
		return objetDAO;
	}

	/**
	 * @param objetDAO the objetDAO to set
	 */
	public void setObjetDAO(IObjetDAO objetDAO) {
		this.objetDAO = objetDAO;
	}

	@Override
	public void createObject(Objet object) {
		object.setType("Livre");
		objetDAO.createObjet(object);
	}

	@Override
	public void createVolume(Objet object, Objet livrePere) {
		object.setType("Volume");
		object.setParent(livrePere);
		objetDAO.createObjet(object);
	}

	@Override
	public void createChapter(Objet object, Objet volPere) {
		object.setParent(volPere);
		object.setType("Chapter");
		objetDAO.createObjet(object);
	}

	@Override
	public void createParagraph(Objet object, Objet chapPere) {
		object.setType("Paragraph");
		object.setParent(chapPere);
		objetDAO.createObjet(object);
	}

	@Override
	public void updateObject(Objet object) {
		objetDAO.updateObjet(object);
	}

	@Override
	public void deleteObject(Objet object) {
		objetDAO.deleteObjet(object);
	}

	@Override
	public List<Objet> findObject(Objet object) {
		return objetDAO.findObjet(object);
	}

}
