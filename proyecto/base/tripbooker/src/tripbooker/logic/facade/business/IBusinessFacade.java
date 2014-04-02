package tripbooker.logic.facade.business;

import java.util.List;
import tripbooker.dto.bean.aircraft.IAircraftBean;
import tripbooker.dto.bean.airline.IAirlineBean;
import tripbooker.dto.bean.airport.IAirportBean;
import tripbooker.dto.bean.city.ICityBean;
import tripbooker.dto.bean.country.ICountryBean;
import tripbooker.dto.bean.flight.IFlightBean;
import tripbooker.dto.bean.route.IRouteBean;
import tripbooker.dto.domain.route.IRouteDO;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public interface IBusinessFacade {
    //Aircraft
    List<IAircraftBean> getAllAircrafts();
    boolean persistAircraft(IAircraftBean aircraftBean);
    boolean removeAircraft(IAircraftBean aircraftBean);

    //Airline
    List<IAirlineBean> getAllAirlines();
    boolean persistAirline(IAirlineBean airlineBean);
    boolean removeAirline(IAirlineBean airlineBean);
    
    //Airport
    List<IAirportBean> getAllAirports();
    List<IAirportBean> getAirportsByCity(String code);
    boolean persistAirport(IAirportBean airportBean);
    boolean removeAirport(IAirportBean airportBean);
    
    //City
    List<ICityBean> getAllCities();
    boolean persistCity(ICityBean cityBean);
    boolean removeCity(ICityBean cityBean);
    
    //Country
    List<ICountryBean> getAllCountries();
    boolean persistCountry(ICountryBean countryBean);
    boolean removeCountry(ICountryBean countryBean);
    
    //Flight
    List<IFlightBean> getAllFlights();
    List<IFlightBean> getAllFlightsByAirline(String airlineCode);
    List<IFlightBean> getAllFlightsByDeparture(String airportCode);
    List<IFlightBean> getAllFlightsByDestination(String airportCode);
    List<IFlightBean> getAllFlightsByRoute(String depatureCode, String destinationCode);
    
    //Route
    IRouteBean getRouteByCode(String code);
    List<IRouteBean> getAllRoutes();
    List<IRouteBean> getAllRoutesByDeparture(String airportCode);
    List<IRouteBean> getAllRoutesByDestination(String airportCode);
    List<IRouteBean> getAllRoutesByRoute(String departureCode, String destinationCode);
    boolean removeRoute(IRouteBean routeBean);
    boolean persistRoute(IRouteBean routeBean);
}
