package tripbooker.integration.airport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tripbooker.dto.domain.airport.IAirportDO;
import tripbooker.dto.factory.DTOFactory;
import tripbooker.integration.factory.DAO;
import tripbooker.persistence.database.exception.TransactionException;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public class AirportDAOImp extends DAO implements IAirportDAO{

    private void copyResultAirportData(ResultSet result, IAirportDO airport) throws SQLException {
        airport.setAirportID(result.getInt(1));
        airport.setCode(result.getString(2));
        airport.setName(result.getString(3));
        airport.setCityID(result.getInt(4));
    }
    
    @Override
    public List<IAirportDO> getAllAirports() throws TransactionException {
        List<IAirportDO> list = new ArrayList<IAirportDO>();
        String query = "SELECT * FROM airport";
        try {
            this.resultSet = this.statement.executeQuery(query);
            while (this.resultSet.next()) {
                IAirportDO airport = DTOFactory.getInstance().getAirportDO();
                copyResultAirportData(resultSet, airport);
                list.add(airport);
            }
        } catch (SQLException e) {
                throw new TransactionException(e);
        }
        return list;
    }

    @Override
    public IAirportDO getAirportByID(int id) throws TransactionException {
         IAirportDO airport = null;

        String query = "SELECT * FROM airport"
                + " WHERE airportID = '" + id + "'";
        try {
            this.resultSet = this.statement.executeQuery(query);
            if (resultSet.next()) {
                airport = DTOFactory.getInstance().getAirportDO();
                copyResultAirportData(resultSet, airport);
            } else {
                airport = null;
            }
        } catch (SQLException e) {
            throw new TransactionException(e);
        }
        return airport;
    }

     @Override
    public IAirportDO getAirportByCode(String code) throws TransactionException {
         IAirportDO airport = null;

        String query = "SELECT * FROM airport"
                + " WHERE code = '" + code + "'";
        try {
            this.resultSet = this.statement.executeQuery(query);
            if (resultSet.next()) {
                airport = DTOFactory.getInstance().getAirportDO();
                copyResultAirportData(resultSet, airport);
            } else {
                airport = null;
            }
        } catch (SQLException e) {
            throw new TransactionException(e);
        }
        return airport;
    }
    
    @Override
    public boolean removeAirport(int id) throws TransactionException {
        boolean deleteActionResult = false;
        String query = "DELETE FROM  airport"
                + " WHERE airportID = '" + id + "'";
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
    public boolean persistAirport(IAirportDO airport) throws TransactionException {
        boolean InsertActionResult = false;
        String query = "";
        
        if(this.getAirportByID(airport.getAirportID()) != null){
            query = "UPDATE airport SET " 
                + "code = '" + airport.getCode()+"', "
                + "name = '" + airport.getName()+"', "
                + "CityID = '" + airport.getCityID()+"' "
                + "WHERE airportID = '" + airport.getAirportID()+ "'";
        }else{
            query = "INSERT INTO airport"
                    + " (`code`, `name`,`cityID`) VALUES ("
                    + "'" + airport.getCode()+ "', "
                    + "'" + airport.getName()+ "', "
                    + "'" + airport.getCityID()+ "' "
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
