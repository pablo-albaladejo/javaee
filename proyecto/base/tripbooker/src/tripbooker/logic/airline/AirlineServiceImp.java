package tripbooker.logic.airline;

import java.util.ArrayList;
import java.util.List;
import tripbooker.dto.bean.airline.IAirlineBean;
import tripbooker.dto.domain.airline.IAirlineDO;
import tripbooker.dto.domain.country.ICountryDO;
import tripbooker.dto.mapper.DTOMapper;
import tripbooker.integration.factory.DAOFactory;
import tripbooker.persistence.database.exception.TransactionException;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public class AirlineServiceImp implements IAirlineService{

    @Override
    public List<IAirlineBean> getAllAirlines() {
        List<IAirlineBean> result = new ArrayList<IAirlineBean>();
        try {
            List<IAirlineDO> list = DAOFactory.getInstance().getAirlineDAO().getAllAirlines();
            for(IAirlineDO aircraftDO :list){
                ICountryDO countryDO = DAOFactory.getInstance().getCountryDAO().getCountryByID(aircraftDO.getCountryID()); 
                result.add(DTOMapper.getInstance().getAirlineBean(aircraftDO,countryDO));
            }
        } catch (TransactionException ex) {
            //TODO
        }
        return result;   
    }

    @Override
    public boolean persistAirline(IAirlineBean airlineBean) {
        boolean result = false;
        try {
            ICountryDO countryDO = DAOFactory.getInstance().getCountryDAO().getCountryByCode(airlineBean.getCountryCode());
            IAirlineDO airlineDO = DTOMapper.getInstance().getAirlineDO(airlineBean,countryDO);
            result = DAOFactory.getInstance().getAirlineDAO().persistAirline(airlineDO);
        } catch (TransactionException ex) {
            //TODO
        }
        return result;
    }

    @Override
    public boolean removeAirline(IAirlineBean airlineBean) {
        boolean result = false;
        try {
            IAirlineDO airlineDO = DAOFactory.getInstance().getAirlineDAO().getAirlineByCode(airlineBean.getCode());
            if(airlineDO != null){
                result = DAOFactory.getInstance().getAirlineDAO().removeAirline(airlineDO.getAirlineID());
            }
        } catch (TransactionException ex) {
            //TODO
        }
        return result;
    }

}