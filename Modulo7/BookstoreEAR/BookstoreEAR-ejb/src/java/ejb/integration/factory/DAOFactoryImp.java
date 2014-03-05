package ejb.integration.factory;

import ejb.integration.book.BookDAO;
import ejb.integration.book.IBookDAO;
import ejb.persistence.database.exception.TransactionException;

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
}
