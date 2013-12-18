package bookstore.logic.service;

import bookstore.logic.book.BookApplicationService;
import bookstore.logic.book.IBookApplicationService;
import bookstore.logic.facade.BusinessFacade;
import bookstore.logic.facade.IBusinessFacade;

/**
 *
 * <p>Pablo Albaladejo Mestre (pablo.albaladejo.mestre@gmail.com)</p>
 */
public class ServiceFactoryImp extends ServiceFactory{

    /**
     * Provides a new instance of <code>{@link BusinessFacade}</code>
     * @return <code>{@link BusinessFacade}</code>
     */
    @Override
    public IBusinessFacade getBusinessFacade() {
        return new BusinessFacade();
    }

    /**
     * Provides a new instance of <code>{@link BookApplicationService}</code>
     * @return <code>{@link BookApplicationService}</code>
     */
    @Override
    public IBookApplicationService getBookService() {
        return new BookApplicationService();
    }
}
