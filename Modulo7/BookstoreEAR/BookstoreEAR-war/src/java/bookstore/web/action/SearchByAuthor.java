package bookstore.web.action;

import ejb.logic.facade.IBusinessFacade;
import ejb.bean.book.IBookBean;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */
public class SearchByAuthor extends HttpServlet {

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
        String authorName = request.getParameter("authorName");
        if(authorName != null){
            List<IBookBean> list = facade.getBookByAuthor(authorName);
            request.setAttribute("author", authorName);
            request.setAttribute("list", list);
            
            request.getRequestDispatcher("/jsp/BooksList.jsp").forward(request, response);
        }else{
            List<String> list = facade.getAllAuthors();
            request.setAttribute("list", list);
        
            request.getRequestDispatcher("/jsp/AuthorSearchForm.jsp").forward(request, response);
        }
    }
}
