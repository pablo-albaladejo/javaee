package bookstore.presentation.main;

import bookstore.presentation.controller.Controller;
import bookstore.presentation.controller.events.BusinessEvent;

/**
 * This is the main class of the application.
 * The GUI is launch here using the Controller
 * <p>Pablo Albaladejo Mestre (pablo.albaladejo.mestre@gmail.com)</p>
 */
public class Main {
    /**
     * Main method
     * @param args
     */
    public static void main(String[] args) {
            Controller.getInstance().action(BusinessEvent.INIT_APPLICATION,null);
	}
}
