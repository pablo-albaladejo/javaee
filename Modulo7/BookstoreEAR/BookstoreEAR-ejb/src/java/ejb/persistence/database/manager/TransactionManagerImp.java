package ejb.persistence.database.manager;

import ejb.persistence.database.exception.TransactionException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * <p>Pablo Albaladejo Mestre (pablo.albaladejo.mestre@gmail.com)</p>
 */
class TransactionManagerImp extends TransactionManager{

    private HashMap<Long,EntityManager> conectionPool = new HashMap<Long,EntityManager>();
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory(PersistenceUnit);
    
    private synchronized EntityManager getEntityManager(){
        EntityManager em = null;
        if(conectionPool.containsKey(Thread.currentThread().getId())){
            em = conectionPool.get(Thread.currentThread().getId());
        }else{
            em = emf.createEntityManager();
            conectionPool.put(Thread.currentThread().getId(),em);
        }
        return em;
    }
    
    @Override
    public void commit() throws TransactionException {
        try{
            this.getEntityManager().getTransaction().commit();
        }catch(Exception e){
            throw new TransactionException(e);
        }
    }

    @Override
    public void rollback() throws TransactionException {
        try{
            this.getEntityManager().getTransaction().rollback();
        }catch(Exception e){
            throw new TransactionException(e);
        }
    }

    @Override
    public void begin() throws TransactionException {
        try{    
            this.getEntityManager().getTransaction().begin();
        }catch(Exception e){
            throw new TransactionException(e);
        }
    }

    @Override
    public void close() {
        this.conectionPool.get(Thread.currentThread().getId()).close();
        this.conectionPool.remove(Thread.currentThread().getId());
    }

    @Override
    public void persist(Object o) {
       this.conectionPool.get(Thread.currentThread().getId()).persist(o);
    }

    @Override
    public void remove(Object o) {
       this.conectionPool.get(Thread.currentThread().getId()).remove(o);
    }
    
    @Override
    public List ExecuteNamedQuery(String NamedQuery){
        return this.ExecuteNamedQuery(NamedQuery, new HashMap<String,Object>());
    }
    
    @Override
    public List ExecuteNamedQuery(String NamedQuery, Map<String, Object> parameters){
        Query query = this.getEntityManager().createNamedQuery(NamedQuery);        
        for(Entry<String,Object> entry : parameters.entrySet()){
            query.setParameter(entry.getKey(), (String)entry.getValue());            
        }
        return query.getResultList();
    }
    
    @Override
    public int ExecuteUpdateNamedQuery(String NamedQuery, Map<String, Object> parameters){
        Query query = this.getEntityManager().createNamedQuery(NamedQuery);       
        for(Entry<String,Object> entry : parameters.entrySet()){
            query.setParameter(entry.getKey(), entry.getValue());            
        }
        return query.executeUpdate();
    }
    
}
