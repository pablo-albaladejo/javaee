package bookstore.web.action;

import bookstore.logic.bean.book.IBookBean;
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
public class SearchByEditorialAction extends Action {

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

        String editorialName = request.getParameter("editorialName");
        
        if(editorialName != null){
            List<IBookBean> list = ServiceFactory.getInstance().getBusinessFacade().getBookByEditorial(editorialName);
            request.setAttribute("editorial", editorialName);
            request.setAttribute("list", list);
            
            return mapping.findForward("BooksList");
        }else{
            List<String> list = ServiceFactory.getInstance().getBusinessFacade().getAllEditorials();
            request.setAttribute("list", list);
        
            return mapping.findForward("EditorialSearchForm");
        }
    }
}
