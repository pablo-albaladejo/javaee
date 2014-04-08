package tripbooker.integration.booking;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tripbooker.dto.domain.booking.IBookingDO;
import tripbooker.dto.domain.factory.DOFactory;
import tripbooker.integration.factory.DAO;
import tripbooker.persistence.database.exception.TransactionException;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public class BookingDAOImp extends DAO implements IBookingDAO{
    
    private void copyResultAirportData(ResultSet result, IBookingDO booking) throws SQLException {
        booking.setBookingID(result.getInt(1));
        booking.setCode(result.getString(2));
        booking.setUserID(result.getInt(3));
        booking.setFlightID(result.getInt(4));
        booking.setBusiness(result.getBoolean(5));
    }
    
    @Override
    public List<IBookingDO> getAllBookings() throws TransactionException {
        List<IBookingDO> list = new ArrayList<IBookingDO>();
        String query = "SELECT * FROM booking";
        try {
            this.resultSet = this.statement.executeQuery(query);
            while (this.resultSet.next()) {
                IBookingDO booking = DOFactory.getInstance().getBookingDO();
                copyResultAirportData(resultSet, booking);
                list.add(booking);
            }
        } catch (SQLException e) {
                throw new TransactionException(e);
        }
        return list;
    }

    @Override
    public IBookingDO getBookingByCode(String code) throws TransactionException {
        IBookingDO booking = null;
        String query = "SELECT * FROM booking"
                + " WHERE code = '" + code + "'";
        try {
            this.resultSet = this.statement.executeQuery(query);
            if (resultSet.next()) {
                booking = DOFactory.getInstance().getBookingDO();
                copyResultAirportData(resultSet, booking);
            } else {
                booking = null;
            }
        } catch (SQLException e) {
            throw new TransactionException(e);
        }
        return booking;
    }
    
    @Override
    public IBookingDO getBookingByID(int id) throws TransactionException {
        IBookingDO booking = null;
        String query = "SELECT * FROM booking"
                + " WHERE bookingID = '" + id + "'";
        try {
            this.resultSet = this.statement.executeQuery(query);
            if (resultSet.next()) {
                booking = DOFactory.getInstance().getBookingDO();
                copyResultAirportData(resultSet, booking);
            } else {
                booking = null;
            }
        } catch (SQLException e) {
            throw new TransactionException(e);
        }
        return booking;
    }
    

    @Override
    public boolean removeBooking(int bookingID) throws TransactionException {
        boolean deleteActionResult = false;
        String query = "DELETE FROM booking"
                + " WHERE bookingID = '" + bookingID + "'";
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
    public boolean persistBooking(IBookingDO bookingDO) throws TransactionException {
        boolean InsertActionResult = false;
        String query = "";
        
        if(this.getBookingByID(bookingDO.getBookingID()) != null){
            query = "UPDATE booking SET " 
                + "code = '" + bookingDO.getCode()+"', "
                + "userID = '" + bookingDO.getUserID()+"', "
                + "flightID = '" + bookingDO.getFlightID()+"', "
                + "business = " + bookingDO.isBusiness()+" "
                + "WHERE bookingID = '" + bookingDO.getBookingID()+ "'";
        }else{
            query = "INSERT INTO booking"
                    + " (`code`, `userID`,`flightID`,`business`) VALUES ("
                    + "'" + bookingDO.getCode()+ "', "
                    + "'" + bookingDO.getUserID()+ "', "
                    + "'" + bookingDO.getFlightID()+ "', "
                    + "" + bookingDO.isBusiness()+ ""
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
