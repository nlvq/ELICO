package main;

import ihm.AddUserWindow;
import ihm.AdminWindow;
import ihm.AuthentificationLoginWindow;
import ihm.IWindow;
import ihm.ValidatorWindow;

import java.io.IOException;

import org.junit.Test;

public class MainTest {

	@Test
	public void testLogin() throws IOException {

		IWindow window = new AuthentificationLoginWindow();
		window.createWindow();
		window.openWindow();
		System.in.read();
	}

	@Test
	public void testAdmin() throws IOException {
		IWindow window = new AdminWindow();
		window.createWindow();
		window.openWindow();
		System.in.read();
	}
	
	@Test
	public void testValid() throws IOException {
		IWindow window = new ValidatorWindow();
		window.createWindow();
		window.openWindow();
		System.in.read();
	}

	@Test
	public void testAjoutAdmin() throws IOException {
		IWindow window = new AddUserWindow();
		window.createWindow();
		window.openWindow();
		System.in.read();
	}

}
