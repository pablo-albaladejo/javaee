package ws.logic.book;

import java.util.ArrayList;
import ws.dto.bean.book.IBookBean;
import ws.dto.domain.book.IBookDO;
import ws.dto.mapper.DTOMapper;
import ws.integration.factory.DAOFactory;
import ws.persistence.database.manager.TransactionManager;
import ws.persistence.database.exception.TransactionException;

/**
 * This class implements the
 * <code>{@link IBookApplicationService}</code> interface
 * <p>Pablo Albaladejo Mestre (pablo.albaladejo.mestre@gmail.com)</p>
 */
public class BookApplicationService implements IBookApplicationService {
    
    /**
     * Adds a new Book to the DDBB
     *
     * @param Book The Book transfer to be added
     * @return  <code>true</code> if the book is propertly added;
     * <code>false</code> otherwise
     */
    @Override
    public boolean NewBook(IBookBean bean) {
        IBookDO domain = DTOMapper.getInstance().getBookDO(bean);
        boolean result = false;
        try {
            TransactionManager.getInstance().begin();
            result = DAOFactory.getInstance().getBookDAO().NewBook(domain);
            TransactionManager.getInstance().commit();
            TransactionManager.getInstance().close();
        } catch (TransactionException te) {
            if(this.getBookByISBN(domain.getISBN()) != null){
                //Book not added because ISBN already existis
                result = false;
            }else{
                //Error in transaction
                try { //try to rollback
                    TransactionManager.getInstance().rollback();
                    TransactionManager.getInstance().close();
                } catch (TransactionException ex) {
                    result = false;
                }
            }        
        }
        return result;
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
        boolean result = false;
        try {
            TransactionManager.getInstance().begin();
            result = DAOFactory.getInstance().getBookDAO().DeleteBook(ISBN);
            TransactionManager.getInstance().commit();
            TransactionManager.getInstance().close();
        } catch (TransactionException te) {//Book not found
            result = false;
        }
        return result;
    }

    /**
     * Searches all the Books stored at the persistence
     *
     * @return The <code>{@link IBookBean}</code> list including all the Books;
     * <code>null</code> if no Book is found.
     */
    @Override
    public ArrayList<IBookBean> getAllBooks() {
        ArrayList<IBookDO> DomainList = null;
        try {
            DomainList = DAOFactory.getInstance().getBookDAO().getAllBooks();
            TransactionManager.getInstance().close();
        } catch (TransactionException e) {// Error connecting to DDBB
            DomainList = null;
        }
        return DTOMapper.getInstance().getBookBean(DomainList);
    }

    /**
     * Searches a list of existing Books at the persistence identified by the
     * ISBN
     *
     * @param ISBN The Book title
     * @return The <code>{@link IBookBean}</code> list filtered by ISBN;
     * <code>null</code> if no Book is found.
     */
    @Override
    public IBookBean getBookByISBN(String ISBN) {
        IBookBean bean;
        try {
            IBookDO book = DAOFactory.getInstance().getBookDAO().getBookByISBN(ISBN);
            bean = DTOMapper.getInstance().getBookBean(book);
            TransactionManager.getInstance().close();
        } catch (TransactionException ex) {
            bean = null;
        }
        return bean;
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
    public ArrayList<IBookBean> getBookByTitle(String title) {
        ArrayList<IBookBean> bean_list = null;
        try {
            ArrayList<IBookDO> domain_list = DAOFactory.getInstance().getBookDAO().getBookByTitle(title);
            bean_list = DTOMapper.getInstance().getBookBean(domain_list);
            TransactionManager.getInstance().close();
        } catch (TransactionException e1) {
            bean_list = null;
        }
        return bean_list;
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
        boolean result = false;
        try {
            TransactionManager.getInstance().begin();
            result = DAOFactory.getInstance().getBookDAO().ModifyBookPrice(ISBN, price);
            TransactionManager.getInstance().commit();
            TransactionManager.getInstance().close();
        } catch (TransactionException ex) {
            result = false;//Libro no encontrado
        } 
        return result;
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
    public boolean ModifyBook(IBookBean bean) {
        IBookDO domain = DTOMapper.getInstance().getBookDO(bean);
        boolean result = false;
        if(this.getBookByISBN(domain.getISBN()) != null){
            try {
                TransactionManager.getInstance().begin();
                result = DAOFactory.getInstance().getBookDAO().ModifyBook(domain);
                TransactionManager.getInstance().commit();
            } catch (TransactionException ex) {
                ex.printStackTrace();
                result = false;
            }
            TransactionManager.getInstance().close();
        }else{
            result = false;
        }
        return result;
    }

    /**
     * Searches all the Authors stored at the persistence
     *
     * @return The <code>String</code> list including all the Authors;
     * <code>null</code> if no Author is found.
     */
    @Override
    public ArrayList<String> getAllAuthors() {
        ArrayList<String> list = null;
        try {
            list = DAOFactory.getInstance().getBookDAO().getAllAuthors();
        } catch (TransactionException e) {
            list = null;
        }
        TransactionManager.getInstance().close();
        return list;
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
    public ArrayList<IBookBean> getBookByAuthor(String name) {
        ArrayList<IBookBean> bean_list = null;
        try {
            ArrayList<IBookDO> domain_list = DAOFactory.getInstance().getBookDAO().getBookByAuthor(name);
            bean_list = DTOMapper.getInstance().getBookBean(domain_list);
            
        } catch (TransactionException e) {
            bean_list = null;
        }
        TransactionManager.getInstance().close();
        return bean_list;
    }

    /**
     * Searches all the Editorials stored at the persistence
     *
     * @return The <code>String</code> list including all the Editorials;
     * <code>null</code> if no Author is found.
     */
    @Override
    public ArrayList<String> getAllEditorials() {
        ArrayList<String> list = null;
        try {
            list = DAOFactory.getInstance().getBookDAO().getAllEditorials();
        } catch (TransactionException e) {
            list = null;
        }
        TransactionManager.getInstance().close();
        return list;
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
    public ArrayList<IBookBean> getBookByEditorial(String editorial) {
        ArrayList<IBookBean> bean_list = null;
        try {
            ArrayList<IBookDO> domain_list = DAOFactory.getInstance().getBookDAO().getBookByEditorial(editorial);
            bean_list =DTOMapper.getInstance().getBookBean(domain_list);
            
        } catch (TransactionException e) {
            bean_list = null;
        }
        TransactionManager.getInstance().close();
        return bean_list;
    }
}

