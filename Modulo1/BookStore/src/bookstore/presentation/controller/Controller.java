package bookstore.presentation.controller;

/**
 * This class implements the Controller by a Singelton pattern
 * <p>Pablo Albaladejo Mestre (pablo.albaladejo.mestre@gmail.com)</p>
 */
public abstract class Controller {
    static private Controller instance;
    
    /**
     * Provides a instance of the Controller implementation
     * @return <code>{@link ControllerImp}</code>
     */
    static public  Controller getInstance(){
        if(instance == null) instance = new ControllerImp();
        return instance;
    }
    
    /**
     * This method select the View action depening on the Event
     * @param event an integer defined at <code>{@link bookstore.presentation.controller.events.BusinessEvent}</code>
     * @param data an <code>{@link Object}</code> data, to be used at the <code>{@link ControllerImp}</code>
     */
    public abstract void action(int event, Object data);
}
