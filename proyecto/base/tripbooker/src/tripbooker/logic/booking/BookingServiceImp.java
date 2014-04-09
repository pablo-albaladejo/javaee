package tripbooker.logic.booking;

import java.util.ArrayList;
import java.util.List;
import tripbooker.dto.bean.booking.IBookingBean;
import tripbooker.dto.domain.booking.IBookingDO;
import tripbooker.dto.domain.flight.IFlightDO;
import tripbooker.dto.domain.user.IUserDO;
import tripbooker.dto.mapper.DTOMapper;
import tripbooker.integration.factory.DAOFactory;
import tripbooker.persistence.database.exception.TransactionException;
import tripbooker.persistence.database.manager.TransactionManager;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public class BookingServiceImp implements IBookingService{

    @Override
    public List<IBookingBean> getAllBookings() {
        List<IBookingBean> result = new ArrayList<IBookingBean>();
        try {
            List<IBookingDO> list = DAOFactory.getInstance().getBookingDAO().getAllBookings();
            for(IBookingDO bookingDO : list){
                IFlightDO flightDO = DAOFactory.getInstance().getFlightDAO().getFlightByID(bookingDO.getFlightID());
                IUserDO userDO = DAOFactory.getInstance().getUserDAO().getUserByID(bookingDO.getUserID());
                result.add(DTOMapper.getInstance().getBookingBean(bookingDO, flightDO, userDO));
            }
        } catch (TransactionException ex) {
            //TODO
        }
        return result;
    }

    @Override
    public IBookingBean getBookingByCode(String code) {
        IBookingDO bookingDO = null;
        IFlightDO flightDO = null;
        IUserDO userDO = null;
        try {
            bookingDO = DAOFactory.getInstance().getBookingDAO().getBookingByCode(code);
            if(bookingDO != null){
                flightDO = DAOFactory.getInstance().getFlightDAO().getFlightByID(bookingDO.getFlightID());
                userDO = DAOFactory.getInstance().getUserDAO().getUserByID(bookingDO.getUserID());
            }
        } catch (TransactionException ex) {
            //TODO
        }
        return DTOMapper.getInstance().getBookingBean(bookingDO,flightDO,userDO);
    }

    @Override
    public boolean persistBooking(IBookingBean bookingBean) {
        boolean result = false;
        try {
            TransactionManager.getInstance().begin();
            IFlightDO flightDO = DAOFactory.getInstance().getFlightDAO().getFlightByCodeDate(bookingBean.getFlightCode(),bookingBean.getFlightDate());
            IUserDO userDO = DAOFactory.getInstance().getUserDAO().getUserByCode(bookingBean.getUserCode());
            if(flightDO != null && userDO != null){
                IBookingDO bookingDO = DTOMapper.getInstance().getBookingDO(bookingBean,flightDO,userDO);
                if(bookingDO != null){
                    result = DAOFactory.getInstance().getBookingDAO().persistBooking(bookingDO);
                }
            }
            TransactionManager.getInstance().commit();
        } catch (TransactionException ex) {
            try {
                TransactionManager.getInstance().rollback();
            } catch (TransactionException ex1) {
                //TODO - Rollback error
            }
        }finally{
            try {
                TransactionManager.getInstance().close();
            } catch (TransactionException ex) {
                //TODO - Close error
            }
        }
        return result;
    }

    @Override
    public boolean removeBooking(IBookingBean bookingBean) {
        boolean result = false;
        try {
            TransactionManager.getInstance().begin();
            IFlightDO flightDO = DAOFactory.getInstance().getFlightDAO().getFlightByCodeDate(bookingBean.getFlightCode(),bookingBean.getFlightDate());
            IUserDO userDO = DAOFactory.getInstance().getUserDAO().getUserByCode(bookingBean.getUserCode());
            if(flightDO != null && userDO != null){
                IBookingDO bookingDO = DTOMapper.getInstance().getBookingDO(bookingBean,flightDO,userDO);
                if(bookingDO != null){
                    result = DAOFactory.getInstance().getBookingDAO().removeBooking(bookingDO.getBookingID());
                }
            } 
            TransactionManager.getInstance().commit();
        } catch (TransactionException ex) {
            try {
                TransactionManager.getInstance().rollback();
            } catch (TransactionException ex1) {
                //TODO - Rollback error
            }
        }finally{
            try {
                TransactionManager.getInstance().close();
            } catch (TransactionException ex) {
                //TODO - Close error
            }
        }
        return result;
    }

}
