package tripbooker.logic.airport;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
