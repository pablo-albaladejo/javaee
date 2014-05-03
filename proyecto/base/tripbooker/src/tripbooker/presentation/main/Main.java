package tripbooker.presentation.main;

import tripbooker.presentation.controller.Controller;
import tripbooker.presentation.controller.event.BusinessEvent;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public class Main {
    public static void main(String[] args) {
        Controller.getInstance().action(BusinessEvent.APP_START, null);
    }
}
