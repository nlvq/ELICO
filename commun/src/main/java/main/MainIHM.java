package main;

import ihm.AdminWindow;
import ihm.AuthentificationLoginWindow;
import ihm.Editor;
import ihm.IWindow;
import ihm.SupervisorWindow;
import ihm.WSWindow;

public class MainIHM {
    public static void main(String args[]) {
        IWindow window = new AdminWindow();
        //IWindow window = new WSWindow();
    	//new Editor();
    
        //IWindow window = Editor();
        //window.createWindow();
        //window.openWindow();
        
        //IWindow window = new WSWindow();
        //Editor editor = new Editor();

       // IWindow window = new SupervisorWindow();
    	//IWindow window = new AuthentificationLoginWindow();
        window.createWindow();
        window.openWindow();
    }
}
