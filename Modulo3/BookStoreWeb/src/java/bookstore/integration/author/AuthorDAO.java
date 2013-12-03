package bookstore.integration.author;

import bookstore.integration.ddbb.exception.TransactionException;
import bookstore.integration.ddbb.manager.TransactionManager;
import bookstore.logic.transfer.author.ITAuthor;
import bookstore.logic.transfer.factory.TransferFactory;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * <p>Pablo Albaladejo Mestre (pablo.albaladejo.mestre@gmail.com)</p>
 */
public class AuthorDAO implements IAuthorDAO {

    private ResultSet resultSet;
    private Connection connection;
    private Statement statement;

    /**
     * Constructs a Book Data Access Object. A stament from the Connection with
     * the DDBB is requested to {@link TransactionManager}
     *
     * @throws TransactionException if creating the stament throws an exception
     */
    public AuthorDAO() throws TransactionException {
        this.connection = (Connection) TransactionManager.getInstance().getConexion();
        try {
            this.statement = connection.createStatement();
        } catch (SQLException ex) {
            throw new TransactionException(ex);
        }
    }

    /**
     * Searches all the Authors stored at the DDBB
     *
     * @return The <code>{@link ITAuthor}</code> list including all the Authors;
     * <code>null</code> if no Aithor is found.
     * @throws TransactionException if a DDBB exception occurred
     */
    @Override
    public List<ITAuthor> getAllAuthors() throws TransactionException {
        List<ITAuthor> AuthorList = new ArrayList<ITAuthor>();
        String query = "SELECT * FROM " + TransactionManager.AUTHOR_ENTITY;
        try {
            this.resultSet = this.statement.executeQuery(query);
            while (this.resultSet.next()) {
                ITAuthor author = TransferFactory.getInstance().getAuthorTransfer();
                copyResultAuthorData(resultSet, author);
                AuthorList.add(author);
            }
        } catch (SQLException e) {
            throw new TransactionException(e);
        } finally {
            return AuthorList;
        }
    }

    /**
     * Searches all the Authors stored filtered by Name
     * @return  The <code>{@link ITAuthor}</code> list
     *          <code>null</code> if no Author is found.     
     */
    @Override
    public List<ITAuthor> getAuthorByName(String name) throws TransactionException{
        List<ITAuthor> AuthorList = new ArrayList<ITAuthor>();
        String query = "SELECT * FROM " + TransactionManager.AUTHOR_ENTITY 
                + " WHERE NAME LIKE '%" + name + "%'";
        try {
            this.resultSet = this.statement.executeQuery(query);
            while (this.resultSet.next()) {
                ITAuthor author = TransferFactory.getInstance().getAuthorTransfer();
                copyResultAuthorData(resultSet, author);
                AuthorList.add(author);
            }
        } catch (SQLException e) {
            throw new TransactionException(e);
        } finally {
            return AuthorList;
        }
    }
    private void copyResultAuthorData(ResultSet result, ITAuthor author) throws SQLException {
        author.setID(result.getInt(1));
        author.setName(result.getString(2));
    }
}