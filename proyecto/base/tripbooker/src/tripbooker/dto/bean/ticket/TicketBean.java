package tripbooker.dto.bean.ticket;

import java.util.Date;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public class TicketBean implements ITicketBean{
    private String code;
    private String flightCode;
    private Date flightDate;
    private String userCode;

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public void setCode(String code) {
        this.code = code;
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
    public Date getFlightDate() {
        return flightDate;
    }

    @Override
    public void setFlightDate(Date flightDate) {
        this.flightDate = flightDate;
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
    public String toString() {
        return "TicketBean{" + "code=" + code + ", flightCode=" + flightCode + ", flightDate=" + flightDate + ", userCode=" + userCode + '}';
    }
}
