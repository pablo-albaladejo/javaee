package ejb.integration.book;

import ejb.bean.book.BookBean;
import java.util.List;
import ejb.bean.book.IBookBean;
import ejb.persistence.exception.TransactionException;
import ejb.persistence.manager.PersistenceManager;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * Implements the Data Access Object interface defined by {@link IBookDAO}
 *
 * <p>Pablo Albaladejo Mestre (pablo.albaladejo.mestre@gmail.com)</p>
 */
public class BookDAO implements IBookDAO {

    /**
     * Constructs a Book Data Access Object. A stament from the Connection with
     * the DDBB is requested to {@link TransactionManager}
     *
     */
    public BookDAO(){
    }

    /**
     * Adds a new Book to the DDBB
     *
     * @param Book The Book transfer to be added
     * <code>false</code> otherwise
     * @throws TransactionException if a DDBB exception occurred
     */
    @Override
    public void NewBook(IBookBean Book) throws TransactionException {
//        try{
//            PersistenceManager.getInstance().getEntityManager().persist(Book);
//        } catch (Exception e){
//            System.out.println("ERROR EN EL DAO "+e);
//            throw new TransactionException(e.getLocalizedMessage());
//        }
                    BookBean Book1 = new BookBean();
            Book1.setID(100);
            Book1.setTitle("Titulo");
            Book1.setAuthor("Autor 1");
            Book1.setEditorial("Editorial 1");
            Book1.setISBN("ISNB 100");
            Book1.setPrice(1.0);
            Book1.setPublicationYear(1);
            Book1.setDescription("Descripcion 1");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BookstorePU");
        EntityManager em  = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(Book1);
        et.commit();
        
    }

    /**
     * Removes a Book from the DDBB identified by the ISBN
     *
     * @param ISBN The string which defines a unique Book identifier
     * @return  <code>true</code> if the Book is propertly deleted;
     * <code>flase</code> otherwise
     */
    @Override
    public boolean DeleteBook(String ISBN) {
        return false;
        /*boolean deleteActionResult = false;
        String query = "DELETE FROM " + TransactionManager.BOOK_ENTITY
                + " WHERE ISBN = '" + ISBN + "'";

        try {
            int numRows = this.statement.executeUpdate(query);
            if (numRows > 0) {
                deleteActionResult = true;
            }
        } catch (SQLException ex) {
            throw new TransactionException(ex);
        } finally {
            return deleteActionResult;
        }*/
    }

    /**
     * Searches all the Books stored at the DDBB
     *
     * @return The <code>{@link IBookBean}</code> list including all the Books;
     * <code>null</code> if no Book is found.
     */
    @Override
    public List<IBookBean> getAllBooks() {
        Query q = PersistenceManager.getInstance().getEntityManager().createNamedQuery("BookBean.findAll");
        return q.getResultList();
    }

    /**
     * Searches a Book from the DDBB identified by the ISBN
     *
     * @param ISBN The string which defines a unique Book identifier
     * @return The <code>{@link IBookBean}</code> if it is found; <code>null</code>
     * if the Book is not found.
     */
    @Override
    public IBookBean getBookByISBN(String ISBN) {
        return null;
        /*IBookBean Book = null;

        String query = "SELECT * FROM " + TransactionManager.BOOK_ENTITY
                + " WHERE ISBN = '" + ISBN + "'";
        try {
            this.resultSet = this.statement.executeQuery(query);
            if (resultSet.next()) {
                Book = BeanFactory.getInstance().getBookBean();
                copyResultBookData(resultSet, Book);
            } else { //Book not found
                Book = null;
            }
        } catch (SQLException e) {
            throw new TransactionException(e);
        } finally {
            return Book;
        }*/
    }

