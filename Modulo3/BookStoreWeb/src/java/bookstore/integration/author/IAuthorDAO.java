package bookstore.integration.author;

import bookstore.integration.ddbb.exception.TransactionException;
import bookstore.logic.transfer.author.ITAuthor;
import java.util.List;

/**
 *
 * @author <p>Pablo Albaladejo Mestre (pablo.albaladejo.mestre@gmail.com)</p>
 */
public interface IAuthorDAO {
    /**
     * Searches all the Authors stored at the persistence
     * @return  The <code>{@link ITAuthor}</code> list including all the Authors;
     *          <code>null</code> if no Author is found.     
     */
    List<ITAuthor> getAllAuthors() throws TransactionException;
    
    /**
     * Searches all the Authors stored filtered by Name
     * @return  The <code>{@link ITAuthor}</code> list
     *          <code>null</code> if no Author is found.     
     */
    List<ITAuthor> getAuthorByName(String name) throws TransactionException;
}
