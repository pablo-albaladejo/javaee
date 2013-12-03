package bookstore.integration.book;

import bookstore.integration.ddbb.exception.TransactionException;
import java.util.List;
import bookstore.logic.transfer.book.ITBook;

/**
 * This class defines the Interface of the Book integration
 * <p>Pablo Albaladejo Mestre (pablo.albaladejo.mestre@gmail.com)</p>
 */
public interface IBookDAO {
    /**
     *  Adds a new Book to the DDBB
     *
     * @param   Book The Book transfer to be added
     * @return  <code>true</code> if the book is propertly added;
     *          <code>false</code> otherwise
     * @throws  TransactionException if a DDBB exception occurred
     */
    boolean NewBook(ITBook Book) throws TransactionException;
    /**
     *  Removes a Book from the DDBB identified by the ISBN
     * 
     * @param   ISBN The string which defines a unique Book identifier
     * @return  <code>true</code> if the Book is propertly deleted;
     *          <code>flase</code> otherwise
     * @throws  TransactionException if a DDBB exception occurred
     */
    boolean DeleteBook(String ISBN) throws TransactionException;
    /**
     *  Searches all the Books stored at the DDBB
     * @return  The <code>{@link ITBook}</code> list including all the Books;
     *          <code>null</code> if no Book is found.     
     * @throws  TransactionException if a DDBB exception occurred
     */
    List<ITBook> getAllBooks() throws TransactionException;
    /**
     *  Searches a Book from the DDBB identified by the ISBN
     * @param   ISBN The string which defines a unique Book identifier
     * @return  The <code>{@link ITBook}</code> if it is found;
     *          <code>null</code> if the Book is not found.
     * @throws  TransactionException if a DDBB exception occurred
     */
    ITBook getBookByISBN(String ISBN) throws TransactionException;
    /**
     * Searches a list of existing Books at the DDBB identified by the Title
     * @param   title The Book title
     * @return  The <code>{@link ITBook}</code> list filtered by title;
     *          <code>null</code> if no Book is found.
     * @throws  TransactionException if a DDBB exception occurred
     */
    List<ITBook> getBookByTitle(String title) throws TransactionException;
    /**
     * Modifies the price of the Book identified by the provded ISBN
     * @param ISBN The string which defines a unique Book identifier
     * @param price The new price to be updated
     * @return <code>true</code> if the books is updated;
     *         <code>false</code> otherwise
     * @throws TransactionException if a DDBB exception occurred
     */
    boolean ModifyBookPrice(String ISBN, double price) throws TransactionException;
    /**
     * Modifies the whole data stored into the DDBB
     * @param Book The <code>{@link ITBook}</code> to including the data to be updated
     * @return <code>true</code> if the books is updated;
     *         <code>false</code> otherwise 
     * @throws TransactionException if a DDBB exception occurred
     */
    boolean ModifyBook(ITBook Book) throws TransactionException;
    
    /**
     * Searches a list of existing Books at the DDBB identified by the AuthorID
     * @param   authorID The Author ID
     * @return  The <code>{@link ITBook}</code> list filtered by AuthorID;
     *          <code>null</code> if no Book is found.
     * @throws  TransactionException if a DDBB exception occurred
     */
    List<ITBook> getBookByAuthorID(int authorID) throws TransactionException;
}
