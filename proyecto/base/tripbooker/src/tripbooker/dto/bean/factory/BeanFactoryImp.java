package tripbooker.dto.bean.factory;

import tripbooker.dto.bean.aircraft.AircraftBean;
import tripbooker.dto.bean.aircraft.IAircraftBean;
import tripbooker.dto.bean.airline.AirlineBean;
import tripbooker.dto.bean.airline.IAirlineBean;
import tripbooker.dto.bean.airport.AirportBean;
import tripbooker.dto.bean.airport.IAirportBean;
import tripbooker.dto.bean.booking.BookingBean;
import tripbooker.dto.bean.booking.IBookingBean;
import tripbooker.dto.bean.city.CityBean;
import tripbooker.dto.bean.city.ICityBean;
import tripbooker.dto.bean.country.CountryBean;
import tripbooker.dto.bean.country.ICountryBean;
import tripbooker.dto.bean.flight.FlightBean;
import tripbooker.dto.bean.flight.IFlightBean;
import tripbooker.dto.bean.route.IRouteBean;
import tripbooker.dto.bean.route.RouteBean;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public class BeanFactoryImp extends BeanFactory{
 @Override
    public IFlightBean getFlightBean() {
        return new FlightBean();
    }

    @Override
    public IAirportBean getAirportBean() {
        return new AirportBean();
    }

    @Override
    public ICityBean getCityBean() {
        return new CityBean();
    }

    @Override
    public ICountryBean getCountryBean() {
        return new CountryBean();
    }

    @Override
    public IAircraftBean getAircraftBean() {
        return new AircraftBean();
    }

    @Override
    public IAirlineBean getAirlineBean() {
        return new AirlineBean();
    }

    @Override
    public IRouteBean getRouteBean() {
        return new RouteBean();
    }

    @Override
    public IBookingBean getBookingBean() {
        return new BookingBean();
    }
}
