package bookstore.integration.book;

import bookstore.integration.ddbb.exception.TransactionException;
import java.util.List;
import bookstore.logic.transfer.book.ITBook;

/**
 *
 * Pablo Albaladejo Mestre(pablo.albaladejo.mestre@gmail.com)
 */
public interface IBookDAO {
    /**
     *
     * @param Book
     * @return
     * @throws TransactionException
     */
    boolean NewBook(ITBook Book) throws TransactionException;
    /**
     *
     * @param ISBN
     * @return
     * @throws TransactionException
     */
    boolean DeleteBook(String ISBN) throws TransactionException;
    /**
     *
     * @return
     * @throws TransactionException
     */
    List<ITBook> getAllBooks() throws TransactionException;
    /**
     *
     * @param ISBN
     * @return
     * @throws TransactionException
     */
    ITBook getBookByISBN(String ISBN) throws TransactionException;
    /**
     *
     * @param title
     * @return
     * @throws TransactionException
     */
    List<ITBook> getBookByTitle(String title) throws TransactionException;
    /**
     *
     * @param ISBN
     * @param price
     * @return
     * @throws TransactionException
     */
    boolean ModifyBookPrice(String ISBN, double price) throws TransactionException;
    /**
     *
     * @param Book
     * @return
     * @throws TransactionException
     */
    boolean ModifyBook(ITBook Book) throws TransactionException;
}
