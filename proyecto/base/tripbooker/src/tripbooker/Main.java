package tripbooker;

import java.util.Date;
import java.util.List;
import tripbooker.dto.bean.airport.IAirportBean;
import tripbooker.dto.bean.city.ICityBean;
import tripbooker.dto.bean.country.ICountryBean;
import tripbooker.dto.bean.flight.IFlightBean;
import tripbooker.dto.domain.aircraft.IAircraftDO;
import tripbooker.dto.domain.airline.IAirlineDO;
import tripbooker.dto.domain.airport.IAirportDO;
import tripbooker.dto.domain.flight.IFlightDO;
import tripbooker.dto.domain.route.IRouteDO;
import tripbooker.dto.factory.DTOFactory;
import tripbooker.integration.factory.DAOFactory;
import tripbooker.logic.factory.ServiceFactory;
import tripbooker.persistence.database.exception.TransactionException;
import tripbooker.persistence.database.manager.TransactionManager;

public class Main {

    public static void main(String[] args) throws TransactionException {     
        
//        TransactionManager.getInstance().begin();
        
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
//
//        List<IRouteDO> list = DAOFactory.getInstance().getRouteDAO().getAllRoutes();
//        System.out.println(list);
//   
//        IRouteDO route = DAOFactory.getInstance().getRouteDAO().getRouteByID(1);
//        route.setDuration(555);
//        
//        DAOFactory.getInstance().getRouteDAO().insertRoute(route);
//        list = DAOFactory.getInstance().getRouteDAO().getAllRoutes();
//        System.out.println(list);
        
//        List<IFlightDO> list = DAOFactory.getInstance().getFlightDAO().getAllFlights();
//        System.out.println(list);
//        
//        IFlightDO flight = DAOFactory.getInstance().getFlightDAO().getFlightByID(1);
//        flight.setDate(new Date());
//        flight.setFlightID(2);
//        flight.setCode("2");
//        DAOFactory.getInstance().getFlightDAO().insertFlight(flight);
//        list = DAOFactory.getInstance().getFlightDAO().getAllFlights();
//        System.out.println(list);
        
//        TransactionManager.getInstance().close();        
        
//      List<IFlightBean> list = ServiceFactory.getInstance().getBusinessFacade().getAllFlights();
        //List<IFlightBean> list = ServiceFactory.getInstance().getBusinessFacade().getAllFlightsByAirline("JK");
        //List<IFlightBean> list = ServiceFactory.getInstance().getBusinessFacade().getAllFlightsByDeparture("MAD");
        //List<IFlightBean> list = ServiceFactory.getInstance().getBusinessFacade().getAllFlightsByDestination("MCV");
        //List<IFlightBean> list = ServiceFactory.getInstance().getBusinessFacade().getAllFlightsByRoute("MD","MCV");
        //System.out.println(list);
        
//        List<ICityBean> list = ServiceFactory.getInstance().getBusinessFacade().getAllCities();
//        System.out.println(list);
//        
//        ICityBean city =DTOFactory.getInstance().getCityBean();
//        city.setCode("BCN");
//        city.setName("NAme");
//        boolean result = ServiceFactory.getInstance().getBusinessFacade().persistCity(city);
//        System.out.println(result);
//        
//        list = ServiceFactory.getInstance().getBusinessFacade().getAllCities();
//        System.out.println(list);
//        
//        ServiceFactory.getInstance().getBusinessFacade().removeCity(city);
//        
//        list = ServiceFactory.getInstance().getBusinessFacade().getAllCities();
//        System.out.println(list);
//        
//        TransactionManager.getInstance().begin();
//        
//        List<IAirportBean> list = ServiceFactory.getInstance().getBusinessFacade().getAirportsByCity("MAD");
//        System.out.println(list);
//        
//        TransactionManager.getInstance().close();  
        TransactionManager.getInstance().begin();
        
        List<ICountryBean> list = ServiceFactory.getInstance().getBusinessFacade().getAllCountries();
        System.out.println(list);
        
        TransactionManager.getInstance().close();  
    }
    
}
