package tripbooker.dto.domain.ticket;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public class TicketDOImp implements ITicketDO{
    private int ticketID;
    private String code;
    private int userID;
    private int flightID;

    @Override
    public int getTicketID() {
        return ticketID;
    }

    @Override
    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
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
    public String toString() {
        return "TicketDOImp{" + "ticketID=" + ticketID + ", code=" + code + ", userID=" + userID + ", flightID=" + flightID + '}';
    }
}
