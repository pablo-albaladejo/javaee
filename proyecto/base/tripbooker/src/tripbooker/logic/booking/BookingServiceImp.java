package tripbooker.logic.booking;

import java.util.ArrayList;
import java.util.List;
import tripbooker.dto.bean.booking.IBookingBean;
import tripbooker.dto.bean.factory.BeanFactory;
import tripbooker.dto.domain.booking.IBookingDO;
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
                result.add(DTOMapper.getInstance().getBookingBean(bookingDO));
            }
        } catch (TransactionException ex) {
            //TODO
        }
        return result;
    }

    @Override
    public IBookingBean getBookingByCode(String code) {
        IBookingBean bookingBean = BeanFactory.getInstance().getBookingBean();
        try {
            IBookingDO bookingDO = DAOFactory.getInstance().getBookingDAO().getBookingByCode(code);
            if(bookingDO != null){
                bookingBean = DTOMapper.getInstance().getBookingBean(bookingDO);
            }
        } catch (TransactionException ex) {
            //TODO
        }
        return bookingBean;
    }

    @Override
    public boolean persistBooking(IBookingBean bookingBean) {
        boolean result = false;
        try {
            TransactionManager.getInstance().begin();
            IBookingDO bookingDO = DTOMapper.getInstance().getBookingDO(bookingBean);
            if(bookingDO != null){
                result = DAOFactory.getInstance().getBookingDAO().persistBooking(bookingDO);
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
            IBookingDO bookingDO = DTOMapper.getInstance().getBookingDO(bookingBean);
            if(bookingDO != null){
                result = DAOFactory.getInstance().getBookingDAO().removeBooking(bookingDO);
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