    /**
     * Searches a list of existing Books at the DDBB identified by the Title
     *
     * @param title The Book title
     * @return The <code>{@link IBookBean}</code> list filtered by title;
     * <code>null</code> if no Book is found.
     */
    @Override
    public List<IBookBean> getBookByTitle(String title) {
        return null;
        /*List<IBookBean> BookList = new ArrayList<IBookBean>();
        String query = "SELECT * FROM " + TransactionManager.BOOK_ENTITY
                + " WHERE TITULO LIKE '%" + title + "%'";
        try {
            this.resultSet = this.statement.executeQuery(query);
            while (this.resultSet.next()) {
                IBookBean book = BeanFactory.getInstance().getBookBean();
                copyResultBookData(resultSet, book);
                BookList.add(book);
            }
        } catch (SQLException e) {
            throw new TransactionException(e);
        } finally {
            return BookList;
        }*/
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
        return false;
        /*boolean updateActionResult = false;
        String query = "UPDATE " + TransactionManager.BOOK_ENTITY
                + " SET PRECIO = " + price + " WHERE ISBN = '" + ISBN + "'";

        try {
            int numRows = this.statement.executeUpdate(query);
            if (numRows > 0) {
                updateActionResult = true;
            }
        } catch (SQLException ex) {
            throw new TransactionException(ex);
        } finally {
            return updateActionResult;
        }*/
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
    public boolean ModifyBook(IBookBean Book) {
        return false;
        /*boolean updateActionResult = false;
        String query = "UPDATE " + TransactionManager.BOOK_ENTITY + " SET "
                + "AUTOR = '" + Book.getAuthor() + "', "
                + "TITULO = '" + Book.getTitle() + "', "
                + "EDITORIAL = '" + Book.getEditorial() + "', "
                + "PUBLICACION = '" + Book.getPublicationYear() + "', "
                + "PRECIO = '" + Book.getPrice() + "', "
                + "DESCRIPCION = '" + Book.getDescription() + "' "
                + "WHERE ISBN = '" + Book.getISBN() + "'";
        try {
            int numRows = this.statement.executeUpdate(query);
            if (numRows > 0) {
                updateActionResult = true;
            }
        } catch (SQLException ex) {
            throw new TransactionException(ex);
        } finally {
            return updateActionResult;
        }*/
    }

    /**
     * Searches a list of existing Books at the DDBB identified by the AuthorID
     *
     * @param authorID The Author ID
     * @return The <code>{@link IBookBean}</code> list filtered by AuthorID;
     * <code>null</code> if no Book is found.
     */
    @Override
    public List<IBookBean> getBookByAuthorID(int authorID) {
        return null;
        /*List<IBookBean> BookList = new ArrayList<IBookBean>();
        String query = "SELECT * FROM " + TransactionManager.BOOK_ENTITY
                + " WHERE AUTOR = '" + authorID + "'";
        try {
            this.resultSet = this.statement.executeQuery(query);
            while (this.resultSet.next()) {
                IBookBean book = BeanFactory.getInstance().getBookBean();
                copyResultBookData(resultSet, book);
                BookList.add(book);
            }
        } catch (SQLException e) {
            throw new TransactionException(e);
        } finally {
            return BookList;
        }*/
    }

    /**
     * Searches a list of existing Books at the DDBB identified by the Author
     *
     * @param author The Book author
     * @return The <code>{@link IBookBean}</code> list filtered by author;
     * <code>null</code> if no Book is found.
     */
    @Override
    public List<IBookBean> getBookByAuthor(String author) {
        return null;
        /*List<IBookBean> BookList = new ArrayList<IBookBean>();
        String query = "SELECT * FROM " + TransactionManager.BOOK_ENTITY
                + " WHERE AUTOR LIKE '" + author + "'";
        try {
            this.resultSet = this.statement.executeQuery(query);
            while (this.resultSet.next()) {
                IBookBean book = BeanFactory.getInstance().getBookBean();
                copyResultBookData(resultSet, book);
                BookList.add(book);
            }
        } catch (SQLException e) {
            throw new TransactionException(e);
        } finally {
            return BookList;
        }*/
    }

    /**
     * Searches all the Authors stored at the DDBB
     *
     * @return The <code>String</code> list including all the Authors;
     * <code>null</code> if no Authors is found.
     */
    @Override
    public List<String> getAllAuthors(){
        return null;
        /*List<String> list = new ArrayList<String>();
        String query = "SELECT DISTINCT AUTOR FROM " + TransactionManager.BOOK_ENTITY;

        try {
            this.resultSet = this.statement.executeQuery(query);
            while (this.resultSet.next()) {
                list.add(resultSet.getString(1));
            }
        } catch (SQLException e) {
            throw new TransactionException(e);
        } finally {
            return list;
        }*/
    }

    /**
     * Searches all the Editorials stored at the DDBB
     *
     * @return The <code>String</code> list including all the Editorials;
     * <code>null</code> if no Editorial is found.
     */
    @Override
    public List<String> getAllEditorials() {
        return null;
        /*List<String> list = new ArrayList<String>();
        String query = "SELECT DISTINCT EDITORIAL FROM " + TransactionManager.BOOK_ENTITY;

        try {
            this.resultSet = this.statement.executeQuery(query);
            while (this.resultSet.next()) {
                list.add(resultSet.getString(1));
            }
        } catch (SQLException e) {
            throw new TransactionException(e);
        } finally {
            return list;
        }*/
    }

    /**
     * Searches a list of existing Books at the DDBB identified by the Editorial
     *
     * @param author The Book author
     * @return The <code>{@link IBookBean}</code> list filtered by Editorial;
     * <code>null</code> if no Book is found.
     */
    public List<IBookBean> getBookByEditorial(String editorial){
        return null;
        /*List<IBookBean> BookList = new ArrayList<IBookBean>();
        String query = "SELECT * FROM " + TransactionManager.BOOK_ENTITY
                + " WHERE EDITORIAL LIKE '" + editorial + "'";
        try {
            this.resultSet = this.statement.executeQuery(query);
            while (this.resultSet.next()) {
                IBookBean book = BeanFactory.getInstance().getBookBean();
                copyResultBookData(resultSet, book);
                BookList.add(book);
            }
        } catch (SQLException e) {
            throw new TransactionException(e);
        } finally {
            return BookList;
        }*/
    }
}
