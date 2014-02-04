package ejb.integration.book;

import ejb.persistence.ddbb.exception.TransactionException;
import ejb.persistence.ddbb.manager.TransactionManager;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import ejb.model.book.IBookBean;
import ejb.model.factory.BeanFactory;

/**
 * Implements the Data Access Object interface defined by {@link IBookDAO}
 *
 * <p>Pablo Albaladejo Mestre (pablo.albaladejo.mestre@gmail.com)</p>
 */
public class BookDAO implements IBookDAO {

    private ResultSet resultSet;
    private Connection connection;
    private Statement statement;

    /**
     * Constructs a Book Data Access Object. A stament from the Connection with
     * the DDBB is requested to {@link TransactionManager}
     *
     * @throws TransactionException if creating the stament throws an exception
     */
    public BookDAO() throws TransactionException {
        this.connection = (Connection) TransactionManager.getInstance().getConexion();
        try {
            this.statement = connection.createStatement();
        } catch (SQLException ex) {
            throw new TransactionException(ex);
        }
    }

    /**
     * Adds a new Book to the DDBB
     *
     * @param Book The Book transfer to be added
     * @return  <code>true</code> if the book is propertly added;
     * <code>false</code> otherwise
     * @throws TransactionException if a DDBB exception occurred
     */
    @Override
    public boolean NewBook(IBookBean Book) throws TransactionException {
        boolean InsertActionResult = false;

        String query = "INSERT INTO " + TransactionManager.BOOK_ENTITY
                + " (`TITULO`, `AUTOR`, `EDITORIAL`, `ISBN`, `PUBLICACION`, `PRECIO`, `DESCRIPCION`) VALUES ("
                + "'" + Book.getTitle() + "',"
                + "'" + Book.getAuthor() + "', "
                + "'" + Book.getEditorial() + "', "
                + "'" + Book.getISBN() + "', "
                + "'" + Book.getPublicationYear() + "', "
                + "'" + Book.getPrice() + "', "
                + "'" + Book.getDescription() + "'"
                + ")";

        try {
            int numRows = this.statement.executeUpdate(query);
            if (numRows > 0) {
                InsertActionResult = true;
            }
        } catch (SQLException ex) {
            throw new TransactionException(ex);
        } finally {
            return InsertActionResult;
        }
    }

    /**
     * Removes a Book from the DDBB identified by the ISBN
     *
     * @param ISBN The string which defines a unique Book identifier
     * @return  <code>true</code> if the Book is propertly deleted;
     * <code>flase</code> otherwise
     * @throws TransactionException if a DDBB exception occurred
     */
    @Override
    public boolean DeleteBook(String ISBN) throws TransactionException {
        boolean deleteActionResult = false;
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
        }
    }

    /**
     * Searches all the Books stored at the DDBB
     *
     * @return The <code>{@link IBookBean}</code> list including all the Books;
     * <code>null</code> if no Book is found.
     * @throws TransactionException if a DDBB exception occurred
     */
    @Override
    public List<IBookBean> getAllBooks() throws TransactionException {
        List<IBookBean> BookList = new ArrayList<IBookBean>();
        String query = "SELECT * FROM " + TransactionManager.BOOK_ENTITY;
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
        }
    }

    /**
     * Searches a Book from the DDBB identified by the ISBN
     *
     * @param ISBN The string which defines a unique Book identifier
     * @return The <code>{@link IBookBean}</code> if it is found; <code>null</code>
     * if the Book is not found.
     * @throws TransactionException if a DDBB exception occurred
     */
    @Override
    public IBookBean getBookByISBN(String ISBN) throws TransactionException {
        IBookBean Book = null;

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
        }
    }

    /**
     * Searches a list of existing Books at the DDBB identified by the Title
     *
     * @param title The Book title
     * @return The <code>{@link IBookBean}</code> list filtered by title;
     * <code>null</code> if no Book is found.
     * @throws TransactionException if a DDBB exception occurred
     */
    @Override
    public List<IBookBean> getBookByTitle(String title) throws TransactionException {
        List<IBookBean> BookList = new ArrayList<IBookBean>();
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
        }
    }

    /**
     * Modifies the price of the Book identified by the provded ISBN
     *
     * @param ISBN The string which defines a unique Book identifier
     * @param price The new price to be updated
     * @return <code>true</code> if the books is updated; <code>false</code>
     * otherwise
     * @throws TransactionException if a DDBB exception occurred
     */
    @Override
    public boolean ModifyBookPrice(String ISBN, double price) throws TransactionException {
        boolean updateActionResult = false;
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
        }
    }

    private void copyResultBookData(ResultSet result, IBookBean book) throws SQLException {
        book.setID(result.getInt(1));
        book.setTitle(result.getString(2));
        book.setAuthor(result.getString(3));
        book.setEditorial(result.getString(4));
        book.setISBN(result.getString(5));
        book.setPublicationYear(result.getInt(6));
        book.setPrice(result.getDouble(7));
        book.setDescription(result.getString(8));
    }

    /**
     * Modifies the whole data stored into the DDBB
     *
     * @param Book The <code>{@link IBookBean}</code> to including the data to be
     * updated
     * @return <code>true</code> if the books is updated; <code>false</code>
     * otherwise
     * @throws TransactionException if a DDBB exception occurred
     */
    @Override
    public boolean ModifyBook(IBookBean Book) throws TransactionException {
        boolean updateActionResult = false;
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
        }
    }

    /**
     * Searches a list of existing Books at the DDBB identified by the AuthorID
     *
     * @param authorID The Author ID
     * @return The <code>{@link IBookBean}</code> list filtered by AuthorID;
     * <code>null</code> if no Book is found.
     * @throws TransactionException if a DDBB exception occurred
     */
    @Override
    public List<IBookBean> getBookByAuthorID(int authorID) throws TransactionException {
        List<IBookBean> BookList = new ArrayList<IBookBean>();
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
        }
    }

    /**
     * Searches a list of existing Books at the DDBB identified by the Author
     *
     * @param author The Book author
     * @return The <code>{@link IBookBean}</code> list filtered by author;
     * <code>null</code> if no Book is found.
     * @throws TransactionException if a DDBB exception occurred
     */
    @Override
    public List<IBookBean> getBookByAuthor(String author) throws TransactionException {
        List<IBookBean> BookList = new ArrayList<IBookBean>();
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
        }
    }

    /**
     * Searches all the Authors stored at the DDBB
     *
     * @return The <code>String</code> list including all the Authors;
     * <code>null</code> if no Authors is found.
     * @throws TransactionException if a DDBB exception occurred
     */
    @Override
    public List<String> getAllAuthors() throws TransactionException {
        List<String> list = new ArrayList<String>();
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
        }
    }

    /**
     * Searches all the Editorials stored at the DDBB
     *
     * @return The <code>String</code> list including all the Editorials;
     * <code>null</code> if no Editorial is found.
     * @throws TransactionException if a DDBB exception occurred
     */
    @Override
    public List<String> getAllEditorials() throws TransactionException {
        List<String> list = new ArrayList<String>();
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
        }
    }

    /**
     * Searches a list of existing Books at the DDBB identified by the Editorial
     *
     * @param author The Book author
     * @return The <code>{@link IBookBean}</code> list filtered by Editorial;
     * <code>null</code> if no Book is found.
     * @throws TransactionException if a DDBB exception occurred
     */
    public List<IBookBean> getBookByEditorial(String editorial) throws TransactionException {
        List<IBookBean> BookList = new ArrayList<IBookBean>();
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
        }
    }
}