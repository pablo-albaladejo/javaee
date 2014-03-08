package ejb.logic.facade;

import ejb.dto.bean.book.IBookBean;
import java.util.List;
import javax.ejb.Remote;

/**
 * This interface provides a unifiqued view of all the model logic to the
 * presentation layer.
 * <p>Pablo Albaladejo Mestre (pablo.albaladejo.mestre@gmail.com)</p>
 */
@Remote
public interface IBusinessFacade {

    /**
     * Adds a new Book to the DDBB
     *
     * @param Book The Book transfer to be added
     * @return  <code>true</code> if the book is propertly added;
     * <code>false</code> otherwise
     */
    boolean NewBook(IBookBean Book);

    /**
     * Removes a Book from the persistence identified by the ISBN
     *
     * @param ISBN The string which defines a unique Book identifier
     * @return  <code>true</code> if the Book is propertly deleted;
     * <code>flase</code> otherwise
     */
    boolean DeleteBook(String ISBN);

    /**
     * Searches all the Books stored at the persistence
     *
     * @return The <code>{@link IBookBean}</code> list including all the Books;
     * <code>null</code> if no Book is found.
     */
    List<IBookBean> getAllBooks();

    /**
     * Searches a Book from the persistence identified by the ISBN
     *
     * @param ISBN The string which defines a unique Book identifier
     * @return The <code>{@link IBookBean}</code> if it is found; <code>null</code>
     * if the Book is not found.
     */
    IBookBean getBookByISBN(String ISBN);

    /**
     * Searches a list of existing Books at the persistence identified by the
     * Title
     *
     * @param title The Book title
     * @return The <code>{@link IBookBean}</code> list filtered by title;
     * <code>null</code> if no Book is found.
     */
    List<IBookBean> getBookByTitle(String title);

    /**
     * Modifies the price of the Book identified by the provded ISBN
     *
     * @param ISBN The string which defines a unique Book identifier
     * @param price The new price to be updated
     * @return <code>true</code> if the books is updated; <code>false</code>
     * otherwise
     */
    boolean ModifyBookPrice(String ISBN, double price);

    //Extra
    /**
     * Modifies the whole data stored into the DDBB
     *
     * @param Book The <code>{@link IBookBean}</code> to including the data to be
     * updated
     * @return <code>true</code> if the books is updated; <code>false</code>
     * otherwise
     */
    boolean ModifyBook(IBookBean Book);

    /**
     * Searches all the Authors stored at the persistence
     *
     * @return The <code>String</code> list including all the Authors;
     * <code>null</code> if no Author is found.
     */
    List<String> getAllAuthors();

    /**
     * Searches a list of existing Books at the persistence identified by the
     * Author
     *
     * @param author The Book author
     * @return The <code>{@link IBookBean}</code> list filtered by author;
     * <code>null</code> if no Book is found.
     */
    List<IBookBean> getBookByAuthor(String author);

    /**
     * Searches all the Editorials stored at the persistence
     *
     * @return The <code>String</code> list including all the Editorials;
     * <code>null</code> if no Author is found.
     */
    List<String> getAllEditorials();
    
    /**
     * Searches a list of existing Books at the persistence identified by the
     * Editorial
     *
     * @param editorial The Book author
     * @return The <code>{@link IBookBean}</code> list filtered by editorial;
     * <code>null</code> if no Book is found.
     */
    List<IBookBean> getBookByEditorial(String editorial);
}
