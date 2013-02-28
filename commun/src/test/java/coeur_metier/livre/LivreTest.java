package coeur_metier.livre;

import static org.junit.Assert.assertEquals;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

import coeur_metier.wp.IWP;
import coeur_metier.wp.SimulateWorkPackageDAO;
import coeur_metier.wp.WorkPackageImpl;

import dao.IObjetDAO;
import dao.IWorkPackageDAO;
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
	public void testCreateVolume() {
		Objet object = new Objet();
		livre.CreateVolume(object);
		List<Objet> list = dao.findAll();
		Objet o = list.get(0);
		assertEquals(o.getType(), "Volume");

	}
	@Test
	public void testCreateChapter() {
		Objet object = new Objet();
		livre.CreateChapter(object);
		List<Objet> list = dao.findAll();
		Objet o = list.get(0);
		assertEquals(o.getType(), "Chapter");
		assertEquals(list.size(), 1);
		

	}
	@Test
	public void testUpdateObject() {
		
	
		
		Objet object = new Objet();
		livre.CreateParagraph(object);
		List<Objet> list = dao.findAll();
		Objet o = list.get(0);
		assertEquals((String)o.getType(), "Paragraph");
		o.setType("Volume");
		object.setId(2L);
		dao.updateObjet(o);
		list = dao.findAll();
		 o = list.get(0);
		assertEquals((String)o.getType(), "Volume");
		

	}


	

	@Test
	public void testCreateParagraph() {
		Objet object = new Objet();
		livre.CreateParagraph(object);
		List<Objet> list = dao.findAll();
		Objet o = list.get(0);
		assertEquals(o.getType(), "Paragraph");
		assertEquals(list.size(), 1);
		
		
	}

	
	@Test
	public void testDeleteObject() {
		Objet object = new Objet();
		object.setType("Livre");
		object.setId(1L);
		object.setParent(new Objet());
		livre.CreateObject(object);	
		List<Objet> list = dao.findAll();
		Objet o = list.get(0);
		assertEquals(o.getType(), "Livre");
		assertEquals(list.size(), 1);

		Objet toDel = new Objet();
		toDel.setId(1L);
		toDel.setParent((Objet)new Objet());
		toDel.setType((String)o.getType());
		
		livre.DeleteObject(toDel);
	    list = dao.findAll();
        assertEquals(list.size(), 0);
	
		
	}

	@Test
	public void testFindObject() {
		Objet object = new Objet();
		object.setType("Livre");
		object.setParent(new Objet());
		livre.CreateObject(object);
		List<Objet> list = dao.findAll();
		Objet o = list.get(0);
		assertEquals(o.getType(), "Livre");
		assertEquals(list.size(), 1);
		
		
		Objet toFind = new Objet();
		toFind.setId((Long)o.getId());
		toFind.setParent(new Objet());
		toFind.setType((String)o.getType());
		
		assertEquals((Long)toFind.getId(),(Long)list.get(0).getId() );
		livre.FindObject(list.get(0)).equals(toFind);
		
	}
	

}
