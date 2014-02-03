package bookstore.web.action;

import bookstore.model.book.IBookBean;
import bookstore.model.cart.ICartBean;
import bookstore.model.factory.BeanFactory;
import bookstore.logic.service.ServiceFactory;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public class ViewCart extends HttpServlet {
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
        
        ICartBean myCart = (ICartBean)request.getSession().getAttribute("myCart");
        
        //if the cart object does not exits at session, it is created.
        if(myCart == null){
            myCart = BeanFactory.getInstance().getCartBean();
            request.getSession().setAttribute("myCart", myCart);
        }
        
        //Item addition into the Cart
        String addItem = request.getParameter("addItem");
        if(addItem != null){
            IBookBean book = ServiceFactory.getInstance().getBusinessFacade().getBookByISBN(addItem);
            if(book != null) myCart.add(book);
        }
        
        //Item removal from the Cart
        String removeItem = request.getParameter("removeItem");
        if(removeItem != null){
            IBookBean book = BeanFactory.getInstance().getBookBean();
            book.setISBN(removeItem);
            if(book != null) myCart.remove(book);
        }

        //view cart
        request.getRequestDispatcher("/jsp/Cart.jsp").forward(request, response);
    }
}
