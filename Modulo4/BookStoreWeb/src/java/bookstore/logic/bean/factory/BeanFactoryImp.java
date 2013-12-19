package bookstore.logic.bean.factory;

import bookstore.logic.bean.book.IBookBean;
import bookstore.logic.bean.book.BookBean;
import bookstore.logic.bean.cart.CartBean;
import bookstore.logic.bean.cart.ICartBean;

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
