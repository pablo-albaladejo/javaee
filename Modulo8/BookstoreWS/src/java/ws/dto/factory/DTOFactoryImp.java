package ws.dto.factory;

import ws.dto.bean.book.BookBean;
import ws.dto.bean.book.IBookBean;
import ws.dto.bean.cart.CartBean;
import ws.dto.bean.cart.ICartBean;
import ws.dto.domain.book.BookDO;
import ws.dto.domain.book.IBookDO;

/**
 *
 * <p>Pablo Albaladejo Mestre (pablo.albaladejo.mestre@gmail.com)</p>
 */
public class DTOFactoryImp extends DTOFactory{

    @Override
    public IBookBean getBookBean() {
        return new BookBean();
    }

    @Override
    public IBookDO getBookDO() {
        return new BookDO();
    }

    @Override
    public ICartBean getCartBean() {
        return new CartBean();
    }
    
}
