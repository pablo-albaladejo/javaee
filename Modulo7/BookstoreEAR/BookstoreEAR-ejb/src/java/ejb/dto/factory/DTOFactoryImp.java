/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb.dto.factory;

import ejb.dto.bean.book.BookBean;
import ejb.dto.bean.book.IBookBean;
import ejb.dto.domain.book.BookDO;
import ejb.dto.domain.book.IBookDO;

/**
 *
 * @author palbaladejo
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
    
}
