package tripbooker.logic.ticket;

import java.util.List;
import tripbooker.dto.bean.ticket.ITicketBean;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public interface ITicketService {
    List<ITicketBean> getAllTickets();
    ITicketBean getTicketByCode(String code);
    boolean persistTicket(ITicketBean ticketBean);
    boolean removeTicket(ITicketBean ticketBean);
}
