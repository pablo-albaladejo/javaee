package ejb.persistence.ddbb.manager;

import ejb.persistence.ddbb.exception.TransactionException;

/**
 *
 * <p>Pablo Albaladejo Mestre (pablo.albaladejo.mestre@gmail.com)</p>
 */
public abstract class TransactionManager {
    
    //DDBB SERVER
    /**
     *
     */
    public static final String DDBB_SERVER = "localhost";
    /**
     *
     */
    public static final String DDBB_PORT = "3306";
    
    public static final boolean transactionalDDBB  = false; 
    
    //DDBB USER
    /**
     *
     */
    public static final String DDBB_NAME = "libreria";
    /**
     *
     */
    public static final String DDBB_USER = "curso";
    /**
     *
     */
    public static final String DDBB_PASS = "curso";
    
    //ENTITIES
    /**
     *
     */
    public static final String BOOK_ENTITY = "libros";
    public static final String AUTHOR_ENTITY = "autores";
    
    static private TransactionManager instance;
    
    /**
     *
     * @return
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
