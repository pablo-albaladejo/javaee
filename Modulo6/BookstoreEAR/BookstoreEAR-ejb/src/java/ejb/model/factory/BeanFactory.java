package ejb.model.factory;

import ejb.model.book.IBookBean;

/**
 * Implements the Abstract Factory and Singeltone Pattern
 * All the Bean objects should be generated form this
 * <p>Pablo Albaladejo Mestre (pablo.albaladejo.mestre@gmail.com)</p>
 */
public abstract class BeanFactory {
    static private BeanFactory instance;
    
    /**
     * Provides a unique instance of the Factory implementation
     * @return <code>{@link BeanFactoryImp}</code>
     */
    static public BeanFactory getInstance(){
        if(instance == null) instance = new BeanFactoryImp();
        return instance;
    }
    
    /**
     * Provides an object of the Book entity Bean pattern
     * @return <code>{@link IBookBean}</code>
     */
    abstract public IBookBean getBookBean();
}
