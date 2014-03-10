package bookstore.web.action;

import bookstore.web.ws.WSManager;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ws.dto.bean.book.IBookBean;
import ws.dto.bean.cart.ICartBean;
import ws.dto.factory.DTOFactory;

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
        ICartBean myCart;
        
        if(request.getSession().getAttribute("myCart")==null){
            myCart = DTOFactory.getInstance().getCartBean();
            request.getSession().setAttribute("myCart", myCart);
        }
        
        myCart = (ICartBean)request.getSession().getAttribute("myCart");
        
        //Item addition into the Cart
        String addItem = request.getParameter("addItem");
        if(addItem != null){
            IBookBean book = WSManager.getInstance().getPort().getBookByISBN(addItem);
            if(book != null) myCart.add(book);
        }
        
        //Item removal from the Cart
        String removeItem = request.getParameter("removeItem");
        if(removeItem != null){
            IBookBean book = DTOFactory.getInstance().getBookBean();
            book.setISBN(removeItem);
            if(book != null) myCart.remove(book);
        }
                
        //view cart
        request.getRequestDispatcher("/jsp/Cart.jsp").forward(request, response);
    }
}
