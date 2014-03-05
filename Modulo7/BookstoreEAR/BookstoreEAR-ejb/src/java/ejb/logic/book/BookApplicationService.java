package ejb.logic.book;

import java.util.List;
import ejb.bean.book.IBookBean;
import ejb.integration.factory.DAOFactory;
import ejb.persistence.database.manager.TransactionManager;
import ejb.persistence.database.exception.TransactionException;

/**
 * This class implements the
 * <code>{@link IBookApplicationService}</code> interface
 * <p>Pablo Albaladejo Mestre (pablo.albaladejo.mestre@gmail.com)</p>
 */
public class BookApplicationService implements IBookApplicationService {
    
    /**
     * Adds a new Book to the DDBB
     *
     * @param Book The Book transfer to be added
     * @return  <code>true</code> if the book is propertly added;
     * <code>false</code> otherwise
     */
    @Override
    public boolean NewBook(IBookBean Book) {
        boolean result = false;
        try {
            TransactionManager.getInstance().begin();
            result = DAOFactory.getInstance().getBookDAO().NewBook(Book);
            TransactionManager.getInstance().commit();
            TransactionManager.getInstance().close();
        } catch (TransactionException te) {
            TransactionManager.getInstance().close();
            if(this.getBookByISBN(Book.getISBN()) != null){
                //Book not added because ISBN already existis
                TransactionManager.getInstance().close();
                result = false;
            }else{
                //Error in transaction
                try { //try to rollback
                    TransactionManager.getInstance().rollback();
                    TransactionManager.getInstance().close();
                } catch (TransactionException ex) {
                    result = false;
                }
            }        
        }
        return result;
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
        boolean result = false;
        try {
            TransactionManager.getInstance().begin();
            result = DAOFactory.getInstance().getBookDAO().DeleteBook(ISBN);
            TransactionManager.getInstance().commit();
            TransactionManager.getInstance().close();
        } catch (TransactionException te) {//Book not found
            result = false;
        }
        return result;
    }

    /**
     * Searches all the Books stored at the persistence
     *
     * @return The <code>{@link IBookBean}</code> list including all the Books;
     * <code>null</code> if no Book is found.
     */
    @Override
    public List<IBookBean> getAllBooks() {
        List<IBookBean> list = null;
        try {
            list = DAOFactory.getInstance().getBookDAO().getAllBooks();
            TransactionManager.getInstance().close();
        } catch (TransactionException e) {// Error connecting to DDBB
            list = null;
        }
        return list;
    }

    /**
     * Searches a list of existing Books at the persistence identified by the
     * ISBN
     *
     * @param ISBN The Book title
     * @return The <code>{@link IBookBean}</code> list filtered by ISBN;
     * <code>null</code> if no Book is found.
     */
    @Override
    public IBookBean getBookByISBN(String ISBN) {
        IBookBean book;
        try {
            book = DAOFactory.getInstance().getBookDAO().getBookByISBN(ISBN);
            TransactionManager.getInstance().close();
        } catch (TransactionException ex) {
            book = null;
        }
        return book;
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
        List<IBookBean> list = null;
        try {
            list = DAOFactory.getInstance().getBookDAO().getBookByTitle(title);
            TransactionManager.getInstance().close();
        } catch (TransactionException e1) {
            list = null;
        }
        return list;
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
        boolean result = false;
        try {
            TransactionManager.getInstance().begin();
            result = DAOFactory.getInstance().getBookDAO().ModifyBookPrice(ISBN, price);
            TransactionManager.getInstance().commit();
            TransactionManager.getInstance().close();
        } catch (TransactionException ex) {
            result = false;//Libro no encontrado
        } 
        return result;
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
        boolean result = false;
        if(this.getBookByISBN(Book.getISBN()) != null){
            try {
                TransactionManager.getInstance().begin();
                result = DAOFactory.getInstance().getBookDAO().ModifyBook(Book);
                TransactionManager.getInstance().commit();
            } catch (TransactionException ex) {
                ex.printStackTrace();
                result = false;
            }
            TransactionManager.getInstance().close();
        }else{
            result = false;
        }
        return result;
    }

    /**
     * Searches all the Authors stored at the persistence
     *
     * @return The <code>String</code> list including all the Authors;
     * <code>null</code> if no Author is found.
     */
    @Override
    public List<String> getAllAuthors() {
        List<String> list = null;
        try {
            list = DAOFactory.getInstance().getBookDAO().getAllAuthors();
        } catch (TransactionException e) {
            list = null;
        }
        TransactionManager.getInstance().close();
        return list;
    }

    /**
     * Searches a list of existing Books at the persistence identified by the
     * Author
     *
     * @param name The Book author
     * @return The <code>{@link IBookBean}</code> list filtered by author;
     * <code>null</code> if no Book is found.
     */
    @Override
    public List<IBookBean> getBookByAuthor(String name) {
        List<IBookBean> list = null;
        try {
            list = DAOFactory.getInstance().getBookDAO().getBookByAuthor(name);
            
        } catch (TransactionException e) {
            list = null;
        }
        TransactionManager.getInstance().close();
        return list;
    }

    /**
     * Searches all the Editorials stored at the persistence
     *
     * @return The <code>String</code> list including all the Editorials;
     * <code>null</code> if no Author is found.
     */
    @Override
    public List<String> getAllEditorials() {
        List<String> list = null;
        try {
            list = DAOFactory.getInstance().getBookDAO().getAllEditorials();
        } catch (TransactionException e) {
            list = null;
        }
        TransactionManager.getInstance().close();
        return list;
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
        List<IBookBean> list = null;
        try {
            list = DAOFactory.getInstance().getBookDAO().getBookByEditorial(editorial);
            
        } catch (TransactionException e) {
            list = null;
        }
        TransactionManager.getInstance().close();
        return list;
    }
}

