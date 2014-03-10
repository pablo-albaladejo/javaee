package bookstore.web.ws;

import ws.logic.facade.IBusinessFacade;

/**
 *
 * @author palbaladejo
 */
public abstract class WSManager {
    private static WSManager instance;
    
    public static synchronized WSManager getInstance(){
        if(instance == null) instance = new WSManagerImp();
        return instance;
    }
    
    public abstract IBusinessFacade getPort();
    
}
