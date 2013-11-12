package bookstore.integration.factory;

import bookstore.integration.book.BookDAO;
import bookstore.integration.book.IBookDAO;
import bookstore.integration.ddbb.exception.TransactionException;

/**
 *
 * Pablo Albaladejo Mestre(pablo.albaladejo.mestre@gmail.com)
 */
public class DAOFactoryImp extends DAOFactory{

    /**
     *
     * @return
     * @throws TransactionException
     */
    @Override
    public IBookDAO getBookDAO() throws TransactionException{
        return new BookDAO();
    }
    
}
