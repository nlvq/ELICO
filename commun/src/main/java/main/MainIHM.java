package main;

import ihm.Editor;
import ihm.AdminWindow;
import ihm.IWindow;
import ihm.SupervisorWindow;
import ihm.TestTreeWindow;

public class MainIHM {
    public static void main(String args[]) {
        //IWindow window = new AdminWindow();
        //IWindow window = new TestWorkWindow();
        //IWindow window = new TestValidateCancelWindow();
        //IWindow window = new WSWindow();
    	new Editor();
    
        //IWindow window = Editor();
        //window.createWindow();
        //window.openWindow();

        //IWindow window = new TestTreeWindow();
        IWindow window = new SupervisorWindow();
        window.createWindow();
        window.openWindow();
    }
}
