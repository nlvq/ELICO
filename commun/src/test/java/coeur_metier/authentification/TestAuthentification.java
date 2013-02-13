package coeur_metier.authentification;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestAuthentification {
	
	private AuthentificationImpl authentificationImpl;
	
	@Before
	public void init(){
		authentificationImpl = new AuthentificationImpl();
		SimulateUtilisateurDAO utilisateurDAO = new SimulateUtilisateurDAO();
		authentificationImpl.setUtilisateurDAO(utilisateurDAO);
	}
	
	@Test
	public void testAuthentification(){
		// ok
		Assert.assertNotNull(authentificationImpl.auth("u1", "pwd"));
		// wrong password
		Assert.assertNull(authentificationImpl.auth("u1", "wrongpwd"));
		// unknown user
		Assert.assertNull(authentificationImpl.auth("dontexist", "pwd"));
	}
	
}
