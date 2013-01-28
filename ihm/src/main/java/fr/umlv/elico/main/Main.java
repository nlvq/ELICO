package fr.umlv.elico.main;

import fr.umlv.elico.ihm.AdminWindow;
import fr.umlv.elico.ihm.IWindow;
import fr.umlv.elico.ihm.TestValidateCancelWindow;
import fr.umlv.elico.ihm.TestWorkWindow;

public class Main {
    public static void main(String args[]) {
        //IWindow window = new AdminWindow();
        //IWindow window = new TestWorkWindow();
        IWindow window = new TestValidateCancelWindow();
        window.createWindow();
        window.openWindow();
    }
}
