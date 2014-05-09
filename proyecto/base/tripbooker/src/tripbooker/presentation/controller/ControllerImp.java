package tripbooker.presentation.controller;

import java.util.Date;
import java.util.List;
import tripbooker.dto.bean.country.ICountryBean;
import tripbooker.dto.bean.flight.IFlightBean;
import tripbooker.logic.facade.factory.FacadeFactory;
import tripbooker.presentation.controller.event.BusinessEvent;
import tripbooker.presentation.controller.event.GUIEvent;
import tripbooker.presentation.view.TripBookerGUI;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public class ControllerImp extends Controller{
    Object [] params = null;
    List<ICountryBean> countryList = null;
    List<IFlightBean> outboundFlights = null;
    List<IFlightBean> inboundFlights = null;
    
    @Override
    public void action(int event, Object data) {
        
        switch(event){
            case BusinessEvent.APP_START:
                TripBookerGUI.getInstance().setVisible(true);
                this.action(BusinessEvent.USER_LOAD_COUNTRIES, null);
                break;
            //USER
            case BusinessEvent.USER_LOAD_COUNTRIES:
                countryList = FacadeFactory.getInstance().getUserFacade().getAllCountries();
                TripBookerGUI.getInstance().update(GUIEvent.REFRESH_COUNTRIES, countryList);
                break;
            case BusinessEvent.USER_SEARCH_FLIGHTS:
                    params = (Object [])data;
                    outboundFlights = getUserFlights(params[0].toString(),params[1].toString(),(Date)params[2]);
                    if((boolean)params[3]){
                        inboundFlights = getUserFlights(params[1].toString(),params[0].toString(), (Date)params[4]);
                    }
                TripBookerGUI.getInstance().update(GUIEvent.REFRESH_FLIGHTS, new Object []{outboundFlights, inboundFlights});    
                break;
            //
            default:
                
                break;
        }
    }
    
    private List<IFlightBean> getUserFlights(String departureAirportCode, String destinationAirportCode, Date date){
        return FacadeFactory.getInstance().getUserFacade().getAllFlightsByAirports(departureAirportCode,destinationAirportCode);//, date);        
    }

}
