package tripbooker.logic.aircraft;

import java.util.ArrayList;
import java.util.List;
import tripbooker.dto.bean.aircraft.IAircraftBean;
import tripbooker.dto.domain.aircraft.IAircraftDO;
import tripbooker.dto.mapper.DTOMapper;
import tripbooker.integration.factory.DAOFactory;
import tripbooker.persistence.database.exception.TransactionException;
import tripbooker.persistence.database.manager.TransactionManager;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public class AircraftServiceImp implements IAircraftService{

    @Override
    public List<IAircraftBean> getAllAircrafts() {
        List<IAircraftBean> result = new ArrayList<IAircraftBean>();
        try {
            List<IAircraftDO> list = DAOFactory.getInstance().getAircraftDAO().getAllAircrafts();
            for(IAircraftDO aircraftDO :list){
                
                result.add(DTOMapper.getInstance().getAircraftBean(aircraftDO));
            }
        } catch (TransactionException ex) {
            //TODO
        }
        return result;
    }

    @Override
    public boolean persistAircraft(IAircraftBean aircraftBean) {
        boolean result = false;
        IAircraftDO aircraftDO = DTOMapper.getInstance().getAircraftDO(aircraftBean);
        try {
            TransactionManager.getInstance().begin();
            result = DAOFactory.getInstance().getAircraftDAO().persistAircraft(aircraftDO);
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
    public boolean removeAircraft(IAircraftBean aircraftBean) {
        boolean result = false;
        try {
            TransactionManager.getInstance().begin();
            IAircraftDO aircraftDO = DAOFactory.getInstance().getAircraftDAO().getAircraftByModel(aircraftBean.getModel());
            if(aircraftDO != null){
                result = DAOFactory.getInstance().getAircraftDAO().removeAircraft(aircraftDO.getAirfarctID());
                TransactionManager.getInstance().commit();
            }
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
