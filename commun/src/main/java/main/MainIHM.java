package main;

import ihm.IWindow;
import ihm.TestTreeWindow;

public class MainIHM {
    public static void main(String args[]) {
        //IWindow window = new AdminWindow();
        //IWindow window = new TestWorkWindow();
        //IWindow window = new TestValidateCancelWindow();
        //IWindow window = new WSWindow();
        IWindow window = new TestTreeWindow();
        window.createWindow();
        window.openWindow();
    }
}
