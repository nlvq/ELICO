package main;

import ihm.AdminWindow;
import ihm.IWindow;
import ihm.TestWorkWindow;

public class MainIHM {
    public static void main(String args[]) {
        IWindow window = new AdminWindow();
        //IWindow window = new TestWorkWindow();
        //IWindow window = new TestValidateCancelWindow();
        window.createWindow();
        window.openWindow();
    }
}
