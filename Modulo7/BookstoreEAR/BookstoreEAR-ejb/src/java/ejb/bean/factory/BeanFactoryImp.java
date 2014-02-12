package ejb.bean.factory;

import ejb.bean.book.IBookBean;
import ejb.bean.book.BookBean;
import ejb.bean.cart.CartBean;
import ejb.bean.cart.ICartBean;

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
}
