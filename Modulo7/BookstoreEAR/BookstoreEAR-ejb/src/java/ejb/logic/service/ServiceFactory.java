package ejb.logic.service;

import ejb.logic.book.IBookApplicationService;

/**
 * This class implements the Abstract Factory for accesing the Facade Interface
 * and to the Service Interfaces
 * <p>Pablo Albaladejo Mestre (pablo.albaladejo.mestre@gmail.com)</p>
 */
public abstract class ServiceFactory {
    static private ServiceFactory instance;
    
    /**
     * The static method to get a valid Factory instance
     * @return <code>{@link ServiceFactoryImp}</code>
     */
    static public ServiceFactory getInstance(){
        if(instance == null) instance = new ServiceFactoryImp();
        return instance;
    }
    
    /**
     * Provides the Interface to the Book Service. No to access directly, 
     * use an Bussiness Facde instance.
     * @return <code>{@link IBookApplicationService}</code>
     */
    public abstract IBookApplicationService getBookService();
}
