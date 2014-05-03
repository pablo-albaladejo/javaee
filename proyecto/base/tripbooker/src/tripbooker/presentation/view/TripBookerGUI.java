package tripbooker.presentation.view;

import javax.swing.JFrame;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public abstract class TripBookerGUI extends JFrame{
    private static TripBookerGUI instance;
    
    public static synchronized TripBookerGUI getInstance(){
        if(instance == null) instance = new TripBookerGUIImp();
        return instance;
    }
    
    public abstract void update(int event, Object data);
}
