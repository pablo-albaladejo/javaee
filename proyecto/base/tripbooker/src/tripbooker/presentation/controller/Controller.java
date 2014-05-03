package tripbooker.presentation.controller;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public abstract class Controller {
    private static Controller instance;
    
    public static synchronized Controller getInstance(){
        if(instance == null) instance = new ControllerImp();
        return instance;
    }
    
    public abstract void action(int event, Object data);
}
