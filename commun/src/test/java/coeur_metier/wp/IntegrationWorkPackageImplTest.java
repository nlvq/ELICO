package coeur_metier.wp;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import dao.Maturite.Etat;
import dao.Objet;
import dao.WorkPackage;

@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/elico-persistence-test-context.xml" })
public class IntegrationWorkPackageImplTest {
	
	@Resource(name="workPackageImpl")
	private WorkPackageImpl workPackageImpl;

	@Test
	public final void testCreateWP() {
		ArrayList<Objet> listObjet = new ArrayList<Objet>();
		Objet o1 = new Objet();
		o1.setContent("a a a");
		listObjet.add(o1);
		Objet o2 = new Objet();
		o2.setContent("b b b");
		listObjet.add(o2);
		workPackageImpl.createWP("wp01", listObjet);
		WorkPackage toFind = new WorkPackage();
		toFind.setTitle("wp01");
		List<WorkPackage> found = workPackageImpl.findWP(toFind);
		Assert.assertEquals(found.size(), 1);
		Assert.assertEquals(found.get(0).getTitle(), "wp01");
		Assert.assertEquals(found.get(0).getObjets().get(0).getContent(), "a a a");
		Assert.assertEquals(found.get(0).getObjets().get(0).getMaturite().getTitle(), Etat.NUL);
		Assert.assertEquals(found.get(0).getObjets().get(1).getContent(), "b b b");
		Assert.assertEquals(found.get(0).getObjets().get(1).getMaturite().getTitle(), Etat.NUL);
	}

	@Test
	public final void testUpdateWP() {
		workPackageImpl.createWP("wp02", null);
		WorkPackage toFind = new WorkPackage();
		toFind.setTitle("wp02");
		List<WorkPackage> found = workPackageImpl.findWP(toFind);
		Assert.assertEquals(found.size(), 1);
		Assert.assertEquals(found.get(0).getTitle(), "wp02");
		Assert.assertNull(found.get(0).getStartDate());
		DateTime dt = new DateTime();
		found.get(0).setStartDate(dt);
		workPackageImpl.updateWP(found.get(0));
		found = workPackageImpl.findWP(toFind);
		Assert.assertEquals(found.size(), 1);
		Assert.assertEquals(found.get(0).getTitle(), "wp02");
		Assert.assertEquals(found.get(0).getStartDate(), dt);
	}

	@Test
	public final void testDeleteWP() {
		workPackageImpl.createWP("wp03", null);
		WorkPackage toFind = new WorkPackage();
		toFind.setTitle("wp03");
		List<WorkPackage> found = workPackageImpl.findWP(toFind);
		Assert.assertEquals(found.size(), 1);
		workPackageImpl.deleteWP(found.get(0));
		found = workPackageImpl.findWP(toFind);
		Assert.assertEquals(found.size(), 0);
	}
	
	@Test
	public final void testFindWP() {
		workPackageImpl.createWP("wp04", null);
		WorkPackage toFind = new WorkPackage();
		toFind.setTitle("wp04");
		List<WorkPackage> found = workPackageImpl.findWP(toFind);
		Assert.assertEquals(found.size(), 1);
		Assert.assertEquals(found.get(0).getTitle(), "wp04");
	}

}
