package bookstore.web.action;

import bookstore.logic.bean.book.IBookBean;
import bookstore.logic.bean.factory.BeanFactory;
import bookstore.logic.service.ServiceFactory;
import java.util.List;
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
public class ModifyBookListAction extends Action {

    /**
     * Process the specified HTTP request, and create the corresponding HTTP response (or forward to another web component that will create it), with provision for handling exceptions thrown by the business logic. 
     * Return an ActionForward instance describing where and how control should be forwarded, or null if the response has already been completed.
     * @param mapping The ActionMapping used to select this instance
     * @param form The optional ActionForm bean for this request (if any)
     * @param request The HTTP request we are processing
     * @param response The HTTP response we are creating 
     * @return The forward to which control should be transferred, or null if the response has been completed. 
     * @throws Exception if the application business logic throws an exception
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String view = "ModifyBookList";
        String action = request.getParameter("action");
        if(action != null){
            switch(action){
                case "DELETE_BOOK":
                    view = deleteBook(request,response);
                    break;
                case "EDIT_BOOK":
                    view = editBook(request,response);
                    break;
                default:
                    view = list(request,response);
                    break;
            }
        }else{
            view = list(request,response);
        }
        
        return mapping.findForward(view);
    }
    
    private String deleteBook(HttpServletRequest request, HttpServletResponse response){
        String ISBN = request.getParameter("ISBN");
        ServiceFactory.getInstance().getBusinessFacade().DeleteBook(ISBN);
        List<IBookBean> list = ServiceFactory.getInstance().getBusinessFacade().getAllBooks();
        request.setAttribute("list", list);
        return "DeleteBook";
    }
    
    private String editBook(HttpServletRequest request, HttpServletResponse response){
        IBookBean book = ServiceFactory.getInstance().getBusinessFacade().getBookByISBN(request.getParameter("ISBN"));
                 
        request.setAttribute("book", book);
        return "EditBook";
    }
    
    private String list(HttpServletRequest request, HttpServletResponse response){
        List<IBookBean> list = ServiceFactory.getInstance().getBusinessFacade().getAllBooks();
        request.setAttribute("list", list);
        return "DeleteBook";
    }
}
