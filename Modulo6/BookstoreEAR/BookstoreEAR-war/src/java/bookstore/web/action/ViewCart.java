package bookstore.web.action;

import ejb.logic.facade.IBusinessFacade;
import ejb.model.book.IBookBean;
import ejb.model.cart.ICartBean;
import ejb.model.factory.BeanFactory;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public class ViewCart extends HttpServlet {
    @EJB(beanName="Facade")
    private IBusinessFacade facade;
    
    @EJB(beanName="Cart")
    private ICartBean myCart;
    
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
               
        //Item addition into the Cart
        String addItem = request.getParameter("addItem");
        if(addItem != null){
            IBookBean book = facade.getBookByISBN(addItem);
            if(book != null) myCart.add(book);
        }
        
        //Item removal from the Cart
        String removeItem = request.getParameter("removeItem");
        if(removeItem != null){
            IBookBean book = BeanFactory.getInstance().getBookBean();
            book.setISBN(removeItem);
            if(book != null) myCart.remove(book);
        }
        
        request.setAttribute("myCartList", myCart.getList());
        request.setAttribute("myCartItemCount", myCart.getItemCount());
        request.setAttribute("myCartPrice", myCart.getPrice());
        
        //view cart
        request.getRequestDispatcher("/jsp/Cart.jsp").forward(request, response);
    }
}
