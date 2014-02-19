package ejb.bean.cart;

import ejb.bean.book.IBookBean;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */
@Remote
public interface ICartBean {
    List<IBookBean> getList();
    void setList(List<IBookBean> list);
    boolean add(IBookBean book);
    boolean remove(IBookBean book);
    double getPrice();
    int getItemCount();
}
