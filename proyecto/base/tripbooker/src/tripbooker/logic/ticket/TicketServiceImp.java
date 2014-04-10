package tripbooker.logic.ticket;

import java.util.ArrayList;
import java.util.List;
import tripbooker.dto.bean.ticket.ITicketBean;
import tripbooker.dto.domain.ticket.ITicketDO;
import tripbooker.dto.domain.user.IUserDO;
import tripbooker.dto.mapper.DTOMapper;
import tripbooker.integration.factory.DAOFactory;
import tripbooker.persistence.database.exception.TransactionException;
import tripbooker.persistence.database.manager.TransactionManager;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public class TicketServiceImp implements ITicketService{

    @Override
    public List<ITicketBean> getAllTickets() {
        List<ITicketBean> result = new ArrayList<ITicketBean>();
        try{
            List<ITicketDO> list = DAOFactory.getInstance().getTicketDAO().getAllTickets();
            for(ITicketDO ticketDO : list){
                IUserDO userDO = DAOFactory.getInstance().getUserDAO().getUserByID(ticketDO.getUserID());
                result.add(DTOMapper.getInstance().getTicketBean(ticketDO,userDO));
            }
        } catch(TransactionException ex){
            //TODO
        }
        return result;
    }

    @Override
    public ITicketBean getTicketByCode(String code) {
        ITicketDO ticketDO = null;
        IUserDO userDO = null;
        try{
            ticketDO = DAOFactory.getInstance().getTicketDAO().getTicketByCode(code);
            if(ticketDO != null){
                userDO = DAOFactory.getInstance().getUserDAO().getUserByID(ticketDO.getUserID());
            }
        }catch (TransactionException ex){
            //TODO
        }
        return DTOMapper.getInstance().getTicketBean(ticketDO,userDO);
    }

    @Override
    public boolean persistTicket(ITicketBean ticketBean) {
        boolean result = false;        
        try{
            TransactionManager.getInstance().begin();
            IUserDO userDO = DAOFactory.getInstance().getUserDAO().getUserByCode(ticketBean.getUserCode());
            ITicketDO ticketDO = DTOMapper.getInstance().getTicketDO(ticketBean,userDO);
            result = DAOFactory.getInstance().getTicketDAO().persistTicket(ticketDO);
            TransactionManager.getInstance().commit();
        }catch(TransactionException ex){
            try{
                TransactionManager.getInstance().rollback();
            }catch (TransactionException ex1){
                //TODO - Rollback error
            }
        }finally{
            try{
                TransactionManager.getInstance().close();
            }catch (TransactionException ex){
                //TODO - Close error
            }
        }     
        return result;
    }

    @Override
    public boolean removeTicket(ITicketBean ticketBean) {
        boolean result = false;
        try{
            TransactionManager.getInstance().begin();
            ITicketDO ticketDO = DAOFactory.getInstance().getTicketDAO().getTicketByCode(ticketBean.getCode());
            if(ticketDO != null){
                result = DAOFactory.getInstance().getTicketDAO().removeTicket(ticketDO.getTicketID());
            }
            TransactionManager.getInstance().commit();
        }catch(TransactionException ex){
            try{
                TransactionManager.getInstance().rollback();
            }catch (TransactionException ex1){
                //TODO - Rollback error
            }
        }finally{
            try{
                TransactionManager.getInstance().close();
            }catch (TransactionException ex){
                //TODO - Close error
            }
        }     
        return result;
    }

}
