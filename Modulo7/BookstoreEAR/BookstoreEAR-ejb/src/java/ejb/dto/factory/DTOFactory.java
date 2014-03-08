/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb.dto.factory;

import ejb.dto.bean.book.IBookBean;
import ejb.dto.domain.book.IBookDO;

/**
 *
 * @author palbaladejo
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
