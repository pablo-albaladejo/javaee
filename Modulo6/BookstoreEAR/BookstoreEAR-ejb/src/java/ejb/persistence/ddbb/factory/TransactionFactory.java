package ejb.persistence.ddbb.factory;

import ejb.persistence.ddbb.exception.TransactionException;
import ejb.persistence.ddbb.transaction.ITransaction;

/**
 *
 * <p>Pablo Albaladejo Mestre (pablo.albaladejo.mestre@gmail.com)</p>
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
