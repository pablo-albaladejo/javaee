package ws.integration.factory;

import ws.integration.book.BookDAO;
import ws.integration.book.IBookDAO;
import ws.persistence.database.exception.TransactionException;

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
