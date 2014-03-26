package tripbooker.logic.airport;

import java.util.logging.Level;
import java.util.logging.Logger;
import tripbooker.dto.bean.airport.IAirportBean;
import tripbooker.dto.domain.airport.IAirportDO;
import tripbooker.integration.factory.DAOFactory;
import tripbooker.persistence.database.exception.TransactionException;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public class AirportServiceImp implements IAirportService{

    @Override
    public boolean persistAirport(IAirportBean airportBean) {
        boolean result = false;
        try {
            result = DAOFactory.getInstance().getAirportDAO().persistAirport(null);
        } catch (TransactionException ex) {
            //TODO
        }
        return result;
    }

    @Override
    public boolean removeAirport(IAirportBean airportBean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modifyAirport(IAirportBean airportBean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
