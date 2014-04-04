package tripbooker.integration.factory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
    
    public java.util.Date toJavaDate(java.sql.Date sqlDate, java.sql.Time sqlTime){
        Calendar calendar = new GregorianCalendar();
        
        calendar.set(Calendar.YEAR, sqlDate.getYear() + 1900);
        calendar.set(Calendar.MONTH, sqlDate.getMonth());
        calendar.set(Calendar.DAY_OF_MONTH, sqlDate.getDate());
        calendar.set(Calendar.HOUR_OF_DAY, sqlTime.getHours());
        calendar.set(Calendar.MINUTE, sqlTime.getMinutes());
        calendar.set(Calendar.SECOND, sqlTime.getSeconds());
               
        return calendar.getTime();        
    }

    public String toSqlDate(java.util.Date javaDate){
            String sqlDate = (javaDate.getYear()+1900)+"-"+javaDate.getMonth()+"-"+javaDate.getDate()+" "
                         +javaDate.getHours()+":"+javaDate.getMinutes()+":"+javaDate.getSeconds();
        return sqlDate;        
    }
}
