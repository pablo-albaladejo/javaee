package tripbooker.integration.ticket;

import java.util.List;
import tripbooker.dto.domain.ticket.ITicketDO;
import tripbooker.integration.factory.DAO;
import tripbooker.persistence.database.exception.TransactionException;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public class TicketDAOImp extends DAO implements ITicketDAO{

    @Override
    public List<ITicketDO> getAllTickets() throws TransactionException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ITicketDO getTicketByCode(String code) throws TransactionException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean persistTicket(ITicketDO ticketDO) throws TransactionException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeTicket(int ticketID) throws TransactionException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
