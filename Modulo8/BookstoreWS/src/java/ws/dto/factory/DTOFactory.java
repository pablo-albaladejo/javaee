package ws.dto.factory;

import ws.dto.bean.book.IBookBean;
import ws.dto.domain.book.IBookDO;

/**
 *
 * <p>Pablo Albaladejo Mestre (pablo.albaladejo.mestre@gmail.com)</p>
 */
public abstract class DTOFactory {
    private static DTOFactory instance;
    
    public static synchronized DTOFactory getInstance(){
        if(instance == null) instance = new DTOFactoryImp();
        return instance;
    }
    
    public abstract IBookBean getBookBean();
    public abstract IBookDO getBookDO();
    
}
