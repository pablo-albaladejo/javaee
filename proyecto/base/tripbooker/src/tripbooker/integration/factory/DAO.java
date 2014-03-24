package tripbooker.integration.factory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import tripbooker.persistence.database.exception.TransactionException;
import tripbooker.persistence.database.manager.TransactionManager;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public class DAO {

    public ResultSet resultSet;
    public Connection connection;
    public Statement statement;

    public DAO() {
        try {
            this.connection = (Connection) TransactionManager.getInstance().getConexion();
            this.statement = connection.createStatement();
        } catch (SQLException | TransactionException ex) {
            
        }
    }
}
