package ejb.integration.book;

import ejb.dto.domain.book.IBookDO;
import ejb.persistence.database.exception.TransactionException;
import ejb.persistence.database.manager.TransactionManager;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

/**
 * Implements the Data Access Object interface defined by {@link IBookDAO}
 *
 * <p>Pablo Albaladejo Mestre (pablo.albaladejo.mestre@gmail.com)</p>
 */
public class BookDAO implements IBookDAO {

    @Override
    public boolean NewBook(IBookDO Book) throws TransactionException {
        TransactionManager.getInstance().persist(Book);
        return true;
    }

    @Override
    public boolean DeleteBook(String ISBN) throws TransactionException {
       Map<String,Object> parameters = new HashMap<String,Object>();
       parameters.put("ISBN", ISBN);
       int rows = TransactionManager.getInstance().ExecuteUpdateNamedQuery("BookDO.deleteByIsbn", parameters);
       if(rows > 0) return true;
       return false;
    }

    @Override
    public List<IBookDO> getAllBooks() throws TransactionException {
       return TransactionManager.getInstance().ExecuteNamedQuery("BookDO.findAll");
    }

    @Override
    public IBookDO getBookByISBN(String ISBN) throws TransactionException {
       Map<String,Object> parameters = new HashMap<String,Object>();
       parameters.put("ISBN", ISBN);
       List<IBookDO> list = TransactionManager.getInstance().ExecuteNamedQuery("BookDO.findByIsbn", parameters);
       if(list == null || list.isEmpty()) return null;
       return list.get(0);
    }

    @Override
    public List<IBookDO> getBookByTitle(String title) throws TransactionException {
        Map<String,Object> parameters = new HashMap<String,Object>();
        parameters.put("title", "%" + title + "%");
        return TransactionManager.getInstance().ExecuteNamedQuery("BookDO.findByTitle", parameters);
    }

    @Override
    public boolean ModifyBookPrice(String ISBN, double price) throws TransactionException {
        Map<String,Object> parameters = new HashMap<String,Object>();
        parameters.put("ISBN", ISBN);
        parameters.put("price", price);
        int rows = TransactionManager.getInstance().ExecuteUpdateNamedQuery("BookDO.modifyPrice", parameters);
        if(rows == 1) return true;
        return false;        
    }

    @Override
    public boolean ModifyBook(IBookDO Book) throws TransactionException {
        Map<String,Object> parameters = new HashMap<String,Object>();
        parameters.put("author", Book.getAuthor());
        parameters.put("description", Book.getDescription());
        parameters.put("editorial", Book.getEditorial());
        parameters.put("publicationYear", Book.getPublicationYear());
        parameters.put("ISBN", Book.getISBN());
        parameters.put("price", Book.getPrice());
        parameters.put("title", Book.getTitle());
        int rows = TransactionManager.getInstance().ExecuteUpdateNamedQuery("BookDO.modifyBook", parameters);
        if(rows == 1) return true;
        return false;
    }

    @Override
    public List<IBookDO> getBookByAuthor(String author) throws TransactionException {
        Map<String,Object> parameters = new HashMap<String,Object>();
        parameters.put("author", "%" + author + "%");
        return TransactionManager.getInstance().ExecuteNamedQuery("BookDO.findByAuthor",parameters);
    }

    @Override
    public List<String> getAllAuthors() throws TransactionException {
        return TransactionManager.getInstance().ExecuteNamedQuery("BookDO.findAllAuthors");
    }

    @Override
    public List<String> getAllEditorials() throws TransactionException {
        return TransactionManager.getInstance().ExecuteNamedQuery("BookDO.findAllEditorials");
    }

    @Override
    public List<IBookDO> getBookByEditorial(String editorial) throws TransactionException {
        Map<String,Object> parameters = new HashMap<String,Object>();
        parameters.put("editorial", "%" + editorial + "%");
        return TransactionManager.getInstance().ExecuteNamedQuery("BookDO.findByEditorial",parameters);
    }
}
