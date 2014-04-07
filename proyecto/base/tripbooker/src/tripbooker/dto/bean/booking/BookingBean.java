package tripbooker.dto.bean.booking;

import java.util.Date;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public class BookingBean implements IBookingBean{
    private String bookingCode;
    private String userCode;
    private String flightCode;
    private Date flightDate;
    private boolean business;

    @Override
    public String getBookingCode() {
        return bookingCode;
    }

    @Override
    public void setBookingCode(String bookingCode) {
        this.bookingCode = bookingCode;
    }

    @Override
    public String getUserCode() {
        return userCode;
    }

    @Override
    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    @Override
    public String getFlightCode() {
        return flightCode;
    }

    @Override
    public void setFlightCode(String flightCode) {
        this.flightCode = flightCode;
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
    public Date getFlightDate() {
        return flightDate;
    }

    @Override
    public void setFlightDate(Date flightDate) {
        this.flightDate = flightDate;
    }
       
    @Override
    public String toString() {
        return "BookingBean{" + "bookingCode=" + bookingCode + ", userCode=" + userCode + ", flightCode=" + flightCode + ", business=" + business + '}';
    }
}
