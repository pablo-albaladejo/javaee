package tripbooker.integration.flight;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tripbooker.dto.domain.flight.IFlightDO;
import tripbooker.dto.factory.DTOFactory;
import tripbooker.integration.factory.DAO;
import tripbooker.persistence.database.exception.TransactionException;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public class FlightDAOImp extends DAO implements IFlightDAO{

    private void copyResultFlightData(ResultSet result, IFlightDO flight) throws SQLException {
        flight.setFlightID(result.getInt(1));
        flight.setCode(result.getString(2));
        flight.setAirlineID(result.getInt(3));
        flight.setAircraftID(result.getInt(4));
        flight.setRouteID(result.getInt(5));
        flight.setDate(result.getDate(6));
        flight.setEconomyFare(result.getFloat(7));
        flight.setBusinessFare(result.getFloat(8));
        flight.setOfferFare(result.getFloat(9));
        flight.setBusinessSeats(result.getInt(10));
    }
    
    @Override
    public List<IFlightDO> getAllFlights() throws TransactionException {
        List<IFlightDO> list = new ArrayList<IFlightDO>();
        String query = "SELECT * FROM flight";
        try {
            this.resultSet = this.statement.executeQuery(query);
            while (this.resultSet.next()) {
                IFlightDO flight = DTOFactory.getInstance().getFlightDO();
                copyResultFlightData(resultSet, flight);
                list.add(flight);
            }
        } catch (SQLException e) {
                throw new TransactionException(e);
        }
        return list;
    }

    @Override
    public IFlightDO getFlightByID(int id) throws TransactionException {
        IFlightDO flight = null;
        String query = "SELECT * FROM flight"
                + " WHERE flightID = '" + id + "'";
        try {
            this.resultSet = this.statement.executeQuery(query);
            if (resultSet.next()) {
                flight = DTOFactory.getInstance().getFlightDO();
                copyResultFlightData(resultSet, flight);
            } else {
                flight = null;
            }
        } catch (SQLException e) {
            throw new TransactionException(e);
        }
        return flight;
    }

    @Override
    public List<IFlightDO> getFlightsByAirline(int airlineID) throws TransactionException {
        List<IFlightDO> list = new ArrayList<IFlightDO>();
        String query = "SELECT * FROM flight WHERE airlineID ='"+airlineID+"'";
        try {
            this.resultSet = this.statement.executeQuery(query);
            while (this.resultSet.next()) {
                IFlightDO flight = DTOFactory.getInstance().getFlightDO();
                copyResultFlightData(resultSet, flight);
                list.add(flight);
            }
        } catch (SQLException e) {
                throw new TransactionException(e);
        }
        return list;
    }
    
    @Override
    public boolean removeFlight(int id) throws TransactionException {
        boolean deleteActionResult = false;
        String query = "DELETE FROM flight"
                + " WHERE flightID = '" + id + "'";
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
    public boolean insertFlight(IFlightDO flight) throws TransactionException {
        boolean InsertActionResult = false;
        String query = "";
        
        if(this.getFlightByID(flight.getRouteID()) != null){
            query = "UPDATE flight SET " 
                + "code = '" + flight.getCode() +"', "
                + "airlineID = '" + flight.getAirlineID()+"', "
                + "aircraftID = '" + flight.getAircraftID()+"', "
                + "routeID = '" + flight.getRouteID()+"', "
                + "date = '" + flight.getDate()+"', "
                + "economyFare = '" + flight.getEconomyFare()+"', "
                + "businessFare = '" + flight.getBusinessFare()+"', "
                + "offerFare = '" + flight.getOfferFare()+"', "
                + "businessSeats = '" + flight.getBusinessSeats()+"' "
                + "WHERE flightID = '" + flight.getFlightID()+ "'";
        }else{
            query = "INSERT INTO flight"
                    + " (`code`, `airlineID`,`aircraftID`,`routeID`,"
                    + "`date`,`economyFare`,`businessFare`,`offerFare`,"
                    + "`businessSeats`"
                    + ") VALUES ("
                    + "'" + flight.getCode()+ "', "
                    + "'" + flight.getAirlineID() + "', "
                    + "'" + flight.getAircraftID() + "', "
                    + "'" + flight.getRouteID() + "', "
                    + "'" + flight.getDate() + "', "
                    + "'" + flight.getEconomyFare() + "', "
                    + "'" + flight.getBusinessFare() + "', "
                    + "'" + flight.getOfferFare() + "', "
                    + "'" + flight.getBusinessSeats() + "'"
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
