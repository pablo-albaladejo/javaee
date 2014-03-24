package tripbooker.integration.route;

import java.util.List;
import tripbooker.dto.domain.route.IRouteDO;
import tripbooker.persistence.database.exception.TransactionException;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public class RouteDAOImp implements IRouteDAO{

    @Override
    public List<IRouteDO> getAllRoutes() throws TransactionException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IRouteDO getRouteByID(int id) throws TransactionException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeRoute(int id) throws TransactionException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insertRoute(IRouteDO route) throws TransactionException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
