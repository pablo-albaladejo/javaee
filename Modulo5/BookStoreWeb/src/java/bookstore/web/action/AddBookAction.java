package bookstore.web.action;

import bookstore.web.action.exceptions.AlreadyExistsException;
import bookstore.logic.bean.book.IBookBean;
import bookstore.logic.bean.factory.BeanFactory;
import bookstore.logic.service.ServiceFactory;
import bookstore.web.actionform.BookValidatorForm;
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
public class AddBookAction extends Action {
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
        String view = "AddBook";
        String action = request.getParameter("action");
        
        if(action != null){
            switch(action){
                case "ADD_BOOK":
                    view = addBook(request,response, (BookValidatorForm)form);
                    break;
                default:
                    view = "AddBook";
                    break;
            }
        }
        return mapping.findForward(view);
    }
    
    private String addBook(HttpServletRequest request, HttpServletResponse response,BookValidatorForm form) throws Exception{
        String view;
                     
        IBookBean book = BeanFactory.getInstance().getBookBean();
        book.setTitle(form.getTitle());
        book.setAuthor(form.getAuthor());
        book.setEditorial(form.getEditorial());
        book.setISBN(form.getISBN());
        book.setPublicationYear(form.getPublicationYear());
        book.setPrice(form.getPrice());
        book.setDescription(form.getDescription());

        boolean result = ServiceFactory.getInstance().getBusinessFacade().NewBook(book);        
        if(result){
            request.setAttribute("list", ServiceFactory.getInstance().getBusinessFacade().getAllBooks());
            view = "ModifyBookList";
        }else{
            throw new AlreadyExistsException();
            //throw new Exception();
        }
        
        return view;
    }
}
