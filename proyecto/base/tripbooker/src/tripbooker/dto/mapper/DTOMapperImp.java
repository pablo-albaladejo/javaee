package tripbooker.dto.mapper;

import tripbooker.dto.bean.aircraft.IAircraftBean;
import tripbooker.dto.bean.airline.IAirlineBean;
import tripbooker.dto.bean.airport.IAirportBean;
import tripbooker.dto.bean.booking.IBookingBean;
import tripbooker.dto.bean.city.ICityBean;
import tripbooker.dto.bean.country.ICountryBean;
import tripbooker.dto.bean.factory.BeanFactory;
import tripbooker.dto.bean.flight.IFlightBean;
import tripbooker.dto.bean.route.IRouteBean;
import tripbooker.dto.bean.ticket.ITicketBean;
import tripbooker.dto.bean.user.IUserBean;
import tripbooker.dto.domain.aircraft.IAircraftDO;
import tripbooker.dto.domain.airline.IAirlineDO;
import tripbooker.dto.domain.airport.IAirportDO;
import tripbooker.dto.domain.booking.IBookingDO;
import tripbooker.dto.domain.city.ICityDO;
import tripbooker.dto.domain.country.ICountryDO;
import tripbooker.dto.domain.flight.IFlightDO;
import tripbooker.dto.domain.route.IRouteDO;
import tripbooker.dto.domain.factory.DOFactory;
import tripbooker.dto.domain.ticket.ITicketDO;
import tripbooker.dto.domain.user.IUserDO;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public class DTOMapperImp extends DTOMapper{
    
    //Country
    @Override
    public ICountryBean getCountryBean(ICountryDO countryDO) {
        ICountryBean countryBean = BeanFactory.getInstance().getCountryBean();
        if(countryDO != null){
            countryBean.setCode(countryDO.getCode());
            countryBean.setName(countryDO.getName());
        }
        return countryBean;
    }

    @Override
    public ICountryDO getCountryDO(ICountryBean countryBean) {
        ICountryDO countryDO = DOFactory.getInstance().getCountryDO();
        if(countryBean != null){
            countryDO.setCode(countryBean.getCode());
            countryDO.setName(countryBean.getName());
        }
        return countryDO;
    }
    
    //City
    @Override
    public ICityBean getCityBean(ICityDO cityDO, ICountryDO countryDO) {
        ICityBean cityBean = BeanFactory.getInstance().getCityBean();
        if(cityDO != null && countryDO != null){
            cityBean.setCode(cityDO.getCode());
            cityBean.setName(cityDO.getName());
            cityBean.setCountryCode(countryDO.getCode());
        }   
        return cityBean;
    }
    
    @Override
    public ICityDO getCityDO(ICityBean cityBean, ICountryDO countryDO) {
        ICityDO cityDO = DOFactory.getInstance().getCityDO();
        if(cityBean != null && countryDO != null){
            cityDO.setCode(cityBean.getCode());
            cityDO.setName(cityBean.getName());
            cityDO.setCountryID(countryDO.getCountryID());
        }
        return cityDO;
    }
    
    //Flight
    @Override
    public IFlightBean getFlightBean(IFlightDO flightDO, 
                                        IAirlineDO airlineDO, 
                                        IAirportDO departure, 
                                        IAirportDO destination,
                                        IAircraftDO aircraftDO){
        
        IFlightBean flightBean = BeanFactory.getInstance().getFlightBean();
        if(flightDO != null && airlineDO != null &&  departure != null 
                && destination != null && aircraftDO != null){
            flightBean.setAirline(airlineDO.getName());
            flightBean.setCode(flightDO.getCode());
            flightBean.setDepartureCode(departure.getCode());
            flightBean.setDestinationCode(destination.getCode());
            flightBean.setAircraftModel(aircraftDO.getModel());
            flightBean.setDate(flightDO.getDate());
            flightBean.setBusinessFare(flightDO.getBusinessFare());
            flightBean.setBusinessSeats(flightDO.getBusinessSeats());
            flightBean.setEconomyFare(flightDO.getEconomyFare());
            flightBean.setOfferFare(flightDO.getOfferFare());
        }
        return flightBean;
    }
    
    @Override
    public IFlightDO getFlightDO(IFlightBean flightBean, 
                                    IAircraftDO aircraftDO, 
                                    IAirlineDO airlineDO, 
                                    IRouteDO routeDO){
        IFlightDO flightDO = DOFactory.getInstance().getFlightDO();
        if(flightBean != null && aircraftDO != null && 
                airlineDO != null && routeDO != null){
            flightDO.setAircraftID(aircraftDO.getAirfarctID());
            flightDO.setAirlineID(airlineDO.getAirlineID());
            flightDO.setBusinessFare(flightBean.getBusinessFare());
            flightDO.setBusinessSeats(flightBean.getBusinessSeats());
            flightDO.setCode(flightBean.getCode());
            flightDO.setDate(flightBean.getDate());
            flightDO.setEconomyFare(flightBean.getEconomyFare());
            flightDO.setOfferFare(flightBean.getOfferFare());
            flightDO.setRouteID(routeDO.getRouteID());
        }
        return flightDO;
    }
    
    //Airport
    @Override
    public IAirportDO getAirportDO(IAirportBean airportBean, ICityDO cityDO) {
        IAirportDO airportDO = DOFactory.getInstance().getAirportDO();
        if(airportBean != null && cityDO != null){
            airportDO.setCityID(cityDO.getCityID());
            airportDO.setName(airportBean.getName());
            airportDO.setCode(airportBean.getCode());
        }
        return airportDO;
    }

    @Override
    public IAirportBean getAirportBean(IAirportDO airportDO, ICityDO cityDO) {
        IAirportBean airportBean = BeanFactory.getInstance().getAirportBean();
        if(airportDO != null && cityDO != null){
            airportBean.setCode(airportDO.getCode());
            airportBean.setName(airportDO.getName());
            airportBean.setCityCode(cityDO.getCode());
        }
        return airportBean;
    }

    @Override
    public IAircraftBean getAircraftBean(IAircraftDO aircraftDO) {
        IAircraftBean aircraftBean = BeanFactory.getInstance().getAircraftBean();
        if(aircraftDO != null){
            aircraftBean.setDate(aircraftDO.getDate());
            aircraftBean.setManufacter(aircraftDO.getManufacter());
            aircraftBean.setModel(aircraftDO.getModel());
            aircraftBean.setSeats(aircraftDO.getSeats());
        }
        return aircraftBean;
    }

    @Override
    public IAircraftDO getAircraftDO(IAircraftBean aircraftBean) {
        IAircraftDO aircraftDO = DOFactory.getInstance().getAircraftDO();
        if(aircraftBean != null){
            aircraftDO.setDate(aircraftBean.getDate());
            aircraftDO.setManufacter(aircraftBean.getManufacter());
            aircraftDO.setModel(aircraftBean.getModel());
            aircraftDO.setSeats(aircraftBean.getSeats());
        }
        return aircraftDO;
    }

    //Airline
    @Override
    public IAirlineBean getAirlineBean(IAirlineDO airlineDO, ICountryDO countryDO) {
        IAirlineBean airlineBean = BeanFactory.getInstance().getAirlineBean();
       
        if(airlineBean != null){
            airlineBean.setCode(airlineDO.getCode());
            airlineBean.setCountryCode(countryDO.getCode());
            airlineBean.setName(airlineDO.getName());
        }
        return airlineBean;
    }

    @Override
    public IAirlineDO getAirlineDO(IAirlineBean airlineBean, ICountryDO countryDO) {
        IAirlineDO airlineDO = DOFactory.getInstance().getAirlineDO();
        if(airlineDO != null){
            airlineDO.setCode(airlineBean.getCode());
            airlineDO.setCountryID(countryDO.getCountryID());
            airlineDO.setName(airlineBean.getName());
        }
        return airlineDO;
    }

    //Route
    @Override
    public IRouteBean getRouteBean(IRouteDO routeDO, IAirportDO departure, IAirportDO destination) {
        IRouteBean routeBean = BeanFactory.getInstance().getRouteBean();
        if(routeBean != null){
            routeBean.setDepartureCode(departure.getCode());
            routeBean.setDestinationCode(destination.getCode());
            routeBean.setDuration(routeDO.getDuration());
        }
        return routeBean;
    }

    @Override
    public IRouteDO getRouteDO(IRouteBean routeBean, IAirportDO departure, IAirportDO destination) {
        IRouteDO routeDO = DOFactory.getInstance().getRouteDO();
        if(routeBean != null && departure != null && destination != null){
            routeDO.setDepartureID(departure.getAirportID());
            routeDO.setDestinationID(destination.getAirportID());
            routeDO.setDuration(routeBean.getDuration());
        }
        return routeDO;
    }
    
    //Bookings
    @Override
    public IBookingBean getBookingBean(IBookingDO bookingDO, IFlightDO flightDO, IUserDO userDO) {
        IBookingBean bookingBean = BeanFactory.getInstance().getBookingBean();
        
        if(bookingDO != null && flightDO != null && userDO != null){
            bookingBean.setBookingCode(bookingDO.getCode());
            bookingBean.setBusiness(bookingDO.isBusiness());
            bookingBean.setFlightCode(flightDO.getCode());
            bookingBean.setFlightDate(flightDO.getDate());
            bookingBean.setUserCode(userDO.getCode());
        }
        return bookingBean;
    }

    @Override
    public IBookingDO getBookingDO(IBookingBean bookingBean, IFlightDO flightDO, IUserDO userDO) {
        IBookingDO bookingDO = DOFactory.getInstance().getBookingDO();
        if(bookingBean != null && flightDO != null && userDO != null){
            bookingDO.setBusiness(bookingBean.isBusiness());
            bookingDO.setCode(bookingBean.getBookingCode());
            bookingDO.setFlightID(flightDO.getFlightID());
            bookingDO.setUserID(userDO.getUserID());
        }
        return bookingDO;               
    }

    //User
    @Override
    public IUserBean getUserBean(IUserDO userDO) {
        IUserBean userBean = BeanFactory.getInstance().getUserBean();
        if(userDO != null){
            userBean.setCode(userDO.getCode());
        }
        return userBean;
    }

    @Override
    public IUserDO getUserDO(IUserBean userBean) {
        IUserDO userDO = DOFactory.getInstance().getUserDO();
        if(userBean != null){
            userDO.setCode(userBean.getCode());
        }
        return userDO;
    }

    @Override
    public ITicketBean getTicketBean(ITicketDO ticketDO,IUserDO userDO, IFlightDO flightDO) {
        ITicketBean ticketBean = BeanFactory.getInstance().getTicketBean();
        if(ticketDO != null && userDO != null && flightDO != null){
            ticketBean.setCode(ticketDO.getCode());
            ticketBean.setUserCode(userDO.getCode());
            ticketBean.setFlightCode(flightDO.getCode());
            ticketBean.setFlightDate(flightDO.getDate());
        }
        return ticketBean;
    }

    @Override
    public ITicketDO getTicketDO(ITicketBean ticketBean, IUserDO userDO, IFlightDO flightDO) {
        ITicketDO ticketDO = DOFactory.getInstance().getTicketDO();
        if(ticketBean != null && userDO != null && flightDO != null){
            ticketDO.setCode(ticketBean.getCode());
            ticketDO.setUserID(userDO.getUserID());
            ticketDO.setFlightID(flightDO.getFlightID());
        }
        return ticketDO;
    }
    
}
