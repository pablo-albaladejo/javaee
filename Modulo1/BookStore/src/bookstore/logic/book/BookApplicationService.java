package bookstore.logic.book;

import bookstore.integration.factory.DAOFactory;
import bookstore.integration.ddbb.exception.TransactionException;
import bookstore.integration.ddbb.manager.TransactionManager;
import java.util.List;
import bookstore.logic.transfer.book.ITBook;

/**
 * This class implements the <code>{@link IBookApplicationService}</code> interface
 * <p>Pablo Albaladejo Mestre (pablo.albaladejo.mestre@gmail.com)</p>
 */
public class BookApplicationService implements IBookApplicationService{

    /**
     *  Adds a new Book to the DDBB
     *
     * @param   Book The Book transfer to be added
     * @return  <code>true</code> if the book is propertly added;
     *          <code>false</code> otherwise
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
     *  Removes a Book from the persistence identified by the ISBN
     * 
     * @param   ISBN The string which defines a unique Book identifier
     * @return  <code>true</code> if the Book is propertly deleted;
     *          <code>flase</code> otherwise
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
     *  Searches all the Books stored at the persistence
     * @return  The <code>{@link ITBook}</code> list including all the Books;
     *          <code>null</code> if no Book is found.     
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
     * Searches a list of existing Books at the persistence identified by the Title
     * @param   title The Book title
     * @return  The <code>{@link ITBook}</code> list filtered by title;
     *          <code>null</code> if no Book is found.
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
     * Searches a list of existing Books at the persistence identified by the Title
     * @param   title The Book title
     * @return  The <code>{@link ITBook}</code> list filtered by title;
     *          <code>null</code> if no Book is found.
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
     * Modifies the price of the Book identified by the provded ISBN
     * @param ISBN The string which defines a unique Book identifier
     * @param price The new price to be updated
     * @return <code>true</code> if the books is updated;
     *         <code>false</code> otherwise
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
     * Modifies the whole data stored into the DDBB
     * @param The <code>{@link ITBook}</code> to including the data to be updated
     * @return <code>true</code> if the books is updated;
     *         <code>false</code> otherwise 
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
