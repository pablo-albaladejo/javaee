package bookstore.logic.book;

import java.util.List;
import bookstore.logic.transfer.book.ITBook;

/**
 * This interface provides the available Book methods
 * <p>Pablo Albaladejo Mestre (pablo.albaladejo.mestre@gmail.com)</p>
 */
public interface IBookApplicationService {
    /**
     *  Adds a new Book to the DDBB
     *
     * @param   Book The Book transfer to be added
     * @return  <code>true</code> if the book is propertly added;
     *          <code>false</code> otherwise
     */
    boolean NewBook(ITBook Book);
    /**
     *  Removes a Book from the persistence identified by the ISBN
     * 
     * @param   ISBN The string which defines a unique Book identifier
     * @return  <code>true</code> if the Book is propertly deleted;
     *          <code>flase</code> otherwise
     */
    boolean DeleteBook(String ISBN);
    /**
     * Searches all the Books stored at the persistence
     * @return  The <code>{@link ITBook}</code> list including all the Books;
     *          <code>null</code> if no Book is found.     
     */
    List<ITBook> getAllBooks();
    /**
     * Searches a list of existing Books at the persistence identified by the ISBN
     * @param   ISBN The Book title
     * @return  The <code>{@link ITBook}</code> list filtered by ISBN;
     *          <code>null</code> if no Book is found.
     */
    ITBook getBookByISBN(String ISBN);
    /**
     * Searches a list of existing Books at the persistence identified by the Title
     * @param   title title The Book title
     * @return  The <code>{@link ITBook}</code> list filtered by title;
     *          <code>null</code> if no Book is found.
     */
    List<ITBook> getBookByTitle(String title);
    /**
     * Modifies the price of the Book identified by the provded ISBN
     * @param ISBN The string which defines a unique Book identifier
     * @param price The new price to be updated
     * @return <code>true</code> if the books is updated;
     *         <code>false</code> otherwise
     */
    boolean ModifyBookPrice(String ISBN, double price);
    /**
     * Modifies the whole data stored into the DDBB
     * @param Book The <code>{@link ITBook}</code> to including the data to be updated
     * @return <code>true</code> if the books is updated;
     *         <code>false</code> otherwise 
     */
    boolean ModifyBook(ITBook Book);
}
