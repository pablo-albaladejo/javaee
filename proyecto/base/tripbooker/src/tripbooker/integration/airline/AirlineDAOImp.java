package tripbooker.integration.airline;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tripbooker.dto.domain.airline.IAirlineDO;
import tripbooker.dto.factory.DTOFactory;
import tripbooker.integration.factory.DAO;
import tripbooker.persistence.database.exception.TransactionException;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public class AirlineDAOImp extends DAO implements IAirlineDAO {

    private void copyResultAirlineData(ResultSet result, IAirlineDO airline) throws SQLException {
        airline.setAirlineID(result.getInt(1));
        airline.setCode(result.getString(2));
        airline.setName(result.getString(3));
        airline.setCountryID(result.getInt(4));
    }
    
    
    @Override
    public List<IAirlineDO> getAllAirlines() throws TransactionException{
        
        List<IAirlineDO> list = new ArrayList<IAirlineDO>();
        String query = "SELECT * FROM airline";
        try {
            this.resultSet = this.statement.executeQuery(query);
            while (this.resultSet.next()) {
                IAirlineDO airline = DTOFactory.getInstance().getAirlineDO();
                copyResultAirlineData(resultSet, airline);
                list.add(airline);
            }
        } catch (SQLException e) {
                throw new TransactionException(e);
        }
        return list;
    }
    
    @Override
    public IAirlineDO getAirlineByID(int id) throws TransactionException {
        IAirlineDO airline = null;

        String query = "SELECT * FROM airline"
                + " WHERE airlineID = '" + id + "'";
        try {
            this.resultSet = this.statement.executeQuery(query);
            if (resultSet.next()) {
                airline = DTOFactory.getInstance().getAirlineDO();
                copyResultAirlineData(resultSet, airline);
            } else {
                airline = null;
            }
        } catch (SQLException e) {
            throw new TransactionException(e);
        }
        return airline;
    }
    
    @Override
    public IAirlineDO getAirlineByCode(String code) throws TransactionException {
        IAirlineDO airline = null;
        String query = "SELECT * FROM airline"
                + " WHERE code = '" + code + "'";
        try {
            this.resultSet = this.statement.executeQuery(query);
            if (resultSet.next()) {
                airline = DTOFactory.getInstance().getAirlineDO();
                copyResultAirlineData(resultSet, airline);
            } else {
                airline = null;
            }
        } catch (SQLException e) {
            throw new TransactionException(e);
        }
        return airline;
    }
    
    @Override
    public boolean removeAirline(int id) throws TransactionException {
        boolean deleteActionResult = false;
        String query = "DELETE FROM  airline"
                + " WHERE airlineID = '" + id + "'";
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
    public boolean insertAirline(IAirlineDO airline) throws TransactionException {
        boolean InsertActionResult = false;
        String query = "";
        
        if(this.getAirlineByID(airline.getAirlineID()) != null){
            query = "UPDATE airline SET " 
                + "code = '" + airline.getCode() +"', "
                + "name = '" + airline.getName()+"', "
                + "countryID = '" + airline.getCountryID()+"' "
                + "WHERE airlineID = '" + airline.getAirlineID() + "'";
        }else{
            query = "INSERT INTO airline"
                    + " (`code`, `name`, `countryID`) VALUES ("
                    + "'" + airline.getCode()+ "', "
                    + "'" + airline.getName() + "', "
                    + "'" + airline.getCountryID() + "'"
                    + ")";
        }
        try {
            int numRows = this.statement.executeUpdate(query);
            if (numRows > 0) {
                InsertActionResult = true;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
            throw new TransactionException(ex);
        }
        return InsertActionResult;
    }
}
