package tripbooker.integration.booking;

import java.util.List;
import tripbooker.dto.domain.booking.IBookingDO;
import tripbooker.persistence.database.exception.TransactionException;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public interface IBookingDAO {
    List<IBookingDO> getAllBookings() throws TransactionException;
    IBookingDO getBookingByID(int id) throws TransactionException;
    IBookingDO getBookingByCode(String code) throws TransactionException;
    boolean persistBooking(IBookingDO bookingDO) throws TransactionException;
    boolean removeBooking(int bookingID) throws TransactionException;
}
