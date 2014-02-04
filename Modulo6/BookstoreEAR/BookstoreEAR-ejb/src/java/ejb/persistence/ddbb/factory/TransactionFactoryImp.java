package ejb.persistence.ddbb.factory;

import ejb.persistence.ddbb.exception.TransactionException;
import ejb.persistence.ddbb.transaction.ITransaction;
import ejb.persistence.ddbb.transaction.Transaction;

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
