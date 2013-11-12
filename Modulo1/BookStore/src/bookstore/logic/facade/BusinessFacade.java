package bookstore.logic.facade;

import java.util.List;
import bookstore.logic.service.ServiceFactory;
import bookstore.logic.transfer.book.ITBook;

/**
 *
 * Pablo Albaladejo Mestre(pablo.albaladejo.mestre@gmail.com)
 */

public class BusinessFacade implements IBusinessFacade{

    /**
     *
     * @param Book
     * @return
     */
    @Override
    public boolean NewBook(ITBook Book) {
        return ServiceFactory.getInstance().getBookService().NewBook(Book);
    }

    /**
     *
     * @param ISBN
     * @return
     */
    @Override
    public boolean DeleteBook(String ISBN) {
        return ServiceFactory.getInstance().getBookService().DeleteBook(ISBN);
    }

    /**
     *
     * @return
     */
    @Override
    public List<ITBook> getAllBooks() {
        return ServiceFactory.getInstance().getBookService().getAllBooks();
    }

    /**
     *
     * @param ISBN
     * @return
     */
    @Override
    public ITBook getBookByISBN(String ISBN) {
        return ServiceFactory.getInstance().getBookService().getBookByISBN(ISBN);
    }

    /**
     *
     * @param title
     * @return
     */
    @Override
    public List<ITBook> getBookByTitle(String title) {
        return ServiceFactory.getInstance().getBookService().getBookByTitle(title);
    }

    /**
     *
     * @param ISBN
     * @param price
     * @return
     */
    @Override
    public boolean ModifyBookPrice(String ISBN, double price) {
        return ServiceFactory.getInstance().getBookService().ModifyBookPrice(ISBN, price);
    }

    /**
     *
     * @param Book
     * @return
     */
    @Override
    public boolean ModifyBook(ITBook Book) {
        return ServiceFactory.getInstance().getBookService().ModifyBook(Book);
    }
        
}
