package bookstore.logic.facade;

import java.util.List;
import bookstore.logic.service.ServiceFactory;
import bookstore.logic.transfer.book.ITBook;

/**
 * This class implements the <code>{@link IBusinessFacade}</code>. 
 * It also implements the Facade Pattern and provides a single view from the
 * logic layer to the presentation layer.
 * <p>Pablo Albaladejo Mestre (pablo.albaladejo.mestre@gmail.com)</p>
 */

public class BusinessFacade implements IBusinessFacade{

    /**
     *  Adds a new Book to the DDBB
     *
     * @param   Book The Book transfer to be added
     * @return  <code>true</code> if the book is propertly added;
     *          <code>false</code> otherwise
     */
    @Override
    public boolean NewBook(ITBook Book) {
        return ServiceFactory.getInstance().getBookService().NewBook(Book);
    }

    /**
     *  Removes a Book from the persistence identified by the ISBN
     * 
     * @param   ISBN The string which defines a unique Book identifier
     * @return  <code>true</code> if the Book is propertly deleted;
     *          <code>flase</code> otherwise
     */
    @Override
    public boolean DeleteBook(String ISBN) {
        return ServiceFactory.getInstance().getBookService().DeleteBook(ISBN);
    }

    /**
     *  Searches all the Books stored at the persistence
     * @return  The <code>{@link ITBook}</code> list including all the Books;
     *          <code>null</code> if no Book is found.     
     */
    @Override
    public List<ITBook> getAllBooks() {
        return ServiceFactory.getInstance().getBookService().getAllBooks();
    }

    /**
     *  Searches a Book from the persistence identified by the ISBN
     * @param   ISBN The string which defines a unique Book identifier
     * @return  The <code>{@link ITBook}</code> if it is found;
     *          <code>null</code> if the Book is not found.
     */
    @Override
    public ITBook getBookByISBN(String ISBN) {
        return ServiceFactory.getInstance().getBookService().getBookByISBN(ISBN);
    }

    /**
     * Searches a list of existing Books at the persistence identified by the Title
     * @param   title The Book title
     * @return  The <code>{@link ITBook}</code> list filtered by title;
     *          <code>null</code> if no Book is found.
     */
    @Override
    public List<ITBook> getBookByTitle(String title) {
        return ServiceFactory.getInstance().getBookService().getBookByTitle(title);
    }

    /**
     * Modifies the price of the Book identified by the provded ISBN
     * @param ISBN The string which defines a unique Book identifier
     * @param price The new price to be updated
     * @return <code>true</code> if the books is updated;
     *         <code>false</code> otherwise
     */
    @Override
    public boolean ModifyBookPrice(String ISBN, double price) {
        return ServiceFactory.getInstance().getBookService().ModifyBookPrice(ISBN, price);
    }

    /**
     * Modifies the whole data stored into the DDBB
     * @param Book The <code>{@link ITBook}</code> to including the data to be updated
     * @return <code>true</code> if the books is updated;
     *         <code>false</code> otherwise 
     */
    @Override
    public boolean ModifyBook(ITBook Book) {
        return ServiceFactory.getInstance().getBookService().ModifyBook(Book);
    }
        
}
