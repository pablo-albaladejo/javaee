package bookstore.logic.author;

import bookstore.integration.ddbb.exception.TransactionException;
import bookstore.integration.ddbb.manager.TransactionManager;
import bookstore.integration.factory.DAOFactory;
import bookstore.logic.transfer.author.ITAuthor;
import bookstore.logic.transfer.book.ITBook;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * <p>Pablo Albaladejo Mestre (pablo.albaladejo.mestre@gmail.com)</p>
 */
public class AuthorApplicationService implements IAuthorApplicationService{
    /**
     * Searches all the Authors stored at the persistence
     * @return  The <code>{@link ITAuthor}</code> list including all the Authors;
     *          <code>null</code> if no Author is found.     
     */
    @Override
    public List<ITAuthor> getAllAuthors() {
        List<ITAuthor> list = null;
        try {
            TransactionManager.getInstance().begin();
            list = DAOFactory.getInstance().getAuthorDAO().getAllAuthors();
            TransactionManager.getInstance().close();
        } catch (TransactionException e) {// Error connecting to DDBB
            list = null;
        }finally{
            return list;
        }
    }
    
     /**
     * Searches all the Books written by an Author
     * @return  The <code>{@link ITBook}</code> list including all the books;
     *          <code>null</code> if no books is found.     
     */
    public List<ITBook> getBookByAuthor(String name){

        List<ITBook> bookList = new ArrayList<ITBook>();
        try {
            TransactionManager.getInstance().begin();
            
            List<ITAuthor> authors = DAOFactory.getInstance().getAuthorDAO().getAuthorByName(name);
            
            for(ITAuthor author :  authors){
                List<ITBook> books = DAOFactory.getInstance().getBookDAO().getBookByAuthorID(author.getID());
                bookList.addAll(books);
            }
            
            TransactionManager.getInstance().close();
        } catch (TransactionException ex) {
            bookList = null;
        }finally{
            return bookList;
        }   
    }
}
