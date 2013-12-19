package bookstore.presentation.controller.actions;

import bookstore.logic.bean.book.IBookBean;
import bookstore.logic.service.ServiceFactory;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */
public class SearchByTitle extends HttpServlet {

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String title = request.getParameter("title");
        if(title != null){
            List<IBookBean> list =ServiceFactory.getInstance().getBusinessFacade().getBookByTitle(title);
            request.setAttribute("title", title);
            request.setAttribute("list", list);
            
            request.getRequestDispatcher("/jsp/BooksList.jsp").forward(request, response);
        }else{
            request.getRequestDispatcher("/jsp/SearchByTitleForm.jsp").forward(request, response);
        }
    }

}
