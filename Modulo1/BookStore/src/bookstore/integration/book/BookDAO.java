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
 * 
 * Pablo Albaladejo Mestre(pablo.albaladejo.mestre@gmail.com)
 */
public class BookDAO implements IBookDAO{

    private ResultSet resultSet;
    private Connection connection;
    private Statement statement;
    
    /**
     *
     * @throws TransactionException
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
     *
     * @param Book
     * @return a
     * @throws TransactionException
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
     *
     * @param ISBN
     * @return
     * @throws TransactionException
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
     *
     * @return
     * @throws TransactionException
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
     *
     * @param ISBN
     * @return
     * @throws TransactionException
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
     *
     * @param title
     * @return
     * @throws TransactionException
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
     *
     * @param ISBN
     * @param price
     * @return
     * @throws TransactionException
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
     *
     * @param Book
     * @return
     * @throws TransactionException
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
