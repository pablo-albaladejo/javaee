package bookstore.presentation.controller;

import java.util.List;
import bookstore.presentation.controller.events.BusinessEvent;
import bookstore.presentation.controller.events.GUIEvent;
import bookstore.presentation.view.BookStoreGUI;
import static java.lang.System.exit;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import ws.dto.bean.book.BookBean;
import ws.dto.bean.book.IBookBean;
import ws.logic.facade.IBusinessFacade;

/**
 * This class extends the abstract class <code>{@link Controller}</code>
 * <p>Pablo Albaladejo Mestre (pablo.albaladejo.mestre@gmail.com)</p>
 */

public class ControllerImp extends Controller{

    private IBusinessFacade port;

    public ControllerImp() {
        URL url;
        try {
            url = new URL("http://127.0.0.1:9876/bookstore");
            QName qname = new QName("http://facade.logic.ws/","BusinessFacadeService");
            Service service = Service.create(url,qname);
            port = service.getPort(IBusinessFacade.class);
        } catch (MalformedURLException ex) {
            exit(-1);
        }
        
    }
        
    /**
     * This method select the View action depening on the Event
     * @param event an integer defined at <code>{@link bookstore.presentation.controller.events.BusinessEvent}</code>
     * @param data an <code>{@link Object}</code> data, to be used at the <code>{@link ControllerImp}</code>
     */
    @Override
    public void action(int Event, Object data){
        List<IBookBean> list = null;
        IBookBean book = null;
        Boolean result = null;
        
        switch (Event) {
            //Application
            case(BusinessEvent.INIT_APPLICATION):
                BookStoreGUI.getInstance().setVisible(true);
                BookStoreGUI.getInstance().update(GUIEvent.SEARCH_ALL_BOOKS, null);
                break;
            case(BusinessEvent.FINALIZE_APPLICATION):
                System.exit(0);
                break;
            
            //Book
            case(BusinessEvent.GET_ALL_BOOKS):
                list = new ArrayList<IBookBean>(Arrays.asList(port.getAllBooks()));
                BookStoreGUI.getInstance().update(GUIEvent.REFRESH_ALL_BOOKS, list);
                break;
            case(BusinessEvent.GET_BOOK_ISBN):
                book = port.getBookByISBN((String)data);
                BookStoreGUI.getInstance().update(GUIEvent.REFRESH_BOOK, book);
                break;
            case(BusinessEvent.DELETE_BOOK_ISBN):
                result = port.DeleteBook((String)data);
                if(result){
                    list = new ArrayList<IBookBean>(Arrays.asList(port.getAllBooks()));
                    BookStoreGUI.getInstance().update(GUIEvent.BOOK_DELETED, list);
                }else{
                    BookStoreGUI.getInstance().update(GUIEvent.ERROR_DELETING_BOOK, null);
                }
                break;
            case(BusinessEvent.ADD_BOOK):
                result = port.NewBook((BookBean)data);
                if(result){
                    list = new ArrayList<IBookBean>(Arrays.asList(port.getAllBooks()));
                    BookStoreGUI.getInstance().update(GUIEvent.BOOK_ADDED, list);
                }else{
                    BookStoreGUI.getInstance().update(GUIEvent.ERROR_ADDING_BOOK, null);
                }
                break;
            case(BusinessEvent.MODIFY_BOOK):
                result = port.ModifyBook((BookBean)data);
                if(result){
                    list = new ArrayList<IBookBean>(Arrays.asList(port.getAllBooks()));
                    BookStoreGUI.getInstance().update(GUIEvent.BOOK_MODIFIED, list);
                }else{
                    BookStoreGUI.getInstance().update(GUIEvent.ERROR_MODIFYING_BOOK, null);
                }
                break;
            //Default
            default:
                break;
        }
    }
}
