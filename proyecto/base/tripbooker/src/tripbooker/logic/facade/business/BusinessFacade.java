package tripbooker.logic.facade.business;

import java.util.List;
import tripbooker.dto.bean.airport.IAirportBean;
import tripbooker.dto.bean.city.ICityBean;
import tripbooker.dto.bean.country.ICountryBean;
import tripbooker.dto.bean.flight.IFlightBean;
import tripbooker.logic.factory.ServiceFactory;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public class BusinessFacade implements IBusinessFacade{

    @Override
    public List<IAirportBean> getAllAirports() {
        return ServiceFactory.getInstance().getAirportService().getAllAirports();
    }

    @Override
    public List<IAirportBean> getAirportsByCity(String code) {
        return ServiceFactory.getInstance().getAirportService().getAirportsByCity(code);
    }
    
    @Override
    public boolean persistAirport(IAirportBean airportBean) {
        return ServiceFactory.getInstance().getAirportService().persistAirport(airportBean);
    }

    @Override
    public boolean removeAirport(IAirportBean airportBean) {
        return ServiceFactory.getInstance().getAirportService().removeAirport(airportBean);
    }
    
    
    @Override
    public List<ICityBean> getAllCities() {
        return ServiceFactory.getInstance().getCityService().getAllCities();
    }
    
    @Override
    public boolean persistCity(ICityBean cityBean) {
        return ServiceFactory.getInstance().getCityService().persistCity(cityBean);
    }

    @Override
    public boolean removeCity(ICityBean cityBean) {
        return ServiceFactory.getInstance().getCityService().removeCity(cityBean);
    }
    
        @Override
    public List<ICountryBean> getAllCountries() {
        return ServiceFactory.getInstance().getCountryService().getAllCountries();
    }

    @Override
    public boolean persistCountry(ICountryBean countryBean) {
        return ServiceFactory.getInstance().getCountryService().persistCountry(countryBean);
    }

    @Override
    public boolean removeCountry(ICountryBean countryBean) {
        return ServiceFactory.getInstance().getCountryService().removeCountry(countryBean);
    }
    
    @Override
    public List<IFlightBean> getAllFlights() {
         return ServiceFactory.getInstance().getFlightService().getAllFlights();
    }
    
    @Override
    public List<IFlightBean> getAllFlightsByAirline(String airlineCode) {
        return ServiceFactory.getInstance().getFlightService().getAllFlightsByAirline(airlineCode);
    }
    
    @Override
    public List<IFlightBean> getAllFlightsByDeparture(String airportCode) {
        return ServiceFactory.getInstance().getFlightService().getAllFlightsByDeparture(airportCode);
    }
    
    @Override
    public List<IFlightBean> getAllFlightsByDestination(String airportCode) {
        return ServiceFactory.getInstance().getFlightService().getAllFlightsByDestination(airportCode);
    }

    @Override
    public List<IFlightBean> getAllFlightsByRoute(String depatureCode, String destinationCode) {
        return ServiceFactory.getInstance().getFlightService().getAllFlightsByRoute(depatureCode,destinationCode);
    }
}
