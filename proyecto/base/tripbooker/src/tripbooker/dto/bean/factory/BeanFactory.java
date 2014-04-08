package tripbooker.dto.bean.factory;

import tripbooker.dto.bean.aircraft.IAircraftBean;
import tripbooker.dto.bean.airline.IAirlineBean;
import tripbooker.dto.bean.airport.IAirportBean;
import tripbooker.dto.bean.booking.IBookingBean;
import tripbooker.dto.bean.city.ICityBean;
import tripbooker.dto.bean.country.ICountryBean;
import tripbooker.dto.bean.flight.IFlightBean;
import tripbooker.dto.bean.route.IRouteBean;
import tripbooker.dto.bean.ticket.ITicketBean;
import tripbooker.dto.bean.user.IUserBean;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public abstract class BeanFactory {
    private static BeanFactory instance;
    
    public static synchronized BeanFactory getInstance(){
        if(instance == null) instance = new BeanFactoryImp();
        return instance;
    }

    public abstract IFlightBean getFlightBean();
    public abstract IAirportBean getAirportBean();
    public abstract ICityBean getCityBean();
    public abstract ICountryBean getCountryBean();
    public abstract IAircraftBean getAircraftBean();
    public abstract IAirlineBean getAirlineBean();
    public abstract IRouteBean getRouteBean();
    public abstract IBookingBean getBookingBean();
    public abstract IUserBean getUserBean();
    public abstract ITicketBean getTicketBean();
}
