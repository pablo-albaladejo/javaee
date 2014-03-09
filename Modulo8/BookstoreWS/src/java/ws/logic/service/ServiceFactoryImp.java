package ws.logic.service;

import ws.logic.book.BookApplicationService;
import ws.logic.book.IBookApplicationService;

/**
 *
 * <p>Pablo Albaladejo Mestre (pablo.albaladejo.mestre@gmail.com)</p>
 */
public class ServiceFactoryImp extends ServiceFactory{

    /**
     * Provides a new instance of <code>{@link BookApplicationService}</code>
     * @return <code>{@link BookApplicationService}</code>
     */
    @Override
    public IBookApplicationService getBookService() {
        return new BookApplicationService();
    }
}
