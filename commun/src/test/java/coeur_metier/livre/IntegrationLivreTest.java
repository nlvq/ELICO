package coeur_metier.livre;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import dao.Objet;

@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/elico-persistence-test-context.xml" })
public class IntegrationLivreTest {

	@Resource(name="livre")
	private Livre livre;

	@Test
	public void testCreateObject() {
		Objet objet = new Objet();
		objet.setContent("content");
		objet.setDescription("description");
		livre.createObject(objet);
		List<Objet> list = livre.findObject(objet);
		assertEquals(list.size(), 1);
		assertEquals(list.get(0).getType(), "Livre");
		assertEquals(list.get(0).getContent(), "content");
		assertEquals(list.get(0).getDescription(), "description");
	}

	@Test
	public void testCreateVolume() {
		Objet objet = new Objet();
		objet.setContent("content");
		objet.setDescription("description");
		Objet livrePere = new Objet();
		livrePere.setContent("content2");
		livrePere.setDescription("description2");
		livre.createVolume(objet, livrePere);
		List<Objet> list = livre.findObject(objet);
		assertEquals(list.size(), 1);
		assertEquals(list.get(0).getType(), "Volume");
		assertEquals(list.get(0).getContent(), "content");
		assertEquals(list.get(0).getDescription(), "description");
		assertEquals(list.get(0).getParent().getContent(), "content2");
		assertEquals(list.get(0).getParent().getDescription(), "description2");
	}

	@Test
	public void testCreateChapter() {
		Objet objet = new Objet();
		objet.setContent("content");
		objet.setDescription("description");
		Objet volPere = new Objet();
		volPere.setContent("content2");
		volPere.setDescription("description2");
		livre.createChapter(objet, volPere);
		List<Objet> list = livre.findObject(objet);
		assertEquals(list.size(), 1);
		assertEquals(list.get(0).getType(), "Chapter");
		assertEquals(list.get(0).getContent(), "content");
		assertEquals(list.get(0).getDescription(), "description");
		assertEquals(list.get(0).getParent().getContent(), "content2");
		assertEquals(list.get(0).getParent().getDescription(), "description2");
	}

	@Test
	public void testCreateParagraph() {
		Objet objet = new Objet();
		objet.setContent("content");
		objet.setDescription("description");
		Objet chapPere = new Objet();
		chapPere.setContent("content2");
		chapPere.setDescription("description2");
		livre.createParagraph(objet, chapPere);
		List<Objet> list = livre.findObject(objet);
		assertEquals(list.size(), 1);
		assertEquals(list.get(0).getType(), "Paragraph");
		assertEquals(list.get(0).getContent(), "content");
		assertEquals(list.get(0).getDescription(), "description");
		assertEquals(list.get(0).getParent().getContent(), "content2");
		assertEquals(list.get(0).getParent().getDescription(), "description2");
	}

	@Test
	public void testUpdateObject() {
		Objet object = new Objet();
		object.setContent("content");
		object.setDescription("description");
		livre.createObject(object);
		object.setDescription("descriptionmodified");
		livre.updateObject(object);
		List<Objet> list = livre.findObject(object);
		assertEquals(list.size(), 1);
		assertEquals(list.get(0).getType(), "Livre");
		assertEquals(list.get(0).getContent(), "content");
		assertEquals(list.get(0).getDescription(), "descriptionmodified");
	}

	@Test
	public void testDeleteObject() {
		Objet object = new Objet();
		object.setContent("content");
		object.setDescription("description");
		livre.createObject(object);
		livre.deleteObject(object);
		List<Objet> list = livre.findObject(object);
		assertEquals(list.size(), 0);
	}

	@Test
	public void testFindObject() {
		Objet objet = new Objet();
		objet.setContent("content");
		objet.setDescription("description");
		livre.createObject(objet);
		Objet toFind = new Objet();
		toFind.setType("Livre");
		toFind.setContent("content");
		toFind.setDescription("description");
		List<Objet> list = livre.findObject(toFind);
		assertEquals(list.size(), 1);
		assertEquals(list.get(0).getType(), "Livre");
		assertEquals(list.get(0).getContent(), "content");
		assertEquals(list.get(0).getDescription(), "description");
	}

}
