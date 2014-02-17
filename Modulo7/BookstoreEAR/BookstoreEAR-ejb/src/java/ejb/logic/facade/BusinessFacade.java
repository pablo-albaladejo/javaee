package ejb.logic.facade;

import ejb.bean.book.BookBean;
import java.util.List;
import ejb.logic.service.ServiceFactory;
import ejb.bean.book.IBookBean;
import ejb.bean.factory.BeanFactory;
import ejb.persistence.exception.TransactionException;
import ejb.persistence.manager.PersistenceManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * This class implements the
 * <code>{@link IBusinessFacade}</code>. It also implements the Facade Pattern
 * and provides a single view from the logic layer to the presentation layer.
 * <p>Pablo Albaladejo Mestre (pablo.albaladejo.mestre@gmail.com)</p>
 */
@Stateless(name="Facade")
public class BusinessFacade implements IBusinessFacade {
    
    
    public BusinessFacade() {
        
    }

    /**
     * Adds a new Book to the DDBB
     *
     * @param Book The Book transfer to be added
     * @return  <code>true</code> if the book is propertly added;
     * <code>false</code> otherwise
     */
    @Override
    public boolean NewBook(IBookBean Book) {
        try {
            ServiceFactory.getInstance().getBookService().NewBook(Book);
        } catch (TransactionException ex) {
            Logger.getLogger(BusinessFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
        /*boolean result = false;
        EntityTransaction transaction = PersistenceManager.getInstance().getEntityManager().getTransaction();
        transaction.begin();
        try{
            ServiceFactory.getInstance().getBookService().NewBook(Book);
            transaction.commit();
            result = true;
        }catch (TransactionException e){
            transaction.rollback();
        }catch (Exception e){
            
        }
        return result;*/
    }

    /**
     * Removes a Book from the persistence identified by the ISBN
     *
     * @param ISBN The string which defines a unique Book identifier
     * @return  <code>true</code> if the Book is propertly deleted;
     * <code>flase</code> otherwise
     */
    @Override
    public boolean DeleteBook(String ISBN) {
        return ServiceFactory.getInstance().getBookService().DeleteBook(ISBN);
    }

    /**
     * Searches all the Books stored at the persistence
     *
     * @return The <code>{@link IBookBean}</code> list including all the Books;
     * <code>null</code> if no Book is found.
     */
    @Override
    public List<IBookBean> getAllBooks() {
        return ServiceFactory.getInstance().getBookService().getAllBooks();
    }

    /**
     * Searches a Book from the persistence identified by the ISBN
     *
     * @param ISBN The string which defines a unique Book identifier
     * @return The <code>{@link IBookBean}</code> if it is found; <code>null</code>
     * if the Book is not found.
     */
    @Override
    public IBookBean getBookByISBN(String ISBN) {
        return ServiceFactory.getInstance().getBookService().getBookByISBN(ISBN);
    }

    /**
     * Searches a list of existing Books at the persistence identified by the
     * Title
     *
     * @param title The Book title
     * @return The <code>{@link IBookBean}</code> list filtered by title;
     * <code>null</code> if no Book is found.
     */
    @Override
    public List<IBookBean> getBookByTitle(String title) {
        return ServiceFactory.getInstance().getBookService().getBookByTitle(title);
    }

    /**
     * Modifies the price of the Book identified by the provded ISBN
     *
     * @param ISBN The string which defines a unique Book identifier
     * @param price The new price to be updated
     * @return <code>true</code> if the books is updated; <code>false</code>
     * otherwise
     */
    @Override
    public boolean ModifyBookPrice(String ISBN, double price) {
        return ServiceFactory.getInstance().getBookService().ModifyBookPrice(ISBN, price);
    }

    /**
     * Modifies the whole data stored into the DDBB
     *
     * @param Book The <code>{@link IBookBean}</code> to including the data to be
     * updated
     * @return <code>true</code> if the books is updated; <code>false</code>
     * otherwise
     */
    @Override
    public boolean ModifyBook(IBookBean Book) {
        return ServiceFactory.getInstance().getBookService().ModifyBook(Book);
    }

    /**
     * Searches all the Authors stored at the persistence
     *
     * @return The <code>String</code> list including all the Authors;
     * <code>null</code> if no Author is found.
     */
    @Override
    public List<String> getAllAuthors() {
        return ServiceFactory.getInstance().getBookService().getAllAuthors();
    }

    /**
     * Searches a list of existing Books at the persistence identified by the
     * Author
     *
     * @param author The Book author
     * @return The <code>{@link IBookBean}</code> list filtered by author;
     * <code>null</code> if no Book is found.
     */
    @Override
    public List<IBookBean> getBookByAuthor(String name) {
        return ServiceFactory.getInstance().getBookService().getBookByAuthor(name);
    }

    /**
     * Searches all the Editorials stored at the persistence
     *
     * @return The <code>String</code> list including all the Editorials;
     * <code>null</code> if no Author is found.
     */
    @Override
    public List<String> getAllEditorials(){
        return ServiceFactory.getInstance().getBookService().getAllEditorials();
    }
    
    /**
     * Searches a list of existing Books at the persistence identified by the
     * Editorial
     *
     * @param editorial The Book editorial
     * @return The <code>{@link IBookBean}</code> list filtered by editorial;
     * <code>null</code> if no Book is found.
     */
    @Override
    public List<IBookBean> getBookByEditorial(String editorial) {
        return ServiceFactory.getInstance().getBookService().getBookByEditorial(editorial);
    }
}
