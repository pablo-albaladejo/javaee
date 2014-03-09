package ws.dto.bean.cart;

import ws.dto.bean.book.IBookBean;
import java.util.List;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */
public interface ICartBean {
    List<IBookBean> getList();
    void setList(List<IBookBean> list);
    boolean add(IBookBean book);
    boolean remove(IBookBean book);
    double getPrice();
    int getItemCount();
}
