package tripbooker.logic.route;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tripbooker.dto.bean.route.IRouteBean;
import tripbooker.dto.domain.airport.IAirportDO;
import tripbooker.dto.domain.route.IRouteDO;
import tripbooker.dto.mapper.DTOMapper;
import tripbooker.integration.factory.DAOFactory;
import tripbooker.persistence.database.exception.TransactionException;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public class RouteServiceImp implements IRouteService{

    @Override
    public IRouteBean getRouteByCode(String code) {
        IRouteBean routeBean = null;
        try {
            IRouteDO routeDO = DAOFactory.getInstance().getRouteDAO().getRouteByCode(code);
            if(routeDO != null){
                IAirportDO departureDO = DAOFactory.getInstance().getAirportDAO().getAirportByID(routeDO.getDepartureID());
                IAirportDO destinationDO = DAOFactory.getInstance().getAirportDAO().getAirportByID(routeDO.getDestinationID());
                routeBean =  DTOMapper.getInstance().getRouteBean(routeDO, departureDO, destinationDO);
            }
        } catch (TransactionException ex) {
            //TODO
        }
        return routeBean;
    }
    
    @Override
    public List<IRouteBean> getAllRoutes() {
        List<IRouteBean> result = new ArrayList<IRouteBean>();
        try {
            List<IRouteDO> list = DAOFactory.getInstance().getRouteDAO().getAllRoutes();
            for(IRouteDO routeDO : list){
                IAirportDO departureDO = DAOFactory.getInstance().getAirportDAO().getAirportByID(routeDO.getDepartureID());
                IAirportDO destinationDO = DAOFactory.getInstance().getAirportDAO().getAirportByID(routeDO.getDestinationID());
                result.add(DTOMapper.getInstance().getRouteBean(routeDO, departureDO, destinationDO));
            }
        } catch (TransactionException ex) {
            //TODO
        }
        return result;
    }

    @Override
    public List<IRouteBean> getAllRoutesByDeparture(String airportCode) {
        List<IRouteBean> result = new ArrayList<IRouteBean>();
        try {
            IAirportDO departureDO = DAOFactory.getInstance().getAirportDAO().getAirportByCode(airportCode);
            if(departureDO != null){
                List<IRouteDO> list = DAOFactory.getInstance().getRouteDAO().getAllRoutesByDeparture(departureDO.getAirportID());
                for(IRouteDO routeDO : list){
                    IAirportDO destinationDO = DAOFactory.getInstance().getAirportDAO().getAirportByID(routeDO.getDestinationID());
                    result.add(DTOMapper.getInstance().getRouteBean(routeDO, departureDO, destinationDO));
                }
            }
        } catch (TransactionException ex) {
            //TODO
        }
        return result;
    }

    @Override
    public List<IRouteBean> getAllRoutesByDestination(String airportCode) {
        List<IRouteBean> result = new ArrayList<IRouteBean>();
        try {
            IAirportDO departureDO = DAOFactory.getInstance().getAirportDAO().getAirportByCode(airportCode);
            if(departureDO != null){
                List<IRouteDO> list = DAOFactory.getInstance().getRouteDAO().getAllRoutesByDestination(departureDO.getAirportID());
                for(IRouteDO routeDO : list){
                    IAirportDO destinationDO = DAOFactory.getInstance().getAirportDAO().getAirportByID(routeDO.getDestinationID());
                    result.add(DTOMapper.getInstance().getRouteBean(routeDO, departureDO, destinationDO));
                }
            }
        } catch (TransactionException ex) {
            //TODO
        }
        return result;
    }

    @Override
    public List<IRouteBean> getAllRoutesByRoute(String departureCode, String destinationCode) {
        List<IRouteBean> result = new ArrayList<IRouteBean>();
        try {
            IAirportDO departureDO = DAOFactory.getInstance().getAirportDAO().getAirportByCode(departureCode);
            IAirportDO destinationDO = DAOFactory.getInstance().getAirportDAO().getAirportByCode(destinationCode);
            if(departureDO != null && destinationDO != null){
                List<IRouteDO> list = DAOFactory.getInstance().getRouteDAO().getAllRoutesByRoute(departureDO.getAirportID(), destinationDO.getAirportID());
            }
        } catch (TransactionException ex) {
            //TODO
        }
        return result;
    }

    @Override
    public boolean removeRoute(IRouteBean routeBean) {
        boolean result = false;
        try{
            IRouteDO routeDO = DAOFactory.getInstance().getRouteDAO().getRouteByCode(routeBean.getCode());
            if(routeDO != null){
                result = DAOFactory.getInstance().getRouteDAO().removeRoute(routeDO.getRouteID());
            }
        }catch(TransactionException ex){
            //TODO
        }
        return result;
    }

    @Override
    public boolean persistRoute(IRouteBean routeBean) {
        boolean result = false;
        try{
            IAirportDO departureDO = DAOFactory.getInstance().getAirportDAO().getAirportByCode(routeBean.getDepartureCode());
            IAirportDO destinationDO = DAOFactory.getInstance().getAirportDAO().getAirportByCode(routeBean.getDestinationCode());
            if(departureDO != null && destinationDO != null){
                IRouteDO routeDO = DTOMapper.getInstance().getRouteDO(routeBean,departureDO,destinationDO);
                result = DAOFactory.getInstance().getRouteDAO().persistRoute(routeDO);
            }
        }catch(TransactionException ex){
            //TODO
        }
        return result;
    }
}
