package bookstore.presentation.controller;

/**
 *
 * <p>Pablo Albaladejo Mestre (pablo.albaladejo.mestre@gmail.com)</p>
 */
public abstract class Controller {
    static private Controller instance;
    
    /**
     *
     * @return
     */
    static public  Controller getInstance(){
        if(instance == null) instance = new ControllerImp();
        return instance;
    }
    
    /**
     *
     * @param event
     * @param data
     */
    public abstract void action(int event, Object data);
}
