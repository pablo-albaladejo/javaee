package bookstore.integration.factory;

import bookstore.integration.book.IBookDAO;
import bookstore.integration.ddbb.exception.TransactionException;

/**
 *
 * Pablo Albaladejo Mestre(pablo.albaladejo.mestre@gmail.com)
 */
public abstract class DAOFactory {
    static private DAOFactory instance;
    
    /**
     *
     * @return
     */
    static public DAOFactory getInstance(){
        if(instance == null) instance = new DAOFactoryImp();
        return instance;
    }
    
    /**
     *
     * @return
     * @throws TransactionException
     */
    public abstract IBookDAO getBookDAO() throws TransactionException;
}
