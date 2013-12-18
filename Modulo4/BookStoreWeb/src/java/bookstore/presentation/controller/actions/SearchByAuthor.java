package bookstore.presentation.controller.actions;

import bookstore.logic.bean.book.IBeanBook;
import bookstore.logic.service.ServiceFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author palbaladejo
 */
public class SearchByAuthor extends HttpServlet {

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
            List<IBeanBook> list = ServiceFactory.getInstance().getBusinessFacade().getBookByAuthor(authorName);
            request.setAttribute("author", authorName);
            request.setAttribute("list", list);
            
            request.getRequestDispatcher("/jsp/BooksList.jsp").forward(request, response);
        }else{
            List<String> list = ServiceFactory.getInstance().getBusinessFacade().getAllAuthors();
            request.setAttribute("list", list);
        
            request.getRequestDispatcher("/jsp/AuthorSearchForm.jsp").forward(request, response);
        }
    }
}
