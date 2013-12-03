package bookstore.integration.factory;

import bookstore.integration.author.AuthorDAO;
import bookstore.integration.author.IAuthorDAO;
import bookstore.integration.book.BookDAO;
import bookstore.integration.book.IBookDAO;
import bookstore.integration.ddbb.exception.TransactionException;

/**
 * This class implements the Data Access Object Factory. 
 * It is used as Facade for all the DAO objects at the Persistencce Layer
 * <p>Pablo Albaladejo Mestre (pablo.albaladejo.mestre@gmail.com)</p>
 */
public class DAOFactoryImp extends DAOFactory{

    /**
     * Provides a DAO from the Book Entity 
     * @return A {@link IBookDAO} object
     * @throws TransactionException if a DDBB exception occurred
     */
    @Override
    public IBookDAO getBookDAO() throws TransactionException{
        return new BookDAO();
    }
    
    /**
     * Provides a DAO from the Author Entity 
     * @return A {@link IAuthorDAO} object
     * @throws TransactionException if a DDBB exception occurred
     */
    @Override
    public IAuthorDAO getAuthorDAO() throws TransactionException{
        return new AuthorDAO();
    }
    
}
