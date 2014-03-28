package tripbooker.logic.facade.business;

import java.util.List;
import tripbooker.dto.bean.airport.IAirportBean;
import tripbooker.dto.bean.city.ICityBean;
import tripbooker.dto.bean.country.ICountryBean;
import tripbooker.dto.bean.flight.IFlightBean;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public interface IBusinessFacade {
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
    
    //Flights
    List<IFlightBean> getAllFlights();
    List<IFlightBean> getAllFlightsByAirline(String airlineCode);
    List<IFlightBean> getAllFlightsByDeparture(String airportCode);
    List<IFlightBean> getAllFlightsByDestination(String airportCode);
    List<IFlightBean> getAllFlightsByRoute(String depatureCode, String destinationCode);
}
