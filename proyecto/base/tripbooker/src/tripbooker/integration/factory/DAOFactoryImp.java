package tripbooker.integration.factory;

import tripbooker.integration.aircraft.AircraftDAOImp;
import tripbooker.integration.aircraft.IAircraftDAO;
import tripbooker.integration.airline.AirlineDAOImp;
import tripbooker.integration.airline.IAirlineDAO;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public class DAOFactoryImp extends DAOFactory{

    @Override
    public IAirlineDAO getAirlineDAO() {
        return new AirlineDAOImp();
    }

    @Override
    public IAircraftDAO getAircraftDAO() {
        return new AircraftDAOImp();
    }

}
