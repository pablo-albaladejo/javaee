package tripbooker.persistence.database.transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import tripbooker.persistence.database.exception.TransactionException;
import tripbooker.persistence.database.manager.TransactionManager;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public class Transaction implements ITransaction{
 private Connection connection;
    
    /**
     *
     * @throws TransactionException
     */
    public Transaction() throws TransactionException{
        try {
            String url = "jdbc:mysql://"+TransactionManager.DDBB_SERVER+"/"+TransactionManager.DDBB_NAME;
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection(url, TransactionManager.DDBB_USER, TransactionManager.DDBB_PASS);
        }catch (SQLException | ClassNotFoundException sqle){ 
            throw new TransactionException(sqle);
        }
    }
    
   
    /**
     *
     * @throws TransactionException
     */
    @Override
    public void commit() throws TransactionException {
        try {
            this.connection.commit();//UNLOCK TABLES
            this.connection.close();
        }catch (SQLException sqle){ 
            throw new TransactionException(sqle);
        }
    }

    /**
     *
     * @throws TransactionException
     */
    @Override
    public void rollback() throws TransactionException {
        try {
            this.connection.rollback();//UNLOCK TABLES
            this.connection.close();
        }catch (SQLException sqle){
            throw new TransactionException(sqle); 
        }
    }

    /**
     *
     * @throws TransactionException
     */
    @Override
    public void begin() throws TransactionException {
        try {
            this.connection.createStatement().executeUpdate("START TRANSACTION");
            this.connection. setAutoCommit(false);
            this.connection.createStatement().executeUpdate("SET AUTOCOMMIT = 0");
        }catch (SQLException sqle){ 
            throw new TransactionException(sqle);
        }
    }

    /**
     *
     * @throws TransactionException
     */
    @Override
    public void close() throws TransactionException {
        try {
            this.connection.close();
        } catch (SQLException sqle){
            throw new TransactionException(sqle); 
        }
    }

    /**
     *
     * @return Object
     */
    @Override
    public Object getConexion() {
        return this.connection;
    }
}
