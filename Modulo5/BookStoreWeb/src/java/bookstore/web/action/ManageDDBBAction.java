package bookstore.web.action;

import bookstore.logic.bean.book.IBookBean;
import bookstore.logic.bean.factory.BeanFactory;
import bookstore.logic.service.ServiceFactory;
import bookstore.web.actionform.ManageDDBBActionForm;
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
public class ManageDDBBAction extends Action {

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
        String view = "ManageDDBB";
        String action = request.getParameter("action");
        if(action != null){
            switch(action){
                case "ADD_BOOK":
                    view = addBook(request,response,(ManageDDBBActionForm)form);
                    break;
                case "DELETE_BOOK":
                    view = deleteBook(request,response,(ManageDDBBActionForm)form);
                    break;
                case "EDIT_BOOK":
                    view = editBook(request,response,(ManageDDBBActionForm)form);
                    break;
                default:
                    view = list(request,response,(ManageDDBBActionForm)form);
                    break;
            }
        }else{
            view = list(request,response,(ManageDDBBActionForm)form);
        }
        
        return mapping.findForward(view);
    }
    
    private String editBook(HttpServletRequest request, HttpServletResponse response,ManageDDBBActionForm form){
        String message;
        
        String ISBN = form.getISBN();
        String title = form.getTitle();
        String author = form.getAuthor();
        String editorial = form.getEditorial();
        int publicationYear = form.getPublicationYear();
        double price = form.getPrice();
        String description = form.getDescription();
        
        if(true){ //IS VALID?
            try{
                
                IBookBean book = BeanFactory.getInstance().getBookBean();
                book.setTitle(title);
                book.setAuthor(author);
                book.setEditorial(editorial);
                book.setISBN(ISBN);
                book.setPublicationYear(publicationYear);
                book.setPrice(price);
                book.setDescription(description);
                
                boolean result = ServiceFactory.getInstance().getBusinessFacade().ModifyBook(book);
                message = "Book " + ISBN + " ";
                if(result){
                    message += "edited successfully";
                }else{
                    message += "not edited";
                }
            }catch(Exception e){
                message = "Error: Invalid inputs. Book not edited.";
            }

        }else{
            message = "Error: ISBN can not be empty";
        }
        request.setAttribute("message", message);
        
        List<IBookBean> list = ServiceFactory.getInstance().getBusinessFacade().getAllBooks();
        form.setList(list);
        return "ManageDDBB";
    }
    
    private String addBook(HttpServletRequest request, HttpServletResponse response,ManageDDBBActionForm form){
        String message;
        
        String ISBN = form.getISBN();
        String title = form.getTitle();
        String author = form.getAuthor();
        String editorial = form.getEditorial();
        int publicationYear = form.getPublicationYear();
        double price = form.getPrice();
        String description = form.getDescription();
        
        if(true){ //IS VALID?
            try{
                IBookBean book = BeanFactory.getInstance().getBookBean();
                book.setTitle(title);
                book.setAuthor(author);
                book.setEditorial(editorial);
                book.setISBN(ISBN);
                book.setPublicationYear(publicationYear);
                book.setPrice(price);
                book.setDescription(description);
                
                boolean result = ServiceFactory.getInstance().getBusinessFacade().NewBook(book);
                message = "Book " + ISBN + " ";
                if(result){
                    message += "added successfully";
                }else{
                    message += "not added";
                }
            }catch(Exception e){
                message = "Error: Invalid inputs. Book not added.";
            }

        }else{
            message = "Error: ISBN can not be empty";
        }
        request.setAttribute("message", message);
        
        List<IBookBean> list = ServiceFactory.getInstance().getBusinessFacade().getAllBooks();
        form.setList(list);
        return "ManageDDBB";
    }
    
    private String deleteBook(HttpServletRequest request, HttpServletResponse response,ManageDDBBActionForm form){
        String message = "";
        String ISBN = form.getISBN();
        if(ISBN != null && !ISBN.equals("")){
            boolean result = ServiceFactory.getInstance().getBusinessFacade().DeleteBook(ISBN);
            message = "Book " + ISBN + " ";
            if(result){
                message += "deleted successfully";
            }else{
                message += "not deleted";
            }
        }else{
            message = "Error: ISBN can not be empty";
        }
        
        request.setAttribute("message", message);
        
        List<IBookBean> list = ServiceFactory.getInstance().getBusinessFacade().getAllBooks();
        form.setList(list);
        return "ManageDDBB";
    }
    
    private String list(HttpServletRequest request, HttpServletResponse response,ManageDDBBActionForm form){
        List<IBookBean> list = ServiceFactory.getInstance().getBusinessFacade().getAllBooks();
        form.setList(list);
        return "ManageDDBB";
    }
    
    private boolean isValid(String value){
        return value != null && !value.equals("");
    }

}
