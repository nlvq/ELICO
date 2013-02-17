package main;

import ihm.AdminWindow;
import ihm.Editor;
import ihm.IWindow;
import ihm.SupervisorWindow;

public class MainIHM {
    public static void main(String args[]) {
        //IWindow window = new AdminWindow();
        //IWindow window = new WSWindow();
    	//new Editor();
    
        //IWindow window = Editor();
        //window.createWindow();
        //window.openWindow();

        IWindow window = new SupervisorWindow();
        window.createWindow();
        window.openWindow();
    }
}
