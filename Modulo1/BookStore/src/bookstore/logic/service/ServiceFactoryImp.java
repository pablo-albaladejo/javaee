package bookstore.logic.service;

import bookstore.logic.book.BookApplicationService;
import bookstore.logic.book.IBookApplicationService;
import bookstore.logic.facade.BusinessFacade;
import bookstore.logic.facade.IBusinessFacade;

/**
 *
 * Pablo Albaladejo Mestre(pablo.albaladejo.mestre@gmail.com)
 */
public class ServiceFactoryImp extends ServiceFactory{

    /**
     *
     * @return
     */
    @Override
    public IBusinessFacade getBusinessFacade() {
        return new BusinessFacade();
    }

    /**
     *
     * @return
     */
    @Override
    public IBookApplicationService getBookService() {
        return new BookApplicationService();
    }
    
}
