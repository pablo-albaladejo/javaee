package tripbooker.logic.aircraft;

import java.util.ArrayList;
import java.util.List;
import tripbooker.dto.bean.aircraft.IAircraftBean;
import tripbooker.dto.domain.aircraft.IAircraftDO;
import tripbooker.dto.mapper.DTOMapper;
import tripbooker.integration.factory.DAOFactory;
import tripbooker.persistence.database.exception.TransactionException;

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
            result = DAOFactory.getInstance().getAircraftDAO().persistAircraft(aircraftDO);
        } catch (TransactionException ex) {
            //TODO
        }
        return result;
    }

    @Override
    public boolean removeAircraft(IAircraftBean aircraftBean) {
        boolean result = false;
        try {
            IAircraftDO aircraftDO = DAOFactory.getInstance().getAircraftDAO().getAircraftByModel(aircraftBean.getModel());
            if(aircraftDO != null){
                result = DAOFactory.getInstance().getAircraftDAO().removeAircraft(aircraftDO.getAirfarctID());
            }
        } catch (TransactionException ex) {
            //TODO
        }
        return result;        
    }
}
