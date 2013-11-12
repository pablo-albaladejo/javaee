package bookstore.integration.ddbb.factory;

import bookstore.integration.ddbb.exception.TransactionException;
import bookstore.integration.ddbb.transaction.ITransaction;

/**
 *
 * Pablo Albaladejo Mestre(pablo.albaladejo.mestre@gmail.com)
 */
public abstract class TransactionFactory {
    static private TransactionFactory instance;
    
    /**
     *
     * @return
     */
    static public TransactionFactory getInstance(){
        if(instance == null) instance = new TransactionFactoryImp();
        return instance;
    }
    
    /**
     *
     * @return
     * @throws TransactionException
     */
    public abstract ITransaction getTransaction() throws TransactionException;
    public abstract ITransaction getTransaction(boolean transactionalDDBB) throws TransactionException;
}
