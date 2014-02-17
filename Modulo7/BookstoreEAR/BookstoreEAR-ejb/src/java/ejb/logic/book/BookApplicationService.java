package ejb.logic.book;

import ejb.integration.factory.DAOFactory;
import java.util.List;
import ejb.bean.book.IBookBean;
import ejb.persistence.exception.TransactionException;

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
     * @throws TransactionException if a DDBB exception occurred
     */
    @Override
    public void NewBook(IBookBean Book) throws TransactionException{
        DAOFactory.getInstance().getBookDAO().NewBook(Book);
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
        return DAOFactory.getInstance().getBookDAO().DeleteBook(ISBN);
    }

    /**
     * Searches all the Books stored at the persistence
     *
     * @return The <code>{@link IBookBean}</code> list including all the Books;
     * <code>null</code> if no Book is found.
     */
    @Override
    public List<IBookBean> getAllBooks() {
        return DAOFactory.getInstance().getBookDAO().getAllBooks();
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
        return DAOFactory.getInstance().getBookDAO().getBookByISBN(ISBN);
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
        return DAOFactory.getInstance().getBookDAO().getBookByTitle(title);
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
        return DAOFactory.getInstance().getBookDAO().ModifyBookPrice(ISBN, price);
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
        return DAOFactory.getInstance().getBookDAO().ModifyBook(Book);
    }

    /**
     * Searches all the Authors stored at the persistence
     *
     * @return The <code>String</code> list including all the Authors;
     * <code>null</code> if no Author is found.
     */
    @Override
    public List<String> getAllAuthors() {
        return DAOFactory.getInstance().getBookDAO().getAllAuthors();
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
        return DAOFactory.getInstance().getBookDAO().getBookByAuthor(name);
    }

    /**
     * Searches all the Editorials stored at the persistence
     *
     * @return The <code>String</code> list including all the Editorials;
     * <code>null</code> if no Author is found.
     */
    @Override
    public List<String> getAllEditorials() {
        return DAOFactory.getInstance().getBookDAO().getAllEditorials();
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
      return DAOFactory.getInstance().getBookDAO().getBookByEditorial(editorial);
    }
}
