package bookstore.presentation.controller;

import java.util.List;
import bookstore.logic.service.ServiceFactory;
import bookstore.logic.transfer.book.ITBook;
import bookstore.presentation.controller.events.BusinessEvent;
import bookstore.presentation.controller.events.GUIEvent;
import bookstore.presentation.view.BookStoreGUI;

/**
 * This class extends the abstract class <code>{@link Controller}</code>
 * <p>Pablo Albaladejo Mestre (pablo.albaladejo.mestre@gmail.com)</p>
 */

public class ControllerImp extends Controller{
  
    /**
     * This method select the View action depening on the Event
     * @param event an integer defined at <code>{@link bookstore.presentation.controller.events.BusinessEvent}</code>
     * @param data an <code>{@link Object}</code> data, to be used at the <code>{@link ControllerImp}</code>
     */
    @Override
    public void action(int Event, Object data){
        List<ITBook> list = null;
        ITBook book = null;
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
                list = ServiceFactory.getInstance().getBusinessFacade().getAllBooks();
                BookStoreGUI.getInstance().update(GUIEvent.REFRESH_ALL_BOOKS, list);
                break;
            case(BusinessEvent.GET_BOOK_ISBN):
                book = ServiceFactory.getInstance().getBusinessFacade().getBookByISBN((String)data);
                BookStoreGUI.getInstance().update(GUIEvent.REFRESH_BOOK, book);
                break;
            case(BusinessEvent.DELETE_BOOK_ISBN):
                result = ServiceFactory.getInstance().getBusinessFacade().DeleteBook((String)data);
                if(result){
                    list = ServiceFactory.getInstance().getBusinessFacade().getAllBooks();
                    BookStoreGUI.getInstance().update(GUIEvent.BOOK_DELETED, list);
                }else{
                    BookStoreGUI.getInstance().update(GUIEvent.ERROR_DELETING_BOOK, null);
                }
                break;
            case(BusinessEvent.ADD_BOOK):
                result = ServiceFactory.getInstance().getBusinessFacade().NewBook((ITBook)data);
                if(result){
                    list = ServiceFactory.getInstance().getBusinessFacade().getAllBooks();
                    BookStoreGUI.getInstance().update(GUIEvent.BOOK_ADDED, list);
                }else{
                    BookStoreGUI.getInstance().update(GUIEvent.ERROR_ADDING_BOOK, null);
                }
                break;
            case(BusinessEvent.MODIFY_BOOK):
                result = ServiceFactory.getInstance().getBusinessFacade().ModifyBook((ITBook)data);
                if(result){
                    list = ServiceFactory.getInstance().getBusinessFacade().getAllBooks();
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
