package bookstore.presentation.main;

import bookstore.presentation.controller.Controller;
import bookstore.presentation.controller.events.BusinessEvent;

/**
 *
 * <p>Pablo Albaladejo Mestre (pablo.albaladejo.mestre@gmail.com)</p>
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
