package ws.logic.facade;

import javax.jws.WebService;
import ws.dto.bean.book.BookBean;
import ws.logic.service.ServiceFactory;

/**
 * This class implements the
 * <code>{@link IBusinessFacade}</code>. It also implements the Facade Pattern
 * and provides a single view from the logic layer to the presentation layer.
 * <p>Pablo Albaladejo Mestre (pablo.albaladejo.mestre@gmail.com)</p>
 */
@WebService(endpointInterface = "ws.logic.facade.IBusinessFacade") //SIB (Service Implementation Bean)
public class BusinessFacade implements IBusinessFacade { 
    
     public BusinessFacade() {
    }

    /**
     * Adds a new Book to the DDBB
     *
     * @param Book The Book transfer to be added
     * @return  <code>true</code> if the book is propertly added;
     * <code>false</code> otherwise
     */
    @Override
    public boolean NewBook(BookBean Book) {
        return ServiceFactory.getInstance().getBookService().NewBook(Book);
    }

    /**
     * Removes a Book from the persistence identified by the ISBN
     *
     * @param ISBN The string which defines a unique Book identifier
     * @return  <code>true</code> if the Book is propertly deleted;
     * <code>flase</code> otherwise
     */
    @Override
    public boolean DeleteBook(String ISBN) {
        return ServiceFactory.getInstance().getBookService().DeleteBook(ISBN);
    }

    /**
     * Searches all the Books stored at the persistence
     *
     * @return The <code>{@link IBookBean}</code> list including all the Books;
     * <code>null</code> if no Book is found.
     */
    @Override
    public BookBean [] getAllBooks() {
        return ServiceFactory.getInstance().getBookService().getAllBooks().toArray(new BookBean[0]);
    }

    /**
     * Searches a Book from the persistence identified by the ISBN
     *
     * @param ISBN The string which defines a unique Book identifier
     * @return The <code>{@link IBookBean}</code> if it is found; <code>null</code>
     * if the Book is not found.
     */
    @Override
    public BookBean getBookByISBN(String ISBN) {
        return (BookBean)ServiceFactory.getInstance().getBookService().getBookByISBN(ISBN);
    }

    /**
     * Searches a list of existing Books at the persistence identified by the
     * Title
     *
     * @param title The Book title
     * @return The <code>{@link IBookBean}</code> list filtered by title;
     * <code>null</code> if no Book is found.
     */
    @Override
    public BookBean [] getBookByTitle(String title) {
        return ServiceFactory.getInstance().getBookService().getBookByTitle(title).toArray(new BookBean[0]);
    }

    /**
     * Modifies the price of the Book identified by the provded ISBN
     *
     * @param ISBN The string which defines a unique Book identifier
     * @param price The new price to be updated
     * @return <code>true</code> if the books is updated; <code>false</code>
     * otherwise
     */
    @Override
    public boolean ModifyBookPrice(String ISBN, double price) {
        return ServiceFactory.getInstance().getBookService().ModifyBookPrice(ISBN, price);
    }

    /**
     * Modifies the whole data stored into the DDBB
     *
     * @param Book The <code>{@link IBookBean}</code> to including the data to be
     * updated
     * @return <code>true</code> if the books is updated; <code>false</code>
     * otherwise
     */
    @Override
    public boolean ModifyBook(BookBean Book) {
        return ServiceFactory.getInstance().getBookService().ModifyBook(Book);
    }

    /**
     * Searches all the Authors stored at the persistence
     *
     * @return The <code>String</code> list including all the Authors;
     * <code>null</code> if no Author is found.
     */
    @Override
    public String [] getAllAuthors() {
        return ServiceFactory.getInstance().getBookService().getAllAuthors().toArray(new String[0]);
    }

    /**
     * Searches a list of existing Books at the persistence identified by the
     * Author
     *
     * @param name The Book author
     * @return The <code>{@link IBookBean}</code> list filtered by author;
     * <code>null</code> if no Book is found.
     */
    @Override
    public BookBean [] getBookByAuthor(String name) {
        return ServiceFactory.getInstance().getBookService().getBookByAuthor(name).toArray(new BookBean[0]);
    }

    /**
     * Searches all the Editorials stored at the persistence
     *
     * @return The <code>String</code> list including all the Editorials;
     * <code>null</code> if no Author is found.
     */
    @Override
    public String [] getAllEditorials(){
        return ServiceFactory.getInstance().getBookService().getAllEditorials().toArray(new String[0]);
    }
    
    /**
     * Searches a list of existing Books at the persistence identified by the
     * Editorial
     *
     * @param editorial The Book editorial
     * @return The <code>{@link IBookBean}</code> list filtered by editorial;
     * <code>null</code> if no Book is found.
     */
    @Override
    public BookBean [] getBookByEditorial(String editorial) {
        return ServiceFactory.getInstance().getBookService().getBookByEditorial(editorial).toArray(new BookBean[0]);
    }
    
}
