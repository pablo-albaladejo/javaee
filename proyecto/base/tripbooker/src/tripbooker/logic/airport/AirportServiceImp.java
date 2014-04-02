package tripbooker.logic.airport;

import java.util.ArrayList;
import java.util.List;
import tripbooker.dto.bean.airport.IAirportBean;
import tripbooker.dto.domain.airport.IAirportDO;
import tripbooker.dto.domain.city.ICityDO;
import tripbooker.dto.mapper.DTOMapper;
import tripbooker.integration.factory.DAOFactory;
import tripbooker.persistence.database.exception.TransactionException;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public class AirportServiceImp implements IAirportService{

    @Override
    public List<IAirportBean> getAllAirports() {
        List<IAirportBean> result = new ArrayList<IAirportBean>();
        try {
             List<IAirportDO> list = DAOFactory.getInstance().getAirportDAO().getAllAirports();
             for(IAirportDO airportDO : list){
                ICityDO cityDO = DAOFactory.getInstance().getCityDAO().getCityByID(airportDO.getCityID());
                result.add(DTOMapper.getInstance().getAirportBean(airportDO, cityDO));    
             }
        } catch (TransactionException ex) {
            //TODO
        }
        return result;
    }

    @Override
    public List<IAirportBean> getAirportsByCity(String code) {
        ArrayList<IAirportBean> result = new ArrayList<IAirportBean>();
        try {
            ICityDO cityDO = DAOFactory.getInstance().getCityDAO().getCityByCode(code);
            if(cityDO != null){
                List<IAirportDO> list = DAOFactory.getInstance().getAirportDAO().getAirportsByCity(cityDO.getCityID());
                for(IAirportDO airportDO : list){
                    result.add(DTOMapper.getInstance().getAirportBean(airportDO,cityDO));
                }
            }
        } catch (TransactionException ex) {
            //TODO
        }
        return result;        
    }
    
    @Override
    public boolean persistAirport(IAirportBean airportBean) {
        boolean result = false;
        try {
            //Get the City Code
            ICityDO cityDO = DAOFactory.getInstance().getCityDAO().getCityByCode(airportBean.getCityCode());
            
            //Map from Bean to DO object
            IAirportDO airportDO = DTOMapper.getInstance().getAirportDO(airportBean,cityDO);
            
            //Presist invoke
            result = DAOFactory.getInstance().getAirportDAO().persistAirport(airportDO);
        } catch (TransactionException ex) {
            //TODO
        }
        return result;
    }

    @Override
    public boolean removeAirport(IAirportBean airportBean) {
        boolean result = false;
        try {
            IAirportDO airportDO = DAOFactory.getInstance().getAirportDAO().getAirportByCode(airportBean.getCode());
            if(airportDO != null){
                result = DAOFactory.getInstance().getAirportDAO().removeAirport(airportDO.getAirportID());
            }
        } catch (TransactionException ex) {
            //TODO
        }
        return result;
    }
}
