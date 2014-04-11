package tripbooker.logic.ticket;

import java.util.List;
import tripbooker.dto.bean.ticket.ITicketBean;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public interface ITicketService {
    List<ITicketBean> getAllTickets();
    List<ITicketBean> getAllTicketsByAirline(String airlineCode);
    ITicketBean getTicketByCode(String code);
    boolean persistTicket(ITicketBean ticketBean);
    boolean removeTicket(ITicketBean ticketBean);
}
