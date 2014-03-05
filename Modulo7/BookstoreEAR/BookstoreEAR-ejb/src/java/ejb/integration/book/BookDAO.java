package ejb.integration.book;

import ejb.persistence.database.exception.TransactionException;
import ejb.persistence.database.manager.TransactionManager;
import java.util.List;
import ejb.bean.book.IBookBean;
import java.util.HashMap;
import java.util.Map;

/**
 * Implements the Data Access Object interface defined by {@link IBookDAO}
 *
 * <p>Pablo Albaladejo Mestre (pablo.albaladejo.mestre@gmail.com)</p>
 */
public class BookDAO implements IBookDAO {

    @Override
    public boolean NewBook(IBookBean Book) throws TransactionException {
        TransactionManager.getInstance().persist(Book);
        return true;
    }

    @Override
    public boolean DeleteBook(String ISBN) throws TransactionException {
       Map<String,Object> parameters = new HashMap<String,Object>();
       parameters.put("ISBN", ISBN);
       int rows = TransactionManager.getInstance().ExecuteUpdateNamedQuery("BookBean.deleteByIsbn", parameters);
       if(rows > 0) return true;
       return false;
    }

    @Override
    public List<IBookBean> getAllBooks() throws TransactionException {
       return TransactionManager.getInstance().ExecuteNamedQuery("BookBean.findAll");
    }

    @Override
    public IBookBean getBookByISBN(String ISBN) throws TransactionException {
       Map<String,Object> parameters = new HashMap<String,Object>();
       parameters.put("ISBN", ISBN);
       List<IBookBean> list = TransactionManager.getInstance().ExecuteNamedQuery("BookBean.findByIsbn", parameters);
       if(list == null || list.isEmpty()) return null;
       return list.get(0);
    }

    @Override
    public List<IBookBean> getBookByTitle(String title) throws TransactionException {
        Map<String,Object> parameters = new HashMap<String,Object>();
        parameters.put("title", "%" + title + "%");
        return TransactionManager.getInstance().ExecuteNamedQuery("BookBean.findByTitle", parameters);
    }

    @Override
    public boolean ModifyBookPrice(String ISBN, double price) throws TransactionException {
        Map<String,Object> parameters = new HashMap<String,Object>();
        parameters.put("ISBN", ISBN);
        parameters.put("price", price);
        int rows = TransactionManager.getInstance().ExecuteUpdateNamedQuery("BookBean.modifyPrice", parameters);
        if(rows == 1) return true;
        return false;        
    }

    @Override
    public boolean ModifyBook(IBookBean Book) throws TransactionException {
        Map<String,Object> parameters = new HashMap<String,Object>();
        parameters.put("author", Book.getAuthor());
        parameters.put("description", Book.getDescription());
        parameters.put("editorial", Book.getEditorial());
        parameters.put("publicationYear", Book.getPublicationYear());
        parameters.put("ISBN", Book.getISBN());
        parameters.put("price", Book.getPrice());
        parameters.put("title", Book.getTitle());
        int rows = TransactionManager.getInstance().ExecuteUpdateNamedQuery("BookBean.modifyBook", parameters);
        if(rows == 1) return true;
        return false;
    }

    @Override
    public List<IBookBean> getBookByAuthorID(int authorID) throws TransactionException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<IBookBean> getBookByAuthor(String author) throws TransactionException {
        Map<String,Object> parameters = new HashMap<String,Object>();
        parameters.put("author", "%" + author + "%");
        return TransactionManager.getInstance().ExecuteNamedQuery("BookBean.findByAuthor",parameters);
    }

    @Override
    public List<String> getAllAuthors() throws TransactionException {
        return TransactionManager.getInstance().ExecuteNamedQuery("BookBean.findAllAuthors");
    }

    @Override
    public List<String> getAllEditorials() throws TransactionException {
        return TransactionManager.getInstance().ExecuteNamedQuery("BookBean.findAllEditorials");
    }

    @Override
    public List<IBookBean> getBookByEditorial(String editorial) throws TransactionException {
        Map<String,Object> parameters = new HashMap<String,Object>();
        parameters.put("editorial", "%" + editorial + "%");
        return TransactionManager.getInstance().ExecuteNamedQuery("BookBean.findByEditorial",parameters);
    }
}
