package bookstore.integration.book;

import bookstore.integration.ddbb.exception.TransactionException;
import bookstore.integration.ddbb.manager.TransactionManager;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import bookstore.logic.transfer.book.ITBook;
import bookstore.logic.transfer.factory.TransferFactory;

/**
 * Implements the Data Access Object interface defined by {@link IBookDAO} 
 * 
 * <p>Pablo Albaladejo Mestre (pablo.albaladejo.mestre@gmail.com)</p>
 */
public class BookDAO implements IBookDAO{

    private ResultSet resultSet;
    private Connection connection;
    private Statement statement;
    
    /**
     * Constructs a Book Data Access Object. 
     * A stament from the Connection with the DDBB is requested to {@link TransactionManager}
     * @throws  TransactionException if creating the stament throws an exception
     */
    public BookDAO() throws TransactionException{
        this.connection = (Connection)TransactionManager.getInstance().getConexion();
        try {
            this.statement = connection.createStatement();
        } catch (SQLException ex) {
             throw new TransactionException(ex);
        }
    }

    /**
     *  Adds a new Book to the DDBB
     *
     * @param   Book The Book transfer to be added
     * @return  <code>true</code> if the book is propertly added;
     *          <code>false</code> otherwise
     * @throws  TransactionException if a DDBB exception occurred
     */
    @Override
    public boolean NewBook(ITBook Book) throws TransactionException {
        boolean InsertActionResult = false;
        
        String query = "INSERT INTO " + TransactionManager.BOOK_ENTITY + 
                " (`TITULO`, `AUTOR`, `EDITORIAL`, `ISBN`, `PUBLICACION`, `PRECIO`, `DESCRIPCION`) VALUES ("+
                "'"+Book.getTitle()+"',"+ 
                "'"+Book.getAuthor()+"', "+
                "'"+Book.getEditorial()+"', "+
                "'"+Book.getISBN()+"', "+
                "'"+Book.getPublicationYear()+"', "+
                "'"+Book.getPrice()+"', "+
                "'"+Book.getDescription()+"'"+
                ")";
        
        try {
            int numRows = this.statement.executeUpdate(query);
            if(numRows > 0) InsertActionResult = true;
        } catch (SQLException ex) {
            throw new TransactionException(ex);
        } finally {
            return InsertActionResult;
        }   
    }

    /**
     *  Removes a Book from the DDBB identified by the ISBN
     * 
     * @param   ISBN The string which defines a unique Book identifier
     * @return  <code>true</code> if the Book is propertly deleted;
     *          <code>flase</code> otherwise
     * @throws  TransactionException if a DDBB exception occurred
     */
    @Override
    public boolean DeleteBook(String ISBN) throws TransactionException {
        boolean deleteActionResult = false;
        String query = "DELETE FROM " + TransactionManager.BOOK_ENTITY + 
                        " WHERE ISBN = '"+ISBN+"'";
        
        try {
            int numRows = this.statement.executeUpdate(query);
            if(numRows > 0) deleteActionResult = true;
        } catch (SQLException ex) {
            throw new TransactionException(ex);
        } finally {
            return deleteActionResult;
        }
    }

    /**
     *  Searches all the Books stored at the DDBB
     * @return  The <code>{@link ITBook}</code> list including all the Books;
     *          <code>null</code> if no Book is found.     
     * @throws  TransactionException if a DDBB exception occurred
     */
    @Override
    public List<ITBook> getAllBooks() throws TransactionException {
        List<ITBook> BookList = new ArrayList<ITBook>();
        String query = "SELECT * FROM "+TransactionManager.BOOK_ENTITY;
        try{
            this.resultSet = this.statement.executeQuery(query);
            while (this.resultSet.next()) {
                ITBook book = TransferFactory.getInstance().getBookTransfer();
                copyResultBookData(resultSet,book);
                BookList.add(book);
            }
        } catch (SQLException e) {
            throw new TransactionException(e);
        } finally {
            return BookList;
        }
    }

    /**
     *  Searches a Book from the DDBB identified by the ISBN
     * @param   ISBN The string which defines a unique Book identifier
     * @return  The <code>{@link ITBook}</code> if it is found;
     *          <code>null</code> if the Book is not found.
     * @throws  TransactionException if a DDBB exception occurred
     */
    @Override
    public ITBook getBookByISBN(String ISBN) throws TransactionException {
        ITBook Book = null;
        
        String query = "SELECT * FROM "+TransactionManager.BOOK_ENTITY 
                        + " WHERE ISBN = '"+ISBN+"'";
        try{
            this.resultSet = this.statement.executeQuery(query);
            if(resultSet.next()){
                Book = TransferFactory.getInstance().getBookTransfer();
                copyResultBookData(resultSet,Book);
            }else{ //Book not found
                Book = null;
            }
        }catch(SQLException e){
            throw new TransactionException(e);
        }finally{
            return Book;
        }
    }

    /**
     * Searches a list of existing Books at the DDBB identified by the Title
     * @param   title The Book title
     * @return  The <code>{@link ITBook}</code> list filtered by title;
     *          <code>null</code> if no Book is found.
     * @throws  TransactionException if a DDBB exception occurred
     */
    @Override
    public List<ITBook> getBookByTitle(String title) throws TransactionException {
        List<ITBook> BookList = new ArrayList<ITBook>();
        String query = "SELECT * FROM "+TransactionManager.BOOK_ENTITY 
                        + " WHERE TITULO LIKE '"+title+"'";
        try{
            this.resultSet = this.statement.executeQuery(query);
            while (this.resultSet.next()) {
                ITBook book = TransferFactory.getInstance().getBookTransfer();
                copyResultBookData(resultSet,book);
                BookList.add(book);
            }
        }catch(SQLException e){
            throw new TransactionException(e);
        } finally {
            return BookList;
        }        
    }

    /**
     * Modifies the price of the Book identified by the provded ISBN
     * @param ISBN The string which defines a unique Book identifier
     * @param price The new price to be updated
     * @return <code>true</code> if the books is updated;
     *         <code>false</code> otherwise
     * @throws TransactionException if a DDBB exception occurred
     */
    @Override
    public boolean ModifyBookPrice(String ISBN, double price) throws TransactionException {
        boolean updateActionResult = false;
        String query = "UPDATE " + TransactionManager.BOOK_ENTITY + 
                        " SET PRECIO = "+ price+" WHERE ISBN = '"+ISBN+"'";
        
        try {
            int numRows = this.statement.executeUpdate(query);
            if(numRows > 0) updateActionResult = true;
        } catch (SQLException ex) {
            throw new TransactionException(ex);
        }finally{
            return updateActionResult;
        }
    }
    
    private void copyResultBookData(ResultSet result, ITBook book) throws SQLException{
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
     * @param Book The <code>{@link ITBook}</code> to including the data to be updated
     * @return <code>true</code> if the books is updated;
     *         <code>false</code> otherwise 
     * @throws TransactionException if a DDBB exception occurred
     */
    @Override
    public boolean ModifyBook(ITBook Book) throws TransactionException {
        boolean updateActionResult = false;
        String query = "UPDATE " + TransactionManager.BOOK_ENTITY + 
                        " SET PRECIO = "+ Book.getPrice()+" WHERE ISBN = '"+Book.getISBN()+"'";
        try {
            int numRows = this.statement.executeUpdate(query);
            if(numRows > 0) updateActionResult = true;
        } catch (SQLException ex) {
            throw new TransactionException(ex);
        } finally {
            return updateActionResult;
        }
    }
    
}
