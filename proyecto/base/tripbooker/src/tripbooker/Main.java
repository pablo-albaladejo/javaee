package tripbooker;

import java.util.Date;
import tripbooker.dto.bean.aircraft.IAircraftBean;
import tripbooker.dto.bean.airline.IAirlineBean;
import tripbooker.dto.bean.airport.IAirportBean;
import tripbooker.dto.bean.city.ICityBean;
import tripbooker.dto.bean.country.ICountryBean;
import tripbooker.dto.bean.route.IRouteBean;
import tripbooker.dto.factory.DTOFactory;
import tripbooker.logic.factory.ServiceFactory;

public class Main {

    public static void main(String[] args) {           
//        //Country
//        ICountryBean countryBean = DTOFactory.getInstance().getCountryBean();
//        
//        countryBean.setCode("ES");
//        countryBean.setName("Spain");
//        ServiceFactory.getInstance().getBusinessFacade().persistCountry(countryBean);
//        
//        countryBean.setCode("US");
//        countryBean.setName("United States");
//        ServiceFactory.getInstance().getBusinessFacade().persistCountry(countryBean);
//        
//        System.out.println(ServiceFactory.getInstance().getBusinessFacade().getAllCountries());
//        
//        //City
//        ICityBean cityBean = DTOFactory.getInstance().getCityBean();
//        
//        cityBean.setCode("MAD");
//        cityBean.setName("Madrid");
//        cityBean.setCountryCode("ES");        
//        ServiceFactory.getInstance().getBusinessFacade().persistCity(cityBean);
//        
//        cityBean.setCode("VAL");
//        cityBean.setName("Valencia");
//        cityBean.setCountryCode("ES");
//        ServiceFactory.getInstance().getBusinessFacade().persistCity(cityBean);
//        
//        cityBean.setCode("SEV");
//        cityBean.setName("Sevilla");
//        cityBean.setCountryCode("ES");
//        ServiceFactory.getInstance().getBusinessFacade().persistCity(cityBean);
//
//        cityBean.setCode("BCN");
//        cityBean.setName("Barcelona");
//        cityBean.setCountryCode("ES");
//        ServiceFactory.getInstance().getBusinessFacade().persistCity(cityBean);
//        
//        cityBean.setCode("NYK");
//        cityBean.setName("New York");
//        cityBean.setCountryCode("US");
//        ServiceFactory.getInstance().getBusinessFacade().persistCity(cityBean);
//        
//        System.out.println( ServiceFactory.getInstance().getBusinessFacade().getAllCities());
        
//        //Airport
//        IAirportBean airportBean = DTOFactory.getInstance().getAirportBean();
//        
//        airportBean.setCityCode("MAD");
//        airportBean.setCode("MAD");
//        airportBean.setName("Madrid Barajas International Airport");
//        ServiceFactory.getInstance().getBusinessFacade().persistAirport(airportBean);
//        
//        airportBean.setCityCode("MAD");
//        airportBean.setCode("MCV");
//        airportBean.setName("Madrid Cuatro Vientos Airport");
//        ServiceFactory.getInstance().getBusinessFacade().persistAirport(airportBean);
//        
//        airportBean.setCityCode("MAD");
//        airportBean.setCode("TOJ");
//        airportBean.setName("Torrejón de Ardoz Airport");
//        ServiceFactory.getInstance().getBusinessFacade().persistAirport(airportBean);
//        
//        airportBean.setCityCode("BCN");
//        airportBean.setCode("BCN");
//        airportBean.setName("El Prat de Llobregat");
//        ServiceFactory.getInstance().getBusinessFacade().persistAirport(airportBean);
//        
//        airportBean.setCityCode("VAL");
//        airportBean.setCode("VLC");
//        airportBean.setName("Manises");
//        ServiceFactory.getInstance().getBusinessFacade().persistAirport(airportBean);
//        
//        airportBean.setCityCode("SEV");
//        airportBean.setCode("SVQ");
//        airportBean.setName("Sevilla");
//        ServiceFactory.getInstance().getBusinessFacade().persistAirport(airportBean);
//        
//        airportBean.setCityCode("NYK");
//        airportBean.setCode("JFK");
//        airportBean.setName("John F. Kennedy International Airport");
//        ServiceFactory.getInstance().getBusinessFacade().persistAirport(airportBean);
//        
//        System.out.println(ServiceFactory.getInstance().getBusinessFacade().getAllAirports());
//        
//        //Route
//        IRouteBean routeBean = DTOFactory.getInstance().getRouteBean();
//        
//        routeBean.setDepartureCode("MAD");
//        routeBean.setDestinationCode("MCV");
//        routeBean.setDuration(30);
//        ServiceFactory.getInstance().getBusinessFacade().persistRoute(routeBean);
//        
//        routeBean.setDepartureCode("MCV");
//        routeBean.setDestinationCode("MAD");
//        routeBean.setDuration(36);
//        ServiceFactory.getInstance().getBusinessFacade().persistRoute(routeBean);
//        
//        routeBean.setDepartureCode("MAD");
//        routeBean.setDestinationCode("JFK");
//        routeBean.setDuration(300);
//        ServiceFactory.getInstance().getBusinessFacade().persistRoute(routeBean);
//        
//        routeBean.setDepartureCode("JFK");
//        routeBean.setDestinationCode("MAD");
//        routeBean.setDuration(400);
//        ServiceFactory.getInstance().getBusinessFacade().persistRoute(routeBean);
//        
//        System.out.println(ServiceFactory.getInstance().getBusinessFacade().getAllRoutes());
//        //Aircraft
//        IAircraftBean aircraftBean = DTOFactory.getInstance().getAircraftBean();
//        
//        aircraftBean.setDate(new Date());
//        aircraftBean.setManufacter("Airbus");
//        aircraftBean.setModel("A230");
//        aircraftBean.setSeats(100);
//        ServiceFactory.getInstance().getBusinessFacade().persistAircraft(aircraftBean);
//        
//        aircraftBean.setDate(new Date());
//        aircraftBean.setManufacter("Airbus");
//        aircraftBean.setModel("A400");
//        aircraftBean.setSeats(200);
//        ServiceFactory.getInstance().getBusinessFacade().persistAircraft(aircraftBean);
//        
//        System.out.println(ServiceFactory.getInstance().getBusinessFacade().getAllAircrafts());
//        
//        //Airline
//        IAirlineBean airlineBean = DTOFactory.getInstance().getAirlineBean();
//        
//        airlineBean.setCode("IB");
//        airlineBean.setName("Iberia");
//        airlineBean.setCountryCode("ES");
//        ServiceFactory.getInstance().getBusinessFacade().persistAirline(airlineBean);
//                
//        airlineBean.setCode("AA");
//        airlineBean.setName("American Airlines");
//        airlineBean.setCountryCode("US");
//        ServiceFactory.getInstance().getBusinessFacade().persistAirline(airlineBean);
//        
//        System.out.println(ServiceFactory.getInstance().getBusinessFacade().getAllAirlines());
    }
    
}
