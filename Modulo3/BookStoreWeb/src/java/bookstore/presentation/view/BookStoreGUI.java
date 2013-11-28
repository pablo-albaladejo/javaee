package bookstore.presentation.view;

import javax.swing.JFrame;

/**
 * This class defines a Singleton patter for the view layer.
 * Provides the interface for the diferents implementatios of the GUI.
 * Only one object is stored at the memory
 * <p>Pablo Albaladejo Mestre (pablo.albaladejo.mestre@gmail.com)</p>
 */
public abstract class BookStoreGUI extends JFrame{
    static private BookStoreGUI instance;
    
    /**
     * A unique object wich extends the abstract class
     * @return <code>{@link BookStoreGUI}</code>
     */
    static public BookStoreGUI getInstance(){
        if(instance == null) instance = new BookStoreGUIImp();
        return instance;
    }
    
    /**
     * This method recieves a <code>{@link bookstore.presentation.controller.events.GUIEvent}</code> an perform the GUI update
     * @param Event the integer defined at <code>{@link bookstore.presentation.controller.events.GUIEvent}</code>
     * @param data <code>{@link Object}</code> data to be use at the update
     */
    public abstract void update(int Event, Object data);
}
