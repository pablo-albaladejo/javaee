/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb.dto.mapper;

import ejb.dto.bean.book.IBookBean;
import ejb.dto.domain.book.IBookDO;
import java.util.List;

/**
 *
 * @author palbaladejo
 */
public abstract class DTOMapper {
    
    private static DTOMapper instance;
    
    public static synchronized DTOMapper getInstance(){
        if(instance == null) instance = new DTOMapperImp();
        return instance;
    }
    
    public abstract IBookDO getBookDO(IBookBean bean);
    public abstract List<IBookDO> getBookDO(List<IBookBean> bean_list);
    
    public abstract IBookBean getBookBean(IBookDO domain);
    public abstract List<IBookBean> getBookBean(List<IBookDO> domain_list);
    
}
