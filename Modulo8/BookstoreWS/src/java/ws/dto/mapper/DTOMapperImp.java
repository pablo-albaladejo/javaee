package ws.dto.mapper;

import ws.dto.bean.book.IBookBean;
import ws.dto.domain.book.IBookDO;
import ws.dto.factory.DTOFactory;
import java.util.ArrayList;

/**
 *
 * <p>Pablo Albaladejo Mestre (pablo.albaladejo.mestre@gmail.com)</p>
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
    public ArrayList<IBookDO> getBookDO(ArrayList<IBookBean> bean_list) {
        if(bean_list == null) return null;
        ArrayList<IBookDO> domain_list = new ArrayList<IBookDO>();
        for(IBookBean book : bean_list){
            domain_list.add(this.getBookDO(book));
        }
        return domain_list;
    }

    @Override
    public ArrayList<IBookBean> getBookBean(ArrayList<IBookDO> domain_list) {
        if(domain_list == null) return null;
        ArrayList<IBookBean> bean_list = new ArrayList<IBookBean>();
        for(IBookDO book : domain_list){
            bean_list.add(this.getBookBean(book));
        }
        return bean_list;
    }
    
}
