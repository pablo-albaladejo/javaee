package tripbooker.integration.aircraft;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tripbooker.dto.domain.aircraft.IAircraftDO;
import tripbooker.dto.factory.DTOFactory;
import tripbooker.integration.factory.DAO;
import tripbooker.persistence.database.exception.TransactionException;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public class AircraftDAOImp extends DAO implements IAircraftDAO{
    
    private void copyResultAircraftData(ResultSet result, IAircraftDO aircfart) throws SQLException {
        aircfart.setAirfarctID(result.getInt(1));
        aircfart.setManufacter(result.getString(2));
        aircfart.setModel(result.getString(3));
        aircfart.setDate(toJavaDate(result.getDate(4), result.getTime(4)));
        aircfart.setSeats(result.getInt(5));
    }

    @Override
    public List<IAircraftDO> getAllAircrafts() throws TransactionException {
        List<IAircraftDO> list = new ArrayList<IAircraftDO>();
        String query = "SELECT * FROM aircraft";
        try {
            this.resultSet = this.statement.executeQuery(query);
            while (this.resultSet.next()) {
                IAircraftDO aircraft = DTOFactory.getInstance().getAircraftDO();
                copyResultAircraftData(resultSet, aircraft);
                list.add(aircraft);
            }
        } catch (SQLException e) {
                throw new TransactionException(e);
        }
        return list;
    }

    @Override
    public IAircraftDO getAircraftByID(int id) throws TransactionException {
        IAircraftDO aircraft = null;

        String query = "SELECT * FROM aircraft"
                + " WHERE aircraftID = '" + id + "'";
        try {
            this.resultSet = this.statement.executeQuery(query);
            if (resultSet.next()) {
                aircraft = DTOFactory.getInstance().getAircraftDO();
                copyResultAircraftData(resultSet, aircraft);
            } else {
                aircraft = null;
            }
        } catch (SQLException e) {
            throw new TransactionException(e);
        }
        return aircraft;
    }
    
    @Override
    public IAircraftDO getAircraftByModel(String model) throws TransactionException {
        IAircraftDO aircraft = null;

        String query = "SELECT * FROM aircraft"
                + " WHERE model = '" + model + "'";
        try {
            this.resultSet = this.statement.executeQuery(query);
            if (resultSet.next()) {
                aircraft = DTOFactory.getInstance().getAircraftDO();
                copyResultAircraftData(resultSet, aircraft);
            } else {
                aircraft = null;
            }
        } catch (SQLException e) {
            throw new TransactionException(e);
        }
        return aircraft;
    }

    @Override
    public boolean removeAircraft(int id) throws TransactionException {
        boolean deleteActionResult = false;
        String query = "DELETE FROM  aircraft"
                + " WHERE aircraftID = '" + id + "'";
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
    public boolean persistAircraft(IAircraftDO aircraft) throws TransactionException {
        boolean InsertActionResult = false;
        String query = "";
        
        if(this.getAircraftByModel(aircraft.getModel()) != null){
            query = "UPDATE aircraft SET " 
                + "manufacter = '" + aircraft.getManufacter() +"', "
                + "model = '" + aircraft.getModel()+"', "
                + "date = '" + toSqlDate(aircraft.getDate())+"', "
                + "seats = '" + aircraft.getSeats()+"' "
                + "WHERE aircraftID = '" + aircraft.getAirfarctID()+ "'";
        }else{
            query = "INSERT INTO aircraft"
                    + " (`manufacter`, `model`,`date` ,`seats`) VALUES ("
                    + "'" + aircraft.getManufacter()+ "', "
                    + "'" + aircraft.getModel() + "', "
                    + "'" + toSqlDate(aircraft.getDate()) + "', "
                    + "'" + aircraft.getSeats() + "'"
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
