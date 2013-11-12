package bookstore.logic.service;

import bookstore.logic.book.IBookApplicationService;
import bookstore.logic.facade.IBusinessFacade;

/**
 *
 * Pablo Albaladejo Mestre(pablo.albaladejo.mestre@gmail.com)
 */
public abstract class ServiceFactory {
    static private ServiceFactory instance;
    
    /**
     *
     * @return
     */
    static public ServiceFactory getInstance(){
        if(instance == null) instance = new ServiceFactoryImp();
        return instance;
    }
    
    /**
     *
     * @return
     */
    public abstract IBusinessFacade getBusinessFacade();
    
    /**
     *
     * @return
     */
    public abstract IBookApplicationService getBookService();
}
