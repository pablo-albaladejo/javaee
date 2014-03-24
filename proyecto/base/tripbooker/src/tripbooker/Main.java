package tripbooker;

import java.util.List;
import tripbooker.dto.domain.aircraft.IAircraftDO;
import tripbooker.dto.domain.airline.IAirlineDO;
import tripbooker.dto.domain.airport.IAirportDO;
import tripbooker.dto.domain.route.IRouteDO;
import tripbooker.dto.factory.DTOFactory;
import tripbooker.integration.factory.DAOFactory;
import tripbooker.persistence.database.exception.TransactionException;
import tripbooker.persistence.database.manager.TransactionManager;

public class Main {

    public static void main(String[] args) throws TransactionException {     
        
        TransactionManager.getInstance().begin();
        
//        List<IAirlineDO> list = DAOFactory.getInstance().getAirlineDAO().getAllAirlines();
//        System.out.println(list);
        
//        IAirlineDO airline = DTOFactory.getInstance().getAirlineDO();
//        airline.setAirlineID(0);
//        airline.setCode("ET");
//        airline.setName("Etipopia");
//        airline.setCountryID(1);
//        
//        DAOFactory.getInstance().getAirlineDAO().insertAirline(airline);
//        
//        DAOFactory.getInstance().getAirlineDAO().removeAirline(8);
//        
//        TransactionManager.getInstance().commit();
//        
//        IAirlineDO airline = DAOFactory.getInstance().getAirlineDAO().getAirlineByID(11);
//        System.out.println(airline);
        
//        IAirlineDO airline = DAOFactory.getInstance().getAirlineDAO().getAirlineByID(1);
//        airline.setName("Pablo");
//        
//        DAOFactory.getInstance().getAirlineDAO().insertAirline(airline);
//        
//        list = DAOFactory.getInstance().getAirlineDAO().getAllAirlines();
//        System.out.println(list);
//        
        
//        List<IAircraftDO> list = DAOFactory.getInstance().getAircraftDAO().getAllAircrafts();
//        System.out.println(list);
//        
//        IAircraftDO aircraft = DAOFactory.getInstance().getAircraftDAO().getAircraftByID(1);
//        System.out.println(aircraft);
//        
//        aircraft.setManufacter("Pablo");
//        DAOFactory.getInstance().getAircraftDAO().insertAircraft(aircraft);
//        
//        DAOFactory.getInstance().getAircraftDAO().removeAircraft(2);
//        
//        list = DAOFactory.getInstance().getAircraftDAO().getAllAircrafts();
//        System.out.println(list);
        
//        List<IAirportDO> list = DAOFactory.getInstance().getAirportDAO().getAllAirports();
//        System.out.println(list);
//        TransactionManager.getInstance().close();

        List<IRouteDO> list = DAOFactory.getInstance().getRouteDAO().getAllRoutes();
        System.out.println(list);
        
        TransactionManager.getInstance().close();        
        
    }
    
}
