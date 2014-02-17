package ejb.integration.factory;

import ejb.integration.book.IBookDAO;

/**
 * This class implements the Abstract Factory for DAO objects
 * <p>Pablo Albaladejo Mestre (pablo.albaladejo.mestre@gmail.com)</p>
 */
public abstract class DAOFactory {
    static private DAOFactory instance;
    
    /**
     * The static method to get a valid Factory instance
     * @return A <code>{@link DAOFactoryImp}</code> instance
     */
    static public DAOFactory getInstance(){
        if(instance == null) instance = new DAOFactoryImp();
        return instance;
    }
    
    /**
     * Provides a DAO from the Book Entity 
     * @return A {@link IBookDAO} object
     */
    public abstract IBookDAO getBookDAO();
}
