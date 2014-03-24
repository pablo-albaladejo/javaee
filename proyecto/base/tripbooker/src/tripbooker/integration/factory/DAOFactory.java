package tripbooker.integration.factory;

import tripbooker.integration.aircraft.IAircraftDAO;
import tripbooker.integration.airline.IAirlineDAO;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public abstract class DAOFactory {
    private static DAOFactory instance;
    
    public static synchronized DAOFactory getInstance(){
        if(instance == null) instance = new DAOFactoryImp();
        return instance;
    }
    
    public abstract IAirlineDAO getAirlineDAO();
    public abstract IAircraftDAO getAircraftDAO();
}
