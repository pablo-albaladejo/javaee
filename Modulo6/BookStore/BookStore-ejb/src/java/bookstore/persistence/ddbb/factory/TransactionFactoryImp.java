package bookstore.persistence.ddbb.factory;

import bookstore.persistence.ddbb.exception.TransactionException;
import bookstore.persistence.ddbb.transaction.ITransaction;
import bookstore.persistence.ddbb.transaction.Transaction;

/**
 *
 * <p>Pablo Albaladejo Mestre (pablo.albaladejo.mestre@gmail.com)</p>
 */
public class TransactionFactoryImp extends TransactionFactory{

    /**
     *
     * @return
     * @throws TransactionException
     */
    @Override
    public ITransaction getTransaction() throws TransactionException{
        return new Transaction();
    }
    
     /**
     *
     * @return
     * @throws TransactionException
     */
    @Override
    public ITransaction getTransaction(boolean transactionalDDBB) throws TransactionException{
        return new Transaction(transactionalDDBB);
    }
    
}
