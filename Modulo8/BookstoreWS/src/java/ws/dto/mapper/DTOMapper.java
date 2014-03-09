package ws.dto.mapper;

import java.util.ArrayList;
import ws.dto.bean.book.IBookBean;
import ws.dto.domain.book.IBookDO;

/**
 *
 * <p>Pablo Albaladejo Mestre (pablo.albaladejo.mestre@gmail.com)</p>
 */
public abstract class DTOMapper {
    
    private static DTOMapper instance;
    
    public static synchronized DTOMapper getInstance(){
        if(instance == null) instance = new DTOMapperImp();
        return instance;
    }
    
    public abstract IBookDO getBookDO(IBookBean bean);
    public abstract ArrayList<IBookDO> getBookDO(ArrayList<IBookBean> bean_list);
    
    public abstract IBookBean getBookBean(IBookDO domain);
    public abstract ArrayList<IBookBean> getBookBean(ArrayList<IBookDO> domain_list);
    
}
