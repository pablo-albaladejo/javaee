package ejb.integration.book;

import ejb.persistence.database.exception.TransactionException;
import java.util.List;
import ejb.bean.book.IBookBean;

/**
 * This class defines the Interface of the Book integration
 * <p>Pablo Albaladejo Mestre (pablo.albaladejo.mestre@gmail.com)</p>
 */
public interface IBookDAO {

    /**
     * Adds a new Book to the DDBB
     *
     * @param Book The Book transfer to be added
     * @return  <code>true</code> if the book is propertly added;
     * <code>false</code> otherwise
     * @throws TransactionException if a DDBB exception occurred
     */
    boolean NewBook(IBookBean Book) throws TransactionException;

    /**
     * Removes a Book from the DDBB identified by the ISBN
     *
     * @param ISBN The string which defines a unique Book identifier
     * @return  <code>true</code> if the Book is propertly deleted;
     * <code>flase</code> otherwise
     * @throws TransactionException if a DDBB exception occurred
     */
    boolean DeleteBook(String ISBN) throws TransactionException;

    /**
     * Searches all the Books stored at the DDBB
     *
     * @return The <code>{@link IBookBean}</code> list including all the Books;
     * <code>null</code> if no Book is found.
     * @throws TransactionException if a DDBB exception occurred
     */
    List<IBookBean> getAllBooks() throws TransactionException;

    /**
     * Searches a Book from the DDBB identified by the ISBN
     *
     * @param ISBN The string which defines a unique Book identifier
     * @return The <code>{@link IBookBean}</code> if it is found; <code>null</code>
     * if the Book is not found.
     * @throws TransactionException if a DDBB exception occurred
     */
    IBookBean getBookByISBN(String ISBN) throws TransactionException;

    /**
     * Searches a list of existing Books at the DDBB identified by the Title
     *
     * @param title The Book title
     * @return The <code>{@link IBookBean}</code> list filtered by title;
     * <code>null</code> if no Book is found.
     * @throws TransactionException if a DDBB exception occurred
     */
    List<IBookBean> getBookByTitle(String title) throws TransactionException;

    /**
     * Modifies the price of the Book identified by the provded ISBN
     *
     * @param ISBN The string which defines a unique Book identifier
     * @param price The new price to be updated
     * @return <code>true</code> if the books is updated; <code>false</code>
     * otherwise
     * @throws TransactionException if a DDBB exception occurred
     */
    boolean ModifyBookPrice(String ISBN, double price) throws TransactionException;

    /**
     * Modifies the whole data stored into the DDBB
     *
     * @param Book The <code>{@link IBookBean}</code> to including the data to be
     * updated
     * @return <code>true</code> if the books is updated; <code>false</code>
     * otherwise
     * @throws TransactionException if a DDBB exception occurred
     */
    boolean ModifyBook(IBookBean Book) throws TransactionException;

    /**
     * Searches a list of existing Books at the DDBB identified by the AuthorID
     *
     * @param authorID The Author ID
     * @return The <code>{@link IBookBean}</code> list filtered by AuthorID;
     * <code>null</code> if no Book is found.
     * @throws TransactionException if a DDBB exception occurred
     */
    List<IBookBean> getBookByAuthorID(int authorID) throws TransactionException;

    /**
     * Searches a list of existing Books at the DDBB identified by the Author
     *
     * @param author The Book author
     * @return The <code>{@link IBookBean}</code> list filtered by author;
     * <code>null</code> if no Book is found.
     * @throws TransactionException if a DDBB exception occurred
     */
    List<IBookBean> getBookByAuthor(String author) throws TransactionException;

    /**
     * Searches all the Authors stored at the DDBB
     *
     * @return The <code>String</code> list including all the Authors;
     * <code>null</code> if no Authors is found.
     * @throws TransactionException if a DDBB exception occurred
     */
    List<String> getAllAuthors() throws TransactionException;

    /**
     * Searches all the Editorials stored at the DDBB
     *
     * @return The <code>String</code> list including all the Editorials;
     * <code>null</code> if no Editorial is found.
     * @throws TransactionException if a DDBB exception occurred
     */
    List<String> getAllEditorials() throws TransactionException;

    /**
     * Searches a list of existing Books at the DDBB identified by the Editorial
     *
     * @param editorial The Book Editorial
     * @return The <code>{@link IBookBean}</code> list filtered by Editorial;
     * <code>null</code> if no Book is found.
     * @throws TransactionException if a DDBB exception occurred
     */
    List<IBookBean> getBookByEditorial(String editorial) throws TransactionException;
}
