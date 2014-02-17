package ejb.persistence.manager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * <p>Pablo Albaladejo Mestre (pablo.albaladejo.mestre@gmail.com)</p>
 */

public class PersistenceManagerImp extends PersistenceManager{

    private EntityManager em = null;
    
    PersistenceManagerImp(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT); 
        em = emf.createEntityManager();
    } 
    
    @Override
    public EntityManager getEntityManager() {
        return em;
    }
    
}
