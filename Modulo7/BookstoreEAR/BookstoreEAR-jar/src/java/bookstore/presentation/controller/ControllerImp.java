package bookstore.presentation.controller;

import java.util.List;
import ejb.bean.book.IBookBean;
import bookstore.presentation.controller.events.BusinessEvent;
import bookstore.presentation.controller.events.GUIEvent;
import bookstore.presentation.view.BookStoreGUI;
import ejb.logic.facade.IBusinessFacade;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * This class extends the abstract class <code>{@link Controller}</code>
 * <p>Pablo Albaladejo Mestre (pablo.albaladejo.mestre@gmail.com)</p>
 */

public class ControllerImp extends Controller{

    private IBusinessFacade facade;

    public ControllerImp() {
        try {
            Context ctx = new InitialContext();
            facade = (IBusinessFacade)ctx.lookup("java:global/BookstoreEAR/BookstoreEAR-ejb/Facade");
        } catch (NamingException ex) {
            ex.printStackTrace();
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
                list = facade.getAllBooks();
                BookStoreGUI.getInstance().update(GUIEvent.REFRESH_ALL_BOOKS, list);
                break;
            case(BusinessEvent.GET_BOOK_ISBN):
                book = facade.getBookByISBN((String)data);
                BookStoreGUI.getInstance().update(GUIEvent.REFRESH_BOOK, book);
                break;
            case(BusinessEvent.DELETE_BOOK_ISBN):
                result = facade.DeleteBook((String)data);
                if(result){
                    list = facade.getAllBooks();
                    BookStoreGUI.getInstance().update(GUIEvent.BOOK_DELETED, list);
                }else{
                    BookStoreGUI.getInstance().update(GUIEvent.ERROR_DELETING_BOOK, null);
                }
                break;
            case(BusinessEvent.ADD_BOOK):
                result = facade.NewBook((IBookBean)data);
                if(result){
                    list = facade.getAllBooks();
                    BookStoreGUI.getInstance().update(GUIEvent.BOOK_ADDED, list);
                }else{
                    BookStoreGUI.getInstance().update(GUIEvent.ERROR_ADDING_BOOK, null);
                }
                break;
            case(BusinessEvent.MODIFY_BOOK):
                result = facade.ModifyBook((IBookBean)data);
                if(result){
                    list = facade.getAllBooks();
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
