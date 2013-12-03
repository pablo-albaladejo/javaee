package bookstore.logic.author;

import bookstore.logic.transfer.author.ITAuthor;
import bookstore.logic.transfer.book.ITBook;
import java.util.List;

/**
 *
 * @author <p>Pablo Albaladejo Mestre (pablo.albaladejo.mestre@gmail.com)</p>
 */
public interface IAuthorApplicationService {
    /**
     * Searches all the Authors stored at the persistence
     * @return  The <code>{@link ITAuthor}</code> list including all the Authors;
     *          <code>null</code> if no Author is found.     
     */
    List<ITAuthor> getAllAuthors();
    
    /**
     * Searches all the Books written by an Author
     * @return  The <code>{@link ITBook}</code> list including all the books;
     *          <code>null</code> if no books is found.     
     */
    List<ITBook> getBookByAuthor(String name);
}
