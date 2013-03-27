package main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import coeur_metier.authentification.AuthentificationImpl;
import coeur_metier.livre.Livre;
import coeur_metier.rh.RH;
import coeur_metier.wp.WorkPackageImpl;
import coeur_metier.ws.WorkSpaceImpl;
import dao.UtilisateurOrganisationRole;

public class ContextUtil {
	
	/** the context */
	private static ClassPathXmlApplicationContext context;
	
	/**
	 * Create application context.
	 */
	public static void createContext(){
		// Singleton --> instantiate only once
		if(context == null){
			context = new ClassPathXmlApplicationContext("classpath:spring/elico-persistence-context.xml");
			context.start();
		}
	}
	
	public static AuthentificationImpl getAuthentification(){
		return (AuthentificationImpl) context.getBean("authentificationImpl");
	}
	
	public static Livre getLivre(){
		return (Livre) context.getBean("livre");
	}
	
	public static RH getRH(){
		return (RH) context.getBean("rh");
	}
	
	public static WorkPackageImpl getWorkPackage(){
		return (WorkPackageImpl) context.getBean("workPackageImpl");
	}
	
	public static WorkSpaceImpl getWorkSpace(){
		return (WorkSpaceImpl) context.getBean("workSpaceImpl");
	}

}
