package tripbooker.logic.route;

import java.util.ArrayList;
import java.util.List;
import tripbooker.dto.bean.route.IRouteBean;
import tripbooker.dto.domain.airport.IAirportDO;
import tripbooker.dto.domain.route.IRouteDO;
import tripbooker.dto.mapper.DTOMapper;
import tripbooker.integration.factory.DAOFactory;
import tripbooker.persistence.database.exception.TransactionException;
import tripbooker.persistence.database.manager.TransactionManager;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public class RouteServiceImp implements IRouteService{
   
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
    public IRouteBean getRoute(String departureCode, String destinationCode) {
        IAirportDO departureDO = null;
        IAirportDO destinationDO = null;
        IRouteDO routeDO = null;
        try {
            departureDO = DAOFactory.getInstance().getAirportDAO().getAirportByCode(departureCode);
            destinationDO = DAOFactory.getInstance().getAirportDAO().getAirportByCode(destinationCode);
            if(departureDO != null && destinationDO != null){
                routeDO = DAOFactory.getInstance().getRouteDAO().getRoute(departureDO.getAirportID(), destinationDO.getAirportID());
            }
        } catch (TransactionException ex) {
            //TODO
        }
        return DTOMapper.getInstance().getRouteBean(routeDO, departureDO, destinationDO);
    }
    
    @Override
    public boolean removeRoute(IRouteBean routeBean) {
        boolean result = false;
        try{
            TransactionManager.getInstance().begin();
            IAirportDO departureDO = DAOFactory.getInstance().getAirportDAO().getAirportByCode(routeBean.getDepartureCode());
            IAirportDO destinationDO = DAOFactory.getInstance().getAirportDAO().getAirportByCode(routeBean.getDestinationCode());
            IRouteDO routeDO = DAOFactory.getInstance().getRouteDAO().getRoute(departureDO.getAirportID(),destinationDO.getAirportID());
            if(routeDO != null){
                result = DAOFactory.getInstance().getRouteDAO().removeRoute(routeDO.getRouteID());
                TransactionManager.getInstance().commit();
            }
        }catch(TransactionException ex){
            try {
                TransactionManager.getInstance().rollback();
            } catch (TransactionException ex1) {
                //TODO - Rollback error
            }
        }finally{
            try {
                TransactionManager.getInstance().close();
            } catch (TransactionException ex) {
                //TODO - close error
            }
        }
        return result;
    }

    @Override
    public boolean persistRoute(IRouteBean routeBean) {
        boolean result = false;
        try{
            TransactionManager.getInstance().begin();
            IAirportDO departureDO = DAOFactory.getInstance().getAirportDAO().getAirportByCode(routeBean.getDepartureCode());
            IAirportDO destinationDO = DAOFactory.getInstance().getAirportDAO().getAirportByCode(routeBean.getDestinationCode());
            if(departureDO != null && destinationDO != null){
                IRouteDO routeDO = DTOMapper.getInstance().getRouteDO(routeBean,departureDO,destinationDO);
                result = DAOFactory.getInstance().getRouteDAO().persistRoute(routeDO);
                TransactionManager.getInstance().commit();
            }
        }catch(TransactionException ex){
            try {
                TransactionManager.getInstance().rollback();
            } catch (TransactionException ex1) {
                //TODO - Rollback error
            }
        }finally{
            try {
                TransactionManager.getInstance().close();
            } catch (TransactionException ex) {
                //TODO Close error
            }
        }
        return result;
    }
}
