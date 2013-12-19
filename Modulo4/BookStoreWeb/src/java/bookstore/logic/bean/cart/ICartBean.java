/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bookstore.logic.bean.cart;

import bookstore.logic.bean.book.IBookBean;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author palbaladejo
 */
public interface ICartBean extends Serializable{
    List<IBookBean> getList();
    void setList(List<IBookBean> list);
    boolean add(IBookBean book);
    boolean remove(IBookBean book);
    double getPrice();
    int getItemCount();
}
