package tripbooker.dto.domain.booking;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public class BookingDOImp implements IBookingDO{
    private int bookingID;
    private String code;
    private int userID;
    private int flightID;
    private boolean business;

    @Override
    public int getBookingID() {
        return bookingID;
    }

    @Override
    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public void setCode(String code) {
        this.code = code;
    }
    
    @Override
    public int getUserID() {
        return userID;
    }

    @Override
    public void setUserID(int userID) {
        this.userID = userID;
    }

    @Override
    public int getFlightID() {
        return flightID;
    }

    @Override
    public void setFlightID(int flightID) {
        this.flightID = flightID;
    }

    @Override
    public boolean isBusiness() {
        return business;
    }

    @Override
    public void setBusiness(boolean business) {
        this.business = business;
    }

    @Override
    public String toString() {
        return "BookingDOImp{" + "bookingID=" + bookingID + ", code=" + code + ", userID=" + userID + ", flightID=" + flightID + ", business=" + business + '}';
    }
}
