package tripbooker.integration.ticket;

import java.util.List;
import tripbooker.dto.domain.ticket.ITicketDO;
import tripbooker.persistence.database.exception.TransactionException;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public interface ITicketDAO {
    List<ITicketDO> getAllTickets() throws TransactionException;
    List<ITicketDO> getAllTicketsByFlight(int flightID) throws TransactionException;
    int countTicketsByFlight(int flightID) throws TransactionException;
    ITicketDO getTicketByID(int ticketID) throws TransactionException; 
    ITicketDO getTicketByCode(String code) throws TransactionException;
    boolean persistTicket(ITicketDO ticketDO) throws TransactionException;
    boolean removeTicket(int ticketID) throws TransactionException;
}
