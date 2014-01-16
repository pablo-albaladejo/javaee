package bookstore.web.action;

import bookstore.logic.bean.book.IBookBean;
import bookstore.logic.bean.cart.ICartBean;
import bookstore.logic.bean.factory.BeanFactory;
import bookstore.logic.service.ServiceFactory;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public class ViewCart extends Action {

    /**
     * Process the specified HTTP request, and create the corresponding HTTP response (or forward to another web component that will create it), with provision for handling exceptions thrown by the business logic. 
     * Return an ActionForward instance describing where and how control should be forwarded, or null if the response has already been completed.
     * @param mapping The ActionMapping used to select this instance
     * @param form The optional ActionForm bean for this request (if any)
     * @param request The HTTP request we are processing
     * @param response The HTTP response we are creating 
     * @return The forward to which control should be transferred, or null if the response has been completed. 
     * @throws Exception - if the application business logic throws an exception
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        
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
            myCart.remove(book);
        }

        //view cart
        return mapping.findForward("Cart");
    }
}
