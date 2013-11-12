package bookstore.presentation.main;

import bookstore.presentation.controller.Controller;
import bookstore.presentation.controller.events.BusinessEvent;

/**
 *
 * Pablo Albaladejo Mestre(pablo.albaladejo.mestre@gmail.com)
 */
public class Main {
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
            Controller.getInstance().action(BusinessEvent.INIT_APPLICATION,null);
	}
}
