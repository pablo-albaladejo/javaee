package bookstore.logic.bean.factory;

import bookstore.logic.bean.book.IBeanBook;
import bookstore.logic.bean.book.BeanBook;

/**
 * This class implements the <code>{@link BeanFactory}</code>
 * <p>Pablo Albaladejo Mestre (pablo.albaladejo.mestre@gmail.com)</p>
 */
public class BeanFactoryImp extends BeanFactory{
    
    /**
     * Return a Book object wich implements <code>{@link IBeanBook}</code> 
     * @return <code>{@link IBeanBook}</code>
     */
    @Override
    public IBeanBook getBookBean(){
        return new BeanBook();
    }
}
