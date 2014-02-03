/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bookstore.model.cart;

import bookstore.model.book.IBookBean;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */
public interface ICartBean extends Serializable{
    List<IBookBean> getList();
    void setList(List<IBookBean> list);
    boolean add(IBookBean book);
    boolean remove(IBookBean book);
    double getPrice();
    int getItemCount();
}
