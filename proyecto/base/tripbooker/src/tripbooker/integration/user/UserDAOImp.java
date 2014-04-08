package tripbooker.integration.user;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tripbooker.dto.domain.factory.DOFactory;
import tripbooker.dto.domain.user.IUserDO;
import tripbooker.integration.factory.DAO;
import tripbooker.persistence.database.exception.TransactionException;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public class UserDAOImp extends DAO implements IUserDAO{

    private void copyResultUserData(ResultSet result, IUserDO userDO) throws SQLException {
        userDO.setUserID(result.getInt(1));
        userDO.setCode(result.getString(2));
    }
    
    @Override
    public List<IUserDO> getAllUsers() throws TransactionException{
        List<IUserDO> list = new ArrayList<IUserDO>();
        String query = "SELECT * FROM user";
        try {
            this.resultSet = this.statement.executeQuery(query);
            while (this.resultSet.next()) {
                IUserDO userDO = DOFactory.getInstance().getUserDO();
                copyResultUserData(resultSet, userDO);
                list.add(userDO);
            }
        } catch (SQLException e) {
                throw new TransactionException(e);
        }
        return list;
    }

    @Override
    public IUserDO getUserByID(int userID) throws TransactionException{
                IUserDO userDO = null;
        String query = "SELECT * FROM user"
                + " WHERE userID = '" + userID + "'";
        try {
            this.resultSet = this.statement.executeQuery(query);
            if (resultSet.next()) {
                userDO = DOFactory.getInstance().getUserDO();
                copyResultUserData(resultSet, userDO);
            } else {
                userDO = null;
            }
        } catch (SQLException e) {
            throw new TransactionException(e);
        }
        return userDO;
    }

    @Override
    public IUserDO getUserByCode(String code) throws TransactionException{
        IUserDO userDO = null;
        String query = "SELECT * FROM user"
                + " WHERE code = '" + code + "'";
        try {
            this.resultSet = this.statement.executeQuery(query);
            if (resultSet.next()) {
                userDO = DOFactory.getInstance().getUserDO();
                copyResultUserData(resultSet, userDO);
            } else {
                userDO = null;
            }
        } catch (SQLException e) {
            throw new TransactionException(e);
        }
        return userDO;
    }

    @Override
    public boolean removeUser(int userID) throws TransactionException{
        boolean deleteActionResult = false;
        String query = "DELETE FROM  user"
                + " WHERE userID = '" + userID + "'";
        try {
            int numRows = this.statement.executeUpdate(query);
            if (numRows > 0) {
                deleteActionResult = true;
            }
        } catch (SQLException ex) {
            throw new TransactionException(ex);
        }
        return deleteActionResult;
    }

    @Override
    public boolean persistUser(IUserDO userDO) throws TransactionException{
        boolean InsertActionResult = false;
        String query = "";
        IUserDO userTemp = this.getUserByID(userDO.getUserID());
        if(userTemp != null){
            query = "UPDATE user SET " 
                + "code = '" + userDO.getCode()+"' "
                + "WHERE userID = '" + userTemp.getUserID()+ "'";
        }else{
            query = "INSERT INTO user"
                    + " (`code`) VALUES ("
                    + "'" + userDO.getCode() + "'"
                    + ")";
        }
        try {
            int numRows = this.statement.executeUpdate(query);
            if (numRows > 0) {
                InsertActionResult = true;
            }
        } catch (SQLException ex) {
            throw new TransactionException(ex);
        }
        return InsertActionResult;
    }
}
