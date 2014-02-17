package ejb.persistence.manager;

import javax.persistence.EntityManager;

/**
 *
 * <p>Pablo Albaladejo Mestre (pablo.albaladejo.mestre@gmail.com)</p>
 */
public abstract class PersistenceManager {
    
    static String PERSISTENCE_UNIT = "BookstorePU";
    
    private static PersistenceManager instance;
        
    public static synchronized PersistenceManager getInstance(){
        if(instance ==  null) instance = new PersistenceManagerImp();
        return instance;
    }
    
    /**
     * Provides an object of the EntityManager
     * @return <code>{@link EntityManager}</code>
     */
    abstract public EntityManager getEntityManager();
}
