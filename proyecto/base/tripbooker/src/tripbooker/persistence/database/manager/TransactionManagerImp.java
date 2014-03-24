package tripbooker.persistence.database.manager;

import java.util.HashMap;
import tripbooker.persistence.database.exception.TransactionException;
import tripbooker.persistence.database.factory.TransactionFactory;
import tripbooker.persistence.database.transaction.ITransaction;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public class TransactionManagerImp extends TransactionManager{
private HashMap<Long,ITransaction> connectionPool = new HashMap<Long,ITransaction>();
   
    private ITransaction getTransaction() throws TransactionException {
        if (connectionPool.containsKey(Thread.currentThread().getId())) {
                return connectionPool.get(Thread.currentThread().getId());
        } else {
                ITransaction transaction = TransactionFactory.getInstance().getTransaction();
                connectionPool.put(Thread.currentThread().getId(), transaction);
                return transaction;
        }
    }
    
    /**
     *
     * @throws TransactionException
     */
    @Override
    public void commit() throws TransactionException{
        this.getTransaction().commit();
        this.connectionPool.remove(Thread.currentThread().getId());
    }

    /**
     *
     * @throws TransactionException
     */
    @Override
    public void rollback() throws TransactionException{
        this.getTransaction().rollback();
        this.connectionPool.remove(Thread.currentThread().getId());
    }

    /**
     *
     * @throws TransactionException
     */
    @Override
    public void begin() throws TransactionException{
        this.getTransaction().begin();
    }

    /**
     *
     * @throws TransactionException
     */
    @Override
    public void close() throws TransactionException{
        this.getTransaction().close();
        this.connectionPool.remove(Thread.currentThread().getId());
    }

    /**
     *
     * @return
     * @throws TransactionException
     */
    @Override
    public Object getConexion() throws TransactionException{
        return this.getTransaction().getConexion();
    }
}
