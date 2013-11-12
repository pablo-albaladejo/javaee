package bookstore.logic.facade;

import java.util.List;
import bookstore.logic.transfer.book.ITBook;

/**
 *
 * Pablo Albaladejo Mestre(pablo.albaladejo.mestre@gmail.com)
 */
public interface IBusinessFacade {
    
    //Book
    /**
     *
     * @param Book
     * @return
     */
    boolean NewBook(ITBook Book);
    /**
     *
     * @param ISBN
     * @return
     */
    boolean DeleteBook(String ISBN);
    /**
     *
     * @return
     */
    List<ITBook> getAllBooks();
    /**
     *
     * @param ISBN
     * @return
     */
    ITBook getBookByISBN(String ISBN);
    /**
     *
     * @param title
     * @return
     */
    List<ITBook> getBookByTitle(String title);
    /**
     *
     * @param ISBN
     * @param price
     * @return
     */
    boolean ModifyBookPrice(String ISBN, double price);
    
    //Extra
    /**
     *
     * @param Book
     * @return
     */
    boolean ModifyBook(ITBook Book);
}
