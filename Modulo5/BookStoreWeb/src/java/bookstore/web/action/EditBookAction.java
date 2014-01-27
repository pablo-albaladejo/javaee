/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bookstore.web.action;

import bookstore.logic.bean.book.IBookBean;
import bookstore.logic.bean.factory.BeanFactory;
import bookstore.logic.service.ServiceFactory;
import bookstore.web.actionform.BookValidatorForm;
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
public class EditBookAction extends Action{
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
        String view = "EditBook";
        String action = request.getParameter("action");
        
        if(action != null){
            switch(action){
                case "EDIT_BOOK":
                    view = EditBook(request,response, (BookValidatorForm)form);
                    break;
                default:
                    view = "EditBook";
                    break;
            }
        }
        return mapping.findForward(view);
    }
    
     private String EditBook(HttpServletRequest request, HttpServletResponse response,BookValidatorForm form){        
        String view = "EditBook";
         
        IBookBean book = BeanFactory.getInstance().getBookBean();
                 
        book.setAuthor(form.getAuthor());
        book.setTitle(form.getTitle());
        book.setEditorial(form.getEditorial());
        book.setISBN(request.getParameter("ISBN"));
        book.setPublicationYear(form.getPublicationYear());
        book.setPrice(form.getPrice());
        book.setDescription(form.getDescription());
          
         Boolean result = ServiceFactory.getInstance().getBookService().ModifyBook(book);
         
         String message = "Book " + book.getISBN() + " ";
        if(result){
            request.setAttribute("list", ServiceFactory.getInstance().getBusinessFacade().getAllBooks());
            view = "ModifyBookList";
            message += "edited successfully";
        }else{
            view = "EditBook";
            message += "not edited";
        }

        request.setAttribute("message", message);
        return view;
     }
}
