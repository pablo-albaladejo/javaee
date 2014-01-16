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
public class ManageDDBB extends Action {

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
        String view = "ManageDDBB";
        
        String action = request.getParameter("action");
        if(action != null){
            switch(action){
                case "ADD_BOOK":
                    view = addBook(request, response);
                    break;
                case "DELETE_BOOK":
                    view = deleteBook(request, response);
                    break;
                case "EDIT_BOOK":
                    view = editBook(request, response);
                    break;
                default:
                    view = list(request, response);
                    break;
            }
        }else{
            view = list(request, response);
        }
        
        return mapping.findForward(view);
    }
    
    private String editBook(HttpServletRequest request, HttpServletResponse response){
        
        String message;
        
        String ISBN = request.getParameter("ISBN");
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String editorial = request.getParameter("editorial");
        String publicationYear = request.getParameter("publicationYear");
        String price = request.getParameter("price");
        String description = request.getParameter("description");
        
        if(isValid(ISBN) && isValid(title) && isValid(author) && isValid(editorial)
                && isValid(publicationYear) && isValid(price) && isValid(description)){
            try{
                int publicationYearInt = Integer.parseInt(publicationYear);
                double priceDouble = Double.parseDouble(price);
                
                IBookBean book = BeanFactory.getInstance().getBookBean();
                book.setTitle(title);
                book.setAuthor(author);
                book.setEditorial(editorial);
                book.setISBN(ISBN);
                book.setPublicationYear(publicationYearInt);
                book.setPrice(priceDouble);
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
        request.setAttribute("list", list);
        return "ManageDDBB";
    }
    
    private String addBook(HttpServletRequest request, HttpServletResponse response){
        String message;
        
        String ISBN = request.getParameter("ISBN");
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String editorial = request.getParameter("editorial");
        String publicationYear = request.getParameter("publicationYear");
        String price = request.getParameter("price");
        String description = request.getParameter("description");
        
        if(isValid(ISBN) && isValid(title) && isValid(author) && isValid(editorial)
                && isValid(publicationYear) && isValid(price) && isValid(description)){
            try{
                int publicationYearInt = Integer.parseInt(publicationYear);
                double priceDouble = Double.parseDouble(price);
                
                IBookBean book = BeanFactory.getInstance().getBookBean();
                book.setTitle(title);
                book.setAuthor(author);
                book.setEditorial(editorial);
                book.setISBN(ISBN);
                book.setPublicationYear(publicationYearInt);
                book.setPrice(priceDouble);
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
        request.setAttribute("list", list);
        return "ManageDDBB";
    }
    
    private String deleteBook(HttpServletRequest request, HttpServletResponse response){
        String message = "";
        String ISBN = request.getParameter("ISBN");
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
        request.setAttribute("list", list);
        return "ManageDDBB";
    }
    
    private String list(HttpServletRequest request, HttpServletResponse response){
        List<IBookBean> list = ServiceFactory.getInstance().getBusinessFacade().getAllBooks();
        request.setAttribute("list", list);
        return "ManageDDBB";
    }
    
    private boolean isValid(String value){
        return value != null && !value.equals("");
    }

}
