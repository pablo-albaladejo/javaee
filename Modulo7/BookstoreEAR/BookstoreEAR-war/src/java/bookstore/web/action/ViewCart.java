package bookstore.web.action;

import ejb.logic.facade.IBusinessFacade;
import ejb.bean.book.IBookBean;
import ejb.bean.cart.ICartBean;
import ejb.bean.factory.BeanFactory;
import java.io.IOException;
import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
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
            try {
                Context ctx = new InitialContext();
                myCart = (ICartBean)ctx.lookup("java:global/BookstoreEAR/BookstoreEAR-ejb/Cart");
                request.getSession().setAttribute("myCart", myCart);
            } catch (NamingException ex) {
                ex.printStackTrace();
            }
        }
        
        myCart = (ICartBean)request.getSession().getAttribute("myCart");
        
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
                
        //view cart
        request.getRequestDispatcher("/jsp/Cart.jsp").forward(request, response);
    }
}
