package bookstore.logic.book;

import bookstore.integration.factory.DAOFactory;
import bookstore.integration.ddbb.exception.TransactionException;
import bookstore.integration.ddbb.manager.TransactionManager;
import java.util.List;
import bookstore.logic.transfer.book.ITBook;

/**
 *
 * Pablo Albaladejo Mestre(pablo.albaladejo.mestre@gmail.com)
 */
public class BookApplicationService implements IBookApplicationService{

    /**
     * @param Book
     * @return
     */
    @Override
    public boolean NewBook(ITBook Book) {
        boolean result = false;
        try{
            if(this.getBookByISBN(Book.getISBN()) == null){
                TransactionManager.getInstance().begin();
                result = DAOFactory.getInstance().getBookDAO().NewBook(Book);
                TransactionManager.getInstance().commit();
            }else{
                result =  false;
            }
        }catch(TransactionException te){
            result = false;
        }finally{
            return result;
        }
    }
        /**
     *
     * @param ISBN
     * @return
     */
    @Override
    public boolean DeleteBook(String ISBN) {
        boolean result =  false;
        try{
            TransactionManager.getInstance().begin();
            result = DAOFactory.getInstance().getBookDAO().DeleteBook(ISBN);
            TransactionManager.getInstance().commit();
        }catch(TransactionException te){//Book not found
            result = false;
        }finally{
            return result;
        }
    }

    /**
     *
     * @return The complete <code>ITBook</code> list or <code>null</code> when no book is found
     */
    @Override
    public List<ITBook> getAllBooks() {
        List<ITBook> list = null;
        try {
            TransactionManager.getInstance().begin();
            list = DAOFactory.getInstance().getBookDAO().getAllBooks();
            TransactionManager.getInstance().close();
        } catch (TransactionException e) {// Error connecting to DDBB
            list = null;
        }finally{
            return list;
        }
    }

    /**
     *
     * @param ISBN
     * @return
     */
    @Override
    public ITBook getBookByISBN(String ISBN) {
        ITBook book = null;
        try{
            TransactionManager.getInstance().begin();
            book = DAOFactory.getInstance().getBookDAO().getBookByISBN(ISBN);
            TransactionManager.getInstance().close();
        }catch(TransactionException ex){ //Book not found
            book = null;
        }finally{
            return book;
        }
    }

    /**
     *
     * @param title
     * @return
     */
    @Override
    public List<ITBook> getBookByTitle(String title) {
        List<ITBook> list = null;
        try {
            TransactionManager.getInstance().begin();
            list = DAOFactory.getInstance().getBookDAO().getBookByTitle(title);
            TransactionManager.getInstance().close();
        } catch (TransactionException e1){
            list = null;
        } finally {
            return list;
        }
    }

    /**
     *
     * @param ISBN
     * @param price
     * @return
     */
    @Override
    public boolean ModifyBookPrice(String ISBN, double price) {
        boolean result = false;
        try{
            TransactionManager.getInstance().begin();
            result = DAOFactory.getInstance().getBookDAO().ModifyBookPrice(ISBN, price);
            TransactionManager.getInstance().commit();
        } catch (TransactionException ex){
            result = false;//Libro no encontrado
        } finally {
            return result;
        }
    }

    /**
     *
     * @param Book
     * @return
     */
    @Override
    public boolean ModifyBook(ITBook Book) {
        boolean result = false;
        try {
            result =  DAOFactory.getInstance().getBookDAO().ModifyBook(Book);
        } catch (TransactionException ex) {
            result = false;
        } finally {
            return result;
        }
    }
}
