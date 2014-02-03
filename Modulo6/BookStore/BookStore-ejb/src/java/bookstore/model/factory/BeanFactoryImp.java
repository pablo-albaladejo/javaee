package bookstore.model.factory;

import bookstore.model.book.IBookBean;
import bookstore.model.book.BookBean;
import bookstore.model.cart.CartBean;
import bookstore.model.cart.ICartBean;

/**
 * This class implements the <code>{@link BeanFactory}</code>
 * <p>Pablo Albaladejo Mestre (pablo.albaladejo.mestre@gmail.com)</p>
 */
public class BeanFactoryImp extends BeanFactory{
    
    /**
     * Return a Book object wich implements <code>{@link IBookBean}</code> 
     * @return <code>{@link IBookBean}</code>
     */
    @Override
    public IBookBean getBookBean(){
        return new BookBean();
    }
    
    /**
     * Return a Cart object wich implements <code>{@link ICartBean}</code> 
     * @return <code>{@link ICartBean}</code>
     */
    @Override
    public ICartBean getCartBean() {
        return new CartBean();
    }
}
