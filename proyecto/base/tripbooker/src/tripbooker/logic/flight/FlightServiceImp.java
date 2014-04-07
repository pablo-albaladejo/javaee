package tripbooker.logic.flight;

import java.util.ArrayList;
import java.util.List;
import tripbooker.dto.bean.flight.IFlightBean;
import tripbooker.dto.domain.aircraft.IAircraftDO;
import tripbooker.dto.domain.airline.IAirlineDO;
import tripbooker.dto.domain.airport.IAirportDO;
import tripbooker.dto.domain.flight.IFlightDO;
import tripbooker.dto.domain.route.IRouteDO;
import tripbooker.dto.mapper.DTOMapper;
import tripbooker.integration.factory.DAOFactory;
import tripbooker.persistence.database.exception.TransactionException;
import tripbooker.persistence.database.manager.TransactionManager;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public class FlightServiceImp implements IFlightService{

    @Override
    public List<IFlightBean> getAllFlights() {
        List<IFlightBean> result = new ArrayList<IFlightBean>();
            try {
                //Get all the flights
                List<IFlightDO> flightDOlist = DAOFactory.getInstance().getFlightDAO().getAllFlights();

                for(IFlightDO flightDO : flightDOlist){
                    //Get Airline
                    IAirlineDO airlineDO = DAOFactory.getInstance().getAirlineDAO().getAirlineByID(flightDO.getAirlineID());
                
                    //Get Route
                    IRouteDO routeDO = DAOFactory.getInstance().getRouteDAO().getRouteByID(flightDO.getRouteID());

                    //Get the airports
                    IAirportDO departure = DAOFactory.getInstance().getAirportDAO().getAirportByID(routeDO.getDepartureID());
                    IAirportDO destination = DAOFactory.getInstance().getAirportDAO().getAirportByID(routeDO.getDepartureID());

                    //Get the aircraft
                    IAircraftDO aircraftDO = DAOFactory.getInstance().getAircraftDAO().getAircraftByID(flightDO.getAircraftID());

                    //Convert the data
                    IFlightBean flightBean = DTOMapper.getInstance().getFlightBean(flightDO, airlineDO, departure, destination, aircraftDO);

                    //Store the result
                    result.add(flightBean);
                }

            } catch (TransactionException ex) {
                //TODO
            }
        return result;
    }
    
    @Override
    public List<IFlightBean> getAllFlightsByAirline(String airlineCode) {
        List<IFlightBean> result = new ArrayList<IFlightBean>();
            try {
                //Get Airline
                IAirlineDO airlineDO = DAOFactory.getInstance().getAirlineDAO().getAirlineByCode(airlineCode);

                if(airlineDO != null){
                    //Get all the flights by Airline
                    List<IFlightDO> flightDOlist = DAOFactory.getInstance().getFlightDAO().getFlightsByAirline(airlineDO.getAirlineID());

                    for(IFlightDO flightDO : flightDOlist){               
                        //Get Route
                        IRouteDO routeDO = DAOFactory.getInstance().getRouteDAO().getRouteByID(flightDO.getRouteID());

                        //Get the airports
                        IAirportDO departure = DAOFactory.getInstance().getAirportDAO().getAirportByID(routeDO.getDepartureID());
                        IAirportDO destination = DAOFactory.getInstance().getAirportDAO().getAirportByID(routeDO.getDepartureID());

                        //Get the aircraft
                        IAircraftDO aircraftDO = DAOFactory.getInstance().getAircraftDAO().getAircraftByID(flightDO.getAircraftID());

                        //Convert the data
                        IFlightBean flightBean = DTOMapper.getInstance().getFlightBean(flightDO, airlineDO, departure, destination, aircraftDO);
                        
                        //Store the result
                        result.add(flightBean);
                    }
                }

            } catch (TransactionException ex) {
                //TODO
            }
        return result;
    }

    @Override
    public List<IFlightBean> getAllFlightsByDeparture(String airportCode) {
        List<IFlightBean> resultBean = new ArrayList<IFlightBean>();
        try {
            //Get Airport
            IAirportDO departure = DAOFactory.getInstance().getAirportDAO().getAirportByCode(airportCode);
            
            if(departure != null){
                //Get all the routes from departure
                List<IRouteDO> routesDO = DAOFactory.getInstance().getRouteDAO().getAllRoutesByDeparture(departure.getAirportID());

                for(IRouteDO routeDO : routesDO){
                    //Get the destination
                    IAirportDO destination = DAOFactory.getInstance().getAirportDAO().getAirportByID(routeDO.getDepartureID());

                    //Get all flights for each route
                    List<IFlightDO> flightsDO = DAOFactory.getInstance().getFlightDAO().getFlightsByRoute(routeDO.getRouteID());
                    for(IFlightDO flightDO : flightsDO){

                        //Get the Airline
                        IAirlineDO airlineDO = DAOFactory.getInstance().getAirlineDAO().getAirlineByID(flightDO.getAirlineID());

                        //Get the Aircraft
                        IAircraftDO aircraftDO = DAOFactory.getInstance().getAircraftDAO().getAircraftByID(flightDO.getAircraftID());

                        IFlightBean flightBean = DTOMapper.getInstance().getFlightBean(flightDO, airlineDO, departure, destination, aircraftDO);
                        resultBean.add(flightBean);
                    }
                }
            }
        } catch (TransactionException ex) {
            //TODO
        }
        return resultBean;
    }
    
    @Override
    public List<IFlightBean> getAllFlightsByDestination(String airportCode) {
        List<IFlightBean> resultBean = new ArrayList<IFlightBean>();
        try {
            //Get Airport
            IAirportDO destination = DAOFactory.getInstance().getAirportDAO().getAirportByCode(airportCode);
            
            if(destination != null){
                //Get all the routes from departure
                List<IRouteDO> routesDO = DAOFactory.getInstance().getRouteDAO().getAllRoutesByDestination(destination.getAirportID());

                for(IRouteDO routeDO : routesDO){
                    //Get the Airports
                    IAirportDO departure = DAOFactory.getInstance().getAirportDAO().getAirportByID(routeDO.getDepartureID());

                    //Get all flights for each route
                    List<IFlightDO> flightsDO = DAOFactory.getInstance().getFlightDAO().getFlightsByRoute(routeDO.getRouteID());
                    for(IFlightDO flightDO : flightsDO){

                        //Get the Airline
                        IAirlineDO airlineDO = DAOFactory.getInstance().getAirlineDAO().getAirlineByID(flightDO.getAirlineID());

                        //Get the Aircraft
                        IAircraftDO aircraftDO = DAOFactory.getInstance().getAircraftDAO().getAircraftByID(flightDO.getAircraftID());

                        IFlightBean flightBean = DTOMapper.getInstance().getFlightBean(flightDO, airlineDO, departure, destination, aircraftDO);
                        resultBean.add(flightBean);
                    }
                }
            }
        } catch (TransactionException ex) {
            //TODO
        }
        return resultBean;
    }

    @Override
    public List<IFlightBean> getAllFlightsByRoute(String depatureCode, String destinationCode) {
       List<IFlightBean> resultBean = new ArrayList<IFlightBean>();
    
       return resultBean;
    }

    @Override
    public boolean persistFlight(IFlightBean flightBean) {
        boolean result = false;
        try {
            TransactionManager.getInstance().begin();
            IAirportDO departureDO = DAOFactory.getInstance().getAirportDAO().getAirportByCode(flightBean.getDepartureCode());
            IAirportDO destinationDO = DAOFactory.getInstance().getAirportDAO().getAirportByCode(flightBean.getDestinationCode());
            if(departureDO != null && destinationDO != null){
                
                IRouteDO routeDO = DAOFactory.getInstance().getRouteDAO().getRoute(departureDO.getAirportID(), destinationDO.getAirportID());
                IAirlineDO airlineDO = DAOFactory.getInstance().getAirlineDAO().getAirlineByCode(flightBean.getAirline());
                IAircraftDO aircraftDO =  DAOFactory.getInstance().getAircraftDAO().getAircraftByModel(flightBean.getAircraftModel());
                if(routeDO != null && airlineDO != null && aircraftDO != null){
                    IFlightDO flightDO = DTOMapper.getInstance().getFlightDO(flightBean, aircraftDO, airlineDO, routeDO);
                    result = DAOFactory.getInstance().getFlightDAO().persistFlight(flightDO);
                }
            }
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
    public boolean removeFlight(IFlightBean flightBean) {
        boolean result = false;
        try {
            TransactionManager.getInstance().begin();
            IFlightDO flightDO = DAOFactory.getInstance().getFlightDAO().getFlightByCodeDate(flightBean.getCode(),flightBean.getDate());
            if(flightDO != null){
                result = DAOFactory.getInstance().getFlightDAO().removeFlight(flightDO.getFlightID());
            }
            TransactionManager.getInstance().commit();
        }catch (TransactionException ex) {
            try {
                TransactionManager.getInstance().rollback();
            } catch (TransactionException ex1) {
                //TODO - Rollbacke error
            }
        }finally{
            try {
                TransactionManager.getInstance().close();
            } catch (TransactionException ex) {
                //TODO - Close Error
            }
        }
        return result;
    }
}
