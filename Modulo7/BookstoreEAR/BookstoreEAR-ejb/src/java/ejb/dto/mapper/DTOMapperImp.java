/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb.dto.mapper;

import ejb.dto.bean.book.IBookBean;
import ejb.dto.domain.book.IBookDO;
import ejb.dto.factory.DTOFactory;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author palbaladejo
 */
public class DTOMapperImp extends DTOMapper{

    @Override
    public IBookDO getBookDO(IBookBean bean) {
        if(bean == null) return null;
            IBookDO book = DTOFactory.getInstance().getBookDO();
            book.setAuthor(bean.getAuthor());
            book.setDescription(bean.getDescription());
            book.setEditorial(bean.getEditorial());
            //book.setID(null);
            book.setISBN(bean.getISBN());
            book.setPrice(bean.getPrice());
            book.setPublicationYear(bean.getPublicationYear());
            book.setTitle(bean.getTitle());
        return book;
    }

    @Override
    public IBookBean getBookBean(IBookDO domain) {
        if(domain == null) return null;
        IBookBean book = DTOFactory.getInstance().getBookBean();
            book.setAuthor(domain.getAuthor());
            book.setDescription(domain.getDescription());
            book.setEditorial(domain.getEditorial());
            book.setISBN(domain.getISBN());
            book.setPrice(domain.getPrice());
            book.setPublicationYear(domain.getPublicationYear());
            book.setTitle(domain.getTitle());
        return book;
    }

    @Override
    public List<IBookDO> getBookDO(List<IBookBean> bean_list) {
        if(bean_list == null) return null;
        ArrayList<IBookDO> domain_list = new ArrayList<IBookDO>();
        for(IBookBean book : bean_list){
            domain_list.add(this.getBookDO(book));
        }
        return domain_list;
    }

    @Override
    public List<IBookBean> getBookBean(List<IBookDO> domain_list) {
        if(domain_list == null) return null;
        ArrayList<IBookBean> bean_list = new ArrayList<IBookBean>();
        for(IBookDO book : domain_list){
            bean_list.add(this.getBookBean(book));
        }
        return bean_list;
    }
    
}
