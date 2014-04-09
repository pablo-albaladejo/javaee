package tripbooker.dto.domain.ticket;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public interface ITicketDO {
    int getTicketID();
    void setTicketID(int ticketID);

    String getCode();
    void setCode(String code);

    int getUserID();
    void setUserID(int userID);
}
