package tripbooker.presentation.controller;

import tripbooker.presentation.controller.event.BusinessEvent;
import tripbooker.presentation.view.TripBookerGUI;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public class ControllerImp extends Controller{

    @Override
    public void action(int event, Object data) {
        switch(event){
            case BusinessEvent.APP_START:
                TripBookerGUI.getInstance().setVisible(true);
                break;
            default:
                
                break;
        }
    }

}
