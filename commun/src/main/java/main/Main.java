package main;

import ihm.AuthentificationLoginWindow;
import ihm.IWindow;

public class Main {

	/**
	 * Main method : create context and open authentification window.
	 * @param args
	 */
	public static void main(String[] args) {
		ContextUtil.createContext();
		IWindow window = new AuthentificationLoginWindow();
		window.createWindow();
		window.openWindow();
	}

}
