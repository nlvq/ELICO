package coeur_metier.livre;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import dao.IObjetDAO;
import dao.Objet;

public class LivreTest {
	private IObjetDAO dao = new SimulateObjetDAO();
	private ILivre livre = new Livre(dao);

	@Before
	public void setUpBeforeClass() throws Exception {
	}

	@Test
	public void testCreateObject() {
		Objet object = new Objet();
		object.setType("Livre");
		livre.CreateObject(object);
		List<Objet> list = dao.findAll();
		Objet o = list.get(0);
		assertEquals(o.getType(), "Livre");
		assertEquals(list.size(), 1);

	}

	@Test
	public void testCreateChapter() {
		Objet object = new Objet();
		livre.CreateObject(object);
		List<Objet> list = dao.findAll();
		Objet o = list.get(0);
		assertEquals(o.getType(), "Chapter");

	}

	@Test
	public void testCreateVolume() {
		Objet object = new Objet();
		livre.CreateVolume(object);
		List<Objet> list = dao.findAll();
		Objet o = list.get(0);
		assertEquals(o.getType(), "Volume");

	}

	@Test
	public void testCreateParagraph() {
		Objet object = new Objet();
		livre.CreateParagraph(object);
		List<Objet> list = dao.findAll();
		Objet o = list.get(0);
		assertEquals(o.getType(), "Paragraph");
	}

	@Test
	public void testUpdateObject() {
		Objet object = new Objet();

		livre.CreateParagraph(object);
		object.setType("Paragraph");
		object.setId(2L);
		List<Objet> list = dao.findAll();
		Objet o = list.get(0);
		assertEquals(o.getType(), "Paragraph");
		o.setType("Volume");
		livre.UpdateObject(o);
		assertEquals(o.getType(), "Volume");

	}

	@Test
	public void testDeleteObject() {
		Objet o = new Objet();
		livre.CreateObject(o);
		assertEquals(dao.findAll().size(), 1);
		livre.DeleteObject(o);
		assertEquals(dao.findAll().size(), 1);
	}

	@Test
	public void testFindObject() {

		Objet o = new Objet();

		livre.CreateObject(o);
		Objet fils = new Objet();
		livre.CreateChapter(fils);

		Objet toFind = new Objet();
		toFind.setId(1L);
		toFind.setParent(o);
		livre.FindObject(toFind);
	}

}
