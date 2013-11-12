package bookstore.presentation.view;

import javax.swing.JFrame;

/**
 *
 * Pablo Albaladejo Mestre(pablo.albaladejo.mestre@gmail.com)
 */
public abstract class BookStoreGUI extends JFrame{
    static private BookStoreGUI instance;
    
    /**
     *
     * @return
     */
    static public BookStoreGUI getInstance(){
        if(instance == null) instance = new BookStoreGUIImp();
        return instance;
    }
    
    /**
     *
     * @param Event
     * @param data
     */
    public abstract void update(int Event, Object data);
}