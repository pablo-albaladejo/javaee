package tripbooker.persistence.database.manager;

import tripbooker.persistence.database.exception.TransactionException;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public abstract class TransactionManager {

    //Database
    public static final String DDBB_SERVER = "localhost";
    public static final String DDBB_PORT = "3306";
    public static final String DDBB_NAME = "tripbooker";
    
    //User
    public static final String DDBB_USER = "curso";
    public static final String DDBB_PASS = "curso";
       
    static private TransactionManager instance;
    
    /**
     *
     * @return TransactionManager
     */
    static public TransactionManager getInstance(){
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
     * @throws TransactionException
     */
    public abstract void close() throws TransactionException;
	/**
     *
     * @return
     * @throws TransactionException
     */
    public abstract Object getConexion() throws TransactionException;
}
