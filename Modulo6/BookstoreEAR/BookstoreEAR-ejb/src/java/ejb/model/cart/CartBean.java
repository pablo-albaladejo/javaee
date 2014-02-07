package ejb.model.cart;

import ejb.model.book.IBookBean;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateful;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */
@Stateful(name="Cart")
public class CartBean implements ICartBean{
    List<IBookBean> list;
    public CartBean() {
        list = new ArrayList<IBookBean>();
    }

    public CartBean(List<IBookBean> list) {
        this.list = list;
    }

    @Override
    public List<IBookBean> getList() {
        return list;
    }

    @Override
    public void setList(List<IBookBean> list) {
        this.list = list;
    }
    
    @Override
    public boolean add(IBookBean book){
        return this.list.add(book);
    }
    
    @Override
    public boolean remove(IBookBean book){
        return this.list.remove(book);
    }
    
    @Override
    public double getPrice(){
        double price = 0.0;
        for(IBookBean book : this.list){
            price += book.getPrice();
        }
        return price;
    }
    
    @Override
    public int getItemCount(){
        return this.list.size();
    }

    @Override
    public String toString() {
        return "CartBean{" + "list=" + list + '}';
    }
}
