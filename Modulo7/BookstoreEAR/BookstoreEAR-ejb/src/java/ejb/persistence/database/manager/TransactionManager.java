package ejb.persistence.database.manager;

import ejb.persistence.database.exception.TransactionException;
import java.util.List;
import java.util.Map;

/**
 *
 * <p>Pablo Albaladejo Mestre (pablo.albaladejo.mestre@gmail.com)</p>
 */
public abstract class TransactionManager {
    
    static final String PersistenceUnit = "BookstorePU";
    
    private static TransactionManager instance;
    
    public static synchronized TransactionManager getInstance(){
        if(instance == null) instance = new TransactionManagerImp();
        return instance;        
    }
    
    /**
     *
     * @throws TransactionException
     */
    public abstract void commit() throws TransactionException;
    /**
     *
     * @throws TransactionException
     */
    public abstract void rollback() throws TransactionException;
    /**
     *
     * @throws TransactionException
     */
    public abstract void begin() throws TransactionException;
    /**
     *
     * 
     */
    public abstract void close();
    
    public abstract void persist(Object o);
    public abstract void remove(Object o);
    
    public abstract List ExecuteNamedQuery(String NamedQuery, Map<String, Object> parameters);
    public abstract List ExecuteNamedQuery(String NamedQuery);
    public abstract int ExecuteUpdateNamedQuery(String NamedQuery, Map<String, Object> parameters);
}