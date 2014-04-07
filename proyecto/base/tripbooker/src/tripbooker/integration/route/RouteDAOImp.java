package tripbooker.integration.route;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tripbooker.dto.domain.route.IRouteDO;
import tripbooker.dto.domain.factory.DOFactory;
import tripbooker.integration.factory.DAO;
import tripbooker.persistence.database.exception.TransactionException;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public class RouteDAOImp extends DAO implements IRouteDAO {

    private void copyResultRouteData(ResultSet result, IRouteDO route) throws SQLException {
        route.setRouteID(result.getInt(1));
        route.setDepartureID(result.getInt(2));
        route.setDestinationID(result.getInt(3));
        route.setDuration(result.getInt(4));
    }
    
    @Override
    public List<IRouteDO> getAllRoutes() throws TransactionException {
        List<IRouteDO> list = new ArrayList<IRouteDO>();
        String query = "SELECT * FROM route";
        try {
            this.resultSet = this.statement.executeQuery(query);
            while (this.resultSet.next()) {
                IRouteDO route = DOFactory.getInstance().getRouteDO();
                copyResultRouteData(resultSet, route);
                list.add(route);
            }
        } catch (SQLException e) {
                throw new TransactionException(e);
        }
        return list;
    }

    @Override
    public IRouteDO getRouteByID(int id) throws TransactionException {
        IRouteDO route = null;
        String query = "SELECT * FROM route"
                + " WHERE routeID = '" + id + "'";
        try {
            this.resultSet = this.statement.executeQuery(query);
            if (resultSet.next()) {
                route = DOFactory.getInstance().getRouteDO();
                copyResultRouteData(resultSet, route);
            } else {
                route = null;
            }
        } catch (SQLException e) {
            throw new TransactionException(e);
        }
        return route;
    }
    
    @Override
    public List<IRouteDO> getAllRoutesByDeparture(int airportID) throws TransactionException {
        List<IRouteDO> list = new ArrayList<IRouteDO>();
        String query = "SELECT * FROM route"
                 + " WHERE departureID = '" + airportID + "'";
        try {
            this.resultSet = this.statement.executeQuery(query);
            while (this.resultSet.next()) {
                IRouteDO route = DOFactory.getInstance().getRouteDO();
                copyResultRouteData(resultSet, route);
                list.add(route);
            }
        } catch (SQLException e) {
                throw new TransactionException(e);
        }
        return list;
    }
    
    @Override
    public List<IRouteDO> getAllRoutesByDestination(int airportID) throws TransactionException {
        List<IRouteDO> list = new ArrayList<IRouteDO>();
        String query = "SELECT * FROM route"
                 + " WHERE destinationID = '" + airportID + "'";
        try {
            this.resultSet = this.statement.executeQuery(query);
            while (this.resultSet.next()) {
                IRouteDO route = DOFactory.getInstance().getRouteDO();
                copyResultRouteData(resultSet, route);
                list.add(route);
            }
        } catch (SQLException e) {
                throw new TransactionException(e);
        }
        return list;
    }
    
    @Override
    public boolean removeRoute(int id) throws TransactionException {
        boolean deleteActionResult = false;
        String query = "DELETE FROM  route"
                + " WHERE routeID = '" + id + "'";
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
    public boolean persistRoute(IRouteDO route) throws TransactionException {
        boolean InsertActionResult = false;
        String query = "";
        IRouteDO routeTemp = this.getRoute(route.getDepartureID(),route.getDestinationID());
        if(routeTemp != null){
            query = "UPDATE route SET " 
                + "departureID = '" + route.getDepartureID() +"', "
                + "destinationID = '" + route.getDestinationID()+"', "
                + "duration = '" + route.getDuration()+"' "
                + "WHERE routeID = '" + routeTemp.getRouteID()+ "'";
        }else{
            query = "INSERT INTO route"
                    + " (`departureID`, `destinationID`,`duration`) VALUES ("
                    + "'" + route.getDepartureID()+ "', "
                    + "'" + route.getDestinationID() + "', "
                    + "'" + route.getDuration() + "'"
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

    @Override
    public IRouteDO getRoute(int departureID, int destinationID) throws TransactionException {
        IRouteDO route = null;
        String query = "SELECT * FROM route"
                 + " WHERE departureID = '"+departureID+"' AND destinationID = '" + destinationID + "'";
        try {
            this.resultSet = this.statement.executeQuery(query);
            if (resultSet.next()) {
                route = DOFactory.getInstance().getRouteDO();
                copyResultRouteData(resultSet, route);
            } else {
                route = null;
            }
        } catch (SQLException e) {
            throw new TransactionException(e);
        }
        return route;
    }

}
