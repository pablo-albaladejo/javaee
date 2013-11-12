package bookstore.integration.ddbb.transaction;

import bookstore.integration.ddbb.exception.TransactionException;
import bookstore.integration.ddbb.manager.TransactionManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * Pablo Albaladejo Mestre(pablo.albaladejo.mestre@gmail.com)
 */
public class Transaction implements ITransaction{
    private Connection connection;
    private boolean transactionalDDBB  = false;
    
    /**
     *
     * @throws TransactionException
     */
    public Transaction() throws TransactionException{
        try {
            String url = "jdbc:mysql://"+TransactionManager.DDBB_SERVER+"/"+TransactionManager.DDBB_NAME;
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection(url, TransactionManager.DDBB_USER, TransactionManager.DDBB_PASS);
        }catch (SQLException sqle){ 
            throw new TransactionException(sqle);
        } catch (ClassNotFoundException cnfe) {
            throw new TransactionException(cnfe);
        }
    }
    
        /**
     *
     * @throws TransactionException
     */
    public Transaction(boolean transactionalDDBB) throws TransactionException{
        this();
        this.transactionalDDBB = transactionalDDBB;
    }
    
    /**
     *
     * @throws TransactionException
     */
    @Override
    public void commit() throws TransactionException {
        if(transactionalDDBB){
            try {
                this.connection.commit();//UNLOCK TABLES
                this.connection.close();
            }catch (SQLException sqle){ 
                throw new TransactionException(sqle);
            }
        }
    }

    /**
     *
     * @throws TransactionException
     */
    @Override
    public void rollback() throws TransactionException {
        if(transactionalDDBB){
            try {
                this.connection.rollback();//UNLOCK TABLES
                this.connection.close();
            }catch (SQLException sqle){
                throw new TransactionException(sqle); 
            }
        }
    }

    /**
     *
     * @throws TransactionException
     */
    @Override
    public void begin() throws TransactionException {
        if(transactionalDDBB){
            try {
                this.connection.createStatement().executeUpdate("START TRANSACTION");//LOCK TABLE
                this.connection. setAutoCommit(false);
                this.connection.createStatement().executeUpdate("SET AUTOCOMMIT = 0");
            }catch (SQLException sqle){ 
                throw new TransactionException(sqle);
            }
        }
    }

    /**
     *
     * @throws TransactionException
     */
    @Override
    public void close() throws TransactionException {
        if(transactionalDDBB){
            try {
                this.connection.close();
            } catch (SQLException sqle){
                throw new TransactionException(sqle); 
            }
        }
    }

    /**
     *
     * @return
     */
    @Override
    public Object getConexion() {
        return this.connection;
    }
    
}
